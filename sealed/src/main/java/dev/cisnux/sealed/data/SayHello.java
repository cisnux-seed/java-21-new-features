package dev.cisnux.sealed.data;

public sealed interface SayHello permits Human, Dog, Cat{

  String hello();
}
