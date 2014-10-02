package net.telepay.api.core;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;
import java.util.Random;

public class SignerV1 implements Signer {

    private static final String SIGNATURE_HEADER_NAME = "X-Signature";
    private Credentials credentials;

    public SignerV1(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public Request sign(Request request) {
        Map<String, String> headersWithSignature = request.getHeaders();

        headersWithSignature.put(SIGNATURE_HEADER_NAME, getXSignatureHeaderString(credentials));

        return new ApiRequest(
                request.getBaseUrl(),
                request.getFunction(),
                request.getUrlParams(),
                request.getMethod(),
                request.getParams(),
                headersWithSignature
        );
    }
    private String getXSignatureHeaderString(Credentials credentials){
        String access_key = credentials.getAccessKey();
        String access_secret = credentials.getAccessSecret();

        String nonce = Integer.toString(Math.abs(new Random().nextInt()));
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        String version = "1";
        String stringToSign = access_key + nonce + timestamp;
        String signature = hmacSha256(stringToSign, access_secret);

        StringBuilder sb = new StringBuilder("Signature ");
        sb.append("access-key=\""+access_key+"\", ");
        sb.append("nonce=\""+nonce+"\", ");
        sb.append("timestamp=\""+timestamp+"\", ");
        sb.append("version=\""+version+"\", ");
        sb.append("signature=\""+signature+"\"");

        return sb.toString();
    }

    private static String hmacSha256(String value, String key) {
        try {
            // Get an hmac_sha1 key from the raw key bytes
            byte[] keyBytes = Base64.decodeBase64(key);
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA256");

            // Get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(value.getBytes());

            // Convert raw bytes to Hex
            byte[] hexBytes = new Hex().encode(rawHmac);

            //  Covert array of Hex bytes to a String
            return new String(hexBytes, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
