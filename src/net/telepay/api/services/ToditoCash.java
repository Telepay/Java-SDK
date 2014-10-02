package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ToditoCash extends Service {
    public ToditoCash(Credentials credentials, String env) {
        super(credentials, env);
    }

    public Response request(
            String transaction_id,
            String date,
            String hour,
            String card_number,
            String nip,
            String amount,
            String concept,
            String currency
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("transaction_id", transaction_id);
        params.put("date", date);
        params.put("hour", hour);
        params.put("card_number", card_number);
        params.put("nip", nip);
        params.put("amount", amount);
        params.put("concept", concept);
        params.put("currency", currency);
        return this.call(
                "services/v1/toditocash/payservices/request",
                "POST",
                null,
                null,
                params
        );
    }

    public Response status(
            String transaction_id,
            String tc_number_transaction,
            String date,
            String hour,
            String card_number,
            String amount
    ) throws IOException {
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("transaction_id", transaction_id);
        urlParams.put("tc_number_transaction", tc_number_transaction);
        urlParams.put("date", date);
        urlParams.put("hour", hour);
        urlParams.put("card_number", card_number);
        urlParams.put("amount", amount);
        return this.call(
                "services/v1/toditocash/payservices/status",
                "GET",
                null,
                urlParams,
                null
        );
    }
}
