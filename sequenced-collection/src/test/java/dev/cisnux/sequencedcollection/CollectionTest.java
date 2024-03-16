package dev.cisnux.sequencedcollection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {
    @Test
    void collection() {
        final var list = new ArrayList<String>();
        list.addLast("Cisnux"); // cisnux
        list.addFirst("Fajra"); // fajra cisnux
        list.addFirst("Risqulla"); // risqulla fajra cisnux

        Assertions.assertEquals(List.of("Risqulla", "Fajra", "Cisnux"), list);
        Assertions.assertEquals("Risqulla", list.getFirst());
        Assertions.assertEquals("Cisnux", list.getLast());

        Assertions.assertEquals(List.of("Cisnux", "Fajra", "Risqulla"), list.reversed());
        Assertions.assertEquals("Risqulla", list.removeFirst());
        Assertions.assertEquals(List.of("Fajra", "Cisnux"), list);
        Assertions.assertEquals("Cisnux", list.removeLast());
        Assertions.assertEquals(List.of("Fajra"), list);
    }
}
