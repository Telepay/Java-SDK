package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PaynetPayment extends Service {
    public PaynetPayment(Credentials credentials, String env) {
        super(credentials, env);
    }

    public Response info(
            String date,
            String hour,
            String transaction_id,
            String sku,
            String reference
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("date", date);
        params.put("hour", hour);
        params.put("transaction_id", transaction_id);
        params.put("sku", sku);
        params.put("reference", reference);

        return this.call(
                "services/v1/paynet/payment/info",
                "POST",
                null,
                null,
                params
        );
    }

    public Response transaction(
            String date,
            String hour,
            String transaction_id,
            String sku,
            String fee,
            String reference,
            String amount,
            String dv
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("date", date);
        params.put("hour", hour);
        params.put("transaction_id", transaction_id);
        params.put("sku", sku);
        params.put("fee", fee);
        params.put("reference", reference);
        params.put("amount", amount);
        params.put("dv", dv);

        return this.call(
                "services/v1/paynet/payment/transaction",
                "POST",
                null,
                null,
                params
        );
    }

    public Response status(
            String date,
            String hour,
            String transaction_id,
            String sku,
            String reference,
            String amount
    ) throws IOException {
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("date", date);
        urlParams.put("hour", hour);
        urlParams.put("transaction_id", transaction_id);
        urlParams.put("sku", sku);
        urlParams.put("reference", reference);
        urlParams.put("amount", amount);

        return this.call(
                "services/v1/paynet/payment/status",
                "GET",
                null,
                urlParams,
                null
        );
    }

}
