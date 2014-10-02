package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;

public class Sample extends Service {
    public Sample(Credentials credentials, String env) {
        super(credentials, env);
    }

    public Response make() throws IOException {
        return this.call("services/v1/sample", "GET", null, null, null);
    }
}
