package net.telepay.api.core;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest implements Request {


    private String baseUrl;
    private String function;
    private Map<String, String> urlParams;
    private String method;
    private Map<String, String> params;
    private Map<String, String> headers;

    public ApiRequest(String baseUrl, String function, Map<String, String> urlParams, String method, Map<String, String> params, Map<String, String> headers) {
        this.baseUrl = baseUrl;
        this.function = function;
        this.urlParams = urlParams == null?new HashMap<String, String>():urlParams;
        this.method = method;
        this.params = params == null?new HashMap<String, String>():params;
        this.headers = headers == null?new HashMap<String, String>():headers;
    }


    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public String getFunction() {
        return function;
    }

    @Override
    public Map<String, String> getUrlParams() {
        return urlParams;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }
}
