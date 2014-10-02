package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PayU extends Service {
    public PayU(Credentials credentials, String env) {
        super(credentials, env);
    }

    public Response cash(
            String name,
            String country,
            String reference_code,
            String currency,
            String description,
            String amount,
            String pay_method,
            String payer_dni
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("country", country);
        params.put("reference_code", reference_code);
        params.put("currency", currency);
        params.put("description", description);
        params.put("amount", amount);
        params.put("pay_method", pay_method);
        params.put("payer_dni", payer_dni);

        return this.call(
                "services/v1/payu/payment/cash",
                "POST",
                null,
                null,
                params
        );
    }

    public Response transaction(
            String name,
            String country,
            String reference_code,
            String currency,
            String description,
            String amount,
            String card_number,
            String expiration_date,
            String without_cvv2,
            String cvv,
            String payment_method,
            String tax_base,
            String tax_value
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("country", country);
        params.put("reference_code", reference_code);
        params.put("currency", currency);
        params.put("description", description);
        params.put("amount", amount);
        params.put("card_number", card_number);
        params.put("expiration_date", expiration_date);
        params.put("without_cvv2", without_cvv2);
        params.put("cvv", cvv);
        params.put("payment_method", payment_method);
        params.put("tax_base", tax_base);
        params.put("tax_value", tax_value);

        return this.call(
                "services/v1/payu/payment/transaction",
                "POST",
                null,
                null,
                params
        );
    }

    public Response report(
            String report_type,
            String code
    ) throws IOException {
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("report_type", report_type);
        urlParams.put("code", code);
        return this.call(
                "services/v1/payu/payment/report",
                "GET",
                null,
                urlParams,
                null
        );
    }

}
