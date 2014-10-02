package net.telepay.api.core;

public interface Signer {
  public Request sign(Request request);
}
