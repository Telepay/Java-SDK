package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PaynetReference extends Service {
    public PaynetReference(Credentials credentials, String env) {
        super(credentials, env);
    }

    /**
     * Generates a reference code
     * @param client_reference
     * @param amount
     * @param description
     * @return
     * @throws IOException
     */
    public Response generate(
            String client_reference,
            String amount,
            String description
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("client_reference", client_reference);
        params.put("amount", amount);
        params.put("description", description);

        return this.call(
                "services/v1/paynet/reference/generate",
                "POST",
                null,
                null,
                params
        );
    }

    /**
     * Gets the status of a generated reference
     * @param client_reference
     * @return
     * @throws IOException
     */
    public Response status(String client_reference) throws IOException {
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("client_reference", client_reference);
        return this.call(
                "services/v1/paynet/reference/status",
                "GET",
                null,
                urlParams,
                null
        );
    }
}
