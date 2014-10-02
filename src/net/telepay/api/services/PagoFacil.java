package net.telepay.api.services;

import net.telepay.api.core.Credentials;
import net.telepay.api.responses.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PagoFacil extends Service {
    public PagoFacil(Credentials credentials, String env) {
        super(credentials, env);
    }

    public Response transaction(
            String name,
            String surname,
            String card_number,
            String cvv,
            String cp,
            String expiration_month,
            String expiration_year,
            String amount,
            String mail,
            String phone,
            String mobile_phone,
            String street_number,
            String colony,
            String city,
            String quarter,
            String country,
            String transaction_id
    ) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("surname", surname);
        params.put("card_number", card_number);
        params.put("cvv", cvv);
        params.put("cp", cp);
        params.put("expiration_month", expiration_month);
        params.put("expiration_year", expiration_year);
        params.put("amount", amount);
        params.put("mail", mail);
        params.put("phone", phone);
        params.put("mobile_phone", mobile_phone);
        params.put("street_number", street_number);
        params.put("colony", colony);
        params.put("city", city);
        params.put("quarter", quarter);
        params.put("country", country);
        params.put("transaction_id", transaction_id);

        return this.call(
                "services/v1/pagofacil/payment/transaction",
                "POST",
                null,
                null,
                params
        );
    }

    public Response status(String transaction_id) throws IOException {
        Map<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("transaction_id", transaction_id);
        return this.call(
                "services/v1/pagofacil/payment/status",
                "GET",
                null,
                urlParams,
                null
        );
    }
}
