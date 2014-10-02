package net.telepay.api.responses;

import com.google.gson.JsonObject;
import com.sun.org.apache.xerces.internal.parsers.XMLParser;
import com.sun.org.apache.xerces.internal.xni.parser.XMLPullParserConfiguration;

import javax.xml.crypto.dsig.XMLObject;


public class BaseResponse implements Response{

    private int code;
    private String message;
    private JsonObject data;

    public BaseResponse(int code, String message, JsonObject data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public JsonObject getData() {
        return data;
    }
}
