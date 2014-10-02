package net.telepay.api.core;

import java.util.Map;

public interface Request {
    public String getBaseUrl();
    public String getFunction();
    public Map<String, String> getUrlParams();
    public String getMethod();
    public Map<String, String> getParams();
    public Map<String, String> getHeaders();
}
