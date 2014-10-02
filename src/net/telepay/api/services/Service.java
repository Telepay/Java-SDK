package net.telepay.api.services;

import net.telepay.api.core.*;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Service {

    private Credentials credentials;
    private String url;

    public Service(Credentials credentials, String url) {
        this.credentials=credentials;
        this.url =url;
    }


    protected Response call(String function, String method, Map<String, String> headers, Map<String, String> urlParams, Map<String, String> params) throws IOException {
        ApiRequest plainRequest = new ApiRequest(
                this.url, function, urlParams, method, params, headers
        );

        Signer signer = new SignerV1(this.credentials);
        Request signedRequest = signer.sign(plainRequest);
        Requester requester = new JsonRequester();
        return requester.send(signedRequest);
    }
}
