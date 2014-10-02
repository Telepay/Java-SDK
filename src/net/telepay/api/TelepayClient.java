package net.telepay.api;

import net.telepay.api.core.Credentials;
import net.telepay.api.services.*;


public class TelepayClient {

    private static final String CLIENT_VERSION = "0.9";
    private Credentials credentials;
    private String url;

    public TelepayClient(Credentials credentials, String env){
        this.credentials=credentials;
        if(env.equalsIgnoreCase("real")) this.url = "https://api.telepay.net";
        else if(env.equalsIgnoreCase("test")) this.url = "https://api.telepay.net/test";
        else throw new NullPointerException("Environment should be 'test' or 'real'");
    }

    public TelepayClient(Credentials credentials){
        this(credentials,"real");
    }

    public String getVersion(){
        return CLIENT_VERSION;
    }

    public Sample getSample(){
        return new Sample(this.credentials, this.url);
    }
    public PagoFacil getPagoFacil(){
        return new PagoFacil(this.credentials, this.url);
    }
    public PaynetReference getPaynetReference(){
        return new PaynetReference(this.credentials, this.url);
    }
    public SafetyPay getSafetyPay(){
        return new SafetyPay(this.credentials, this.url);
    }
    public ToditoCash getToditoCash(){
        return new ToditoCash(this.credentials, this.url);
    }
    public Ukash getUkash(){
        return new Ukash(this.credentials, this.url);
    }
}
