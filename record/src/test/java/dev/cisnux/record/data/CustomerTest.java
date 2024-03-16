package dev.cisnux.record.data;

import org.junit.jupiter.api.Test;

import java.lang.reflect.RecordComponent;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void createNewRecord() {
        var customer = new Customer("1", "Fajra", "fajra@localhost", "082131231");
        assertNotNull(customer);

        System.out.println(customer);
    }

    @Test
    void getProperty() {
        var customer = new Customer("1", "Fajra", "fajra@localhost", "082131231");
        assertNotNull(customer);
        assertEquals("1", customer.id());
        assertEquals("Fajra", customer.name());
        assertEquals("fajra@localhost", customer.email());
        assertEquals("082131231", customer.phone());
    }

    @Test
    void constructor() {
        var customer = new Customer("1", "aajra", "fajra@localhost");
        assertNotNull(customer);
        assertEquals("1", customer.id());
        assertEquals("Fajra", customer.name());
        assertEquals("fajra@localhost", customer.email());
        assertNull(customer.phone());
    }

    @Test
    void canonicalConstructor() {
        var customer = new Customer("1", "Fajra", "FAJRA@GMAIL.com");
        assertNotNull(customer);
        assertEquals("1", customer.id());
        assertEquals("fajra", customer.name());
        assertEquals("fajra@gmail.com", customer.email());
        assertNull(customer.phone());
    }

    @Test
    void recordMethod() {
        var customer = new Customer("1", "Fajra", "fajra@gmail.com");
        assertEquals("Hello Budi, my name is Fajra", customer.sayHello("Budi"));
    }

    @Test
    void recordEquals() {
        var customer1 = new Customer("1", "Fajra", "fajra@localhost");
        var customer2 = new Customer("1", "Fajra", "fajra@localhost");

        assertEquals(customer1, customer2);
        assertEquals(customer1.hashCode(), customer2.hashCode());
        assertEquals(customer1.toString(), customer2.toString());
    }

    @Test
    void reflection() {
        assertTrue(Customer.class.isRecord());

        RecordComponent[] components = Customer.class.getRecordComponents();
        assertEquals(4, components.length);

        for (RecordComponent component : components) {
            System.out.println(component.getName());
            System.out.println(component.getType());
        }
    }
}
