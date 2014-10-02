package net.telepay.api.core;

public class UserCredentials implements Credentials {

    private String publicId;
    private String secret;

    public UserCredentials(String publicId, String secret) {
        this.publicId = publicId;
        this.secret = secret;
    }

    @Override
    public String getAccessKey() {
        return publicId;
    }

    @Override
    public String getAccessSecret() {
        return secret;
    }
}
