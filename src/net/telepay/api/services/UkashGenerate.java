package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UkashGenerate extends Service {
    public UkashGenerate(Credentials credentials, String env) {
        super(credentials, env);
    }

    public Response request(
            String merchant_id,
            String currency,
            String transaction_id,
            String amount
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("merchant_id", merchant_id);
        params.put("currency", currency);
        params.put("transaction_id", transaction_id);
        params.put("amount",amount);
        return this.call(
                "services/v1/ukash/generate",
                "POST",
                null,
                null,
                params
        );
    }

}
