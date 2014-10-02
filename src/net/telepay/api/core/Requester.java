package net.telepay.api.core;

import net.telepay.api.responses.Response;

import java.io.IOException;

public interface Requester {
    public Response send(Request request) throws IOException;
}
