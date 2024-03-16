package dev.cisnux.sealed.data;

public record Dog() implements SayHello {
  @Override
  public String hello() {
    return "guk";
  }
}
