package dev.cisnux.record.data;

import java.util.Optional;

public record Customer(String id, String name, String email, String phone) implements SayHello {

  public Customer(String id, String name, String email, String phone) {
    System.out.println("Create Customer");
    this.id = id.toLowerCase();
    this.name = Optional.ofNullable(name)
            .map(String::toLowerCase)
            .orElse(null);
    this.email = Optional.ofNullable(email)
            .map(String::toLowerCase)
            .orElse(null);
    this.phone = phone;
  }

  public Customer(String id, String name, String email) {
    this(id, name, email, null);
  }

  public Customer(String id, String name) {
    this(id, name, null);
  }

  @Override
  public String sayHello(String name) {
    return "Hello " + name + ", my name is " + this.name;
  }
}
