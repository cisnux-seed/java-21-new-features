package dev.cisnux.sequencedcollection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    @Test
    void set() {
        final var set = new TreeSet<String>();
        set.add("Risqulla"); // risqulla
        set.add("Cisnux"); // cisnux risqulla
        set.add("Fajra"); // cisnux fajra risqulla

        Assertions.assertEquals(Set.of("Cisnux", "Fajra", "Risqulla"), set);
        Assertions.assertEquals("Cisnux", set.getFirst());
        Assertions.assertEquals("Risqulla", set.getLast());

        Assertions.assertEquals(Set.of("Risqulla", "Fajra", "Cisnux"), set.reversed());
        Assertions.assertEquals("Cisnux", set.removeFirst());
        Assertions.assertEquals(Set.of("Fajra", "Risqulla"), set);
        Assertions.assertEquals("Risqulla", set.removeLast());
        Assertions.assertEquals(Set.of("Fajra"), set);
    }

    @Test
    void setLinkedList() {
        final var set = new LinkedHashSet<String>();
        set.addLast("Cisnux"); // cisnux
        set.addFirst("Fajra"); // fajra cisnux
        set.addFirst("Risqulla"); // risqulla fajra cisnux

        Assertions.assertEquals(Set.of("Risqulla", "Fajra", "Cisnux"), set);
        Assertions.assertEquals("Risqulla", set.getFirst());
        Assertions.assertEquals("Cisnux", set.getLast());

        Assertions.assertEquals(Set.of("Cisnux", "Fajra", "Risqulla"), set.reversed());
        Assertions.assertEquals("Risqulla", set.removeFirst());
        Assertions.assertEquals(Set.of("Fajra", "Cisnux"), set);
        Assertions.assertEquals("Cisnux", set.removeLast());
        Assertions.assertEquals(Set.of("Fajra"), set);
    }
}
