package net.telepay.api.core;

import com.google.gson.Gson;
import net.telepay.api.responses.BaseResponse;
import net.telepay.api.responses.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Form;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class JsonRequester implements Requester {

    org.apache.http.client.fluent.Request fluentRequest;


    @Override
    public Response send(Request request) throws IOException {

        final StringBuilder finalUrlBuilder = new StringBuilder();
        finalUrlBuilder.append(request.getBaseUrl() + "/" + request.getFunction());

            if(request.getUrlParams().size() > 0){
                finalUrlBuilder.append('?');
            }

            for (String paramName : request.getUrlParams().keySet()) {
                finalUrlBuilder.append(
                        paramName+'='+request.getUrlParams().get(paramName)
                );
            }


            final String finalUrl = finalUrlBuilder.toString();

        if (request.getMethod().toUpperCase().equals("GET")) {
            fluentRequest = org.apache.http.client.fluent.Request.Get(finalUrl);
        }
        else{
            if (request.getMethod().toUpperCase().equals("POST")) {
                fluentRequest = org.apache.http.client.fluent.Request.Post(finalUrl);
            } else if (request.getMethod().toUpperCase().equals("PUT")) {
                fluentRequest = org.apache.http.client.fluent.Request.Put(finalUrl);
            } else if (request.getMethod().toUpperCase().equals("DELETE")) {
                fluentRequest = org.apache.http.client.fluent.Request.Delete(finalUrl);
            }
            Form tmpForm = Form.form();
            for (String paramName : request.getParams().keySet()) {
                tmpForm.add(
                        paramName, request.getParams().get(paramName)
                );
            }
            fluentRequest.bodyForm(tmpForm.build());
        }

        for (String headerName : request.getHeaders().keySet()) {
            fluentRequest.addHeader(
                    headerName, request.getHeaders().get(headerName)
            );
        }


        fluentRequest.userAgent("TelepayApi java-sdk-agent v1");

        HttpResponse response = fluentRequest.execute().returnResponse();

        int code = response.getStatusLine().getStatusCode();

        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        response.getEntity().writeTo(outstream);
        return gson.fromJson(outstream.toString(), BaseResponse.class);
    }

}
