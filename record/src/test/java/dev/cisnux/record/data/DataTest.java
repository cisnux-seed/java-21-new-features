package dev.cisnux.record.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataTest {

  @Test
  void generic() {
    var data = new Data<String>("fajra");
    assertEquals("fajra", data.data());

    var data2 = new Data<Integer>(100);
    assertEquals(100, data2.data());
  }
}
