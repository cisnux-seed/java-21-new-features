package dev.cisnux.sequencedcollection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
    @Test
    void map() {
        final var map = new TreeMap<Character, String>();
        map.put('b',"Cisnux"); // cisnux
        map.put('a',"Fajra"); // fajra cisnux
        map.put('c',"Risqulla"); // fajra cisnux risqulla

        Assertions.assertEquals("Fajra", map.firstEntry().getValue());
        Assertions.assertEquals("Risqulla", map.lastEntry().getValue());

        final var reversedMap = map.reversed();
        Assertions.assertEquals(Map.of('c', "Risqulla", 'b', "Cisnux", 'a', "Fajra"), reversedMap);
        Assertions.assertEquals("Risqulla", reversedMap.firstEntry().getValue());
        Assertions.assertEquals("Fajra", reversedMap.lastEntry().getValue());
    }

    @Test
    void linkedMap() {
        final var map = new LinkedHashMap<Character, String>();
        map.put('b',"Cisnux"); // cisnux
        map.put('a',"Fajra"); // cisnux fajra
        map.put('c',"Risqulla"); // cisnux fajra risqulla

        Assertions.assertEquals("Cisnux", map.firstEntry().getValue());
        Assertions.assertEquals("Risqulla", map.lastEntry().getValue());

        final var reversedMap = map.reversed();
        Assertions.assertEquals(Map.of('c', "Risqulla", 'a', "Fajra", 'b', "Cisnux"), reversedMap);
        Assertions.assertEquals("Risqulla", reversedMap.firstEntry().getValue());
        Assertions.assertEquals("Cisnux", reversedMap.lastEntry().getValue());
    }
}
