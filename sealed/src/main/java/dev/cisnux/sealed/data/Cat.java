package dev.cisnux.sealed.data;

public record Cat()implements SayHello {
  @Override
  public String hello() {
    return "meow";
  }
}
