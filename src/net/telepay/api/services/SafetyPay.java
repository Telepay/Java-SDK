package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SafetyPay extends Service {
    public SafetyPay(Credentials credentials, String env) {
        super(credentials, env);
    }

    public Response request(
            String date_time,
            String currency,
            String amount,
            String url_success,
            String url_fail
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("date_time", date_time);
        params.put("currency", currency);
        params.put("amount", amount);
        params.put("url_success", url_success);
        params.put("url_fail", url_fail);
        return this.call(
                "services/v1/safetypay/payment/request",
                "POST",
                null,
                null,
                params
        );
    }
}
