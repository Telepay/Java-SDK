package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ukash extends Service {
    public Ukash(Credentials credentials, String env) {
        super(credentials, env);
    }

    public Response request(
            String amount,
            String transaction_id,
            String consumer_id,
            String currency,
            String url_succes,
            String url_fail,
            String url_notification
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("amount", amount);
        params.put("transaction_id", transaction_id);
        params.put("consumer_id", consumer_id);
        params.put("currency", currency);
        params.put("url_succes", url_succes);
        params.put("url_fail", url_fail);
        params.put("url_notification", url_notification);
        return this.call(
                "services/v1/ukash/redirect/request",
                "POST",
                null,
                null,
                params
        );
    }

    public Response status(String utid) throws IOException {
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("utid", utid);
        return this.call(
                "services/v1/ukash/redirect/status",
                "GET",
                null,
                urlParams,
                null
        );
    }
}
