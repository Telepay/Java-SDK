package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UkashRedemption extends Service {
    public UkashRedemption(Credentials credentials, String env) {
        super(credentials, env);
    }

    public Response request(
            String merchant_id,
            String currency,
            String transaction_id,
            String voucher_value,
            String voucher_number,
            String transaction_amount
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("merchant_id", merchant_id);
        params.put("currency", currency);
        params.put("transaction_id", transaction_id);
        params.put("voucher_value", voucher_value);
        params.put("voucher_number", voucher_number);
        params.put("transaction_amount", transaction_amount);
        return this.call(
                "services/v1/ukash/redemption",
                "POST",
                null,
                null,
                params
        );
    }

    public Response status(
            String transaction_id,
            String currency,
            String voucher_number,
            String voucher_value,
            String transaction_amount
    ) throws IOException {
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("transaction_id", transaction_id);
        urlParams.put("currency", currency);
        urlParams.put("voucher_number", voucher_number);
        urlParams.put("voucher_value", voucher_value);
        urlParams.put("transaction_amount", transaction_amount);

        return this.call(
                "services/v1/ukash/redemption/status",
                "GET",
                null,
                urlParams,
                null
        );
    }

}
