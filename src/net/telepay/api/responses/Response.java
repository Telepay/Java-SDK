package net.telepay.api.responses;

import com.google.gson.JsonObject;

public interface Response {
    public int getCode();
    public String getMessage();
    public JsonObject getData();
}
