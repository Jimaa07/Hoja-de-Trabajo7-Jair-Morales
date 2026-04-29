package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AssociationTest {

    private Association<String, String> association;

    @BeforeEach
    void setUp() {
        association = new Association<>("hello", "hola");
    }

    @Test
    @DisplayName("getKey() debe retornar la clave correcta")
    void testGetKey() {
        assertEquals("hello", association.getKey());
    }

    @Test
    @DisplayName("getValue() debe retornar el valor correcto")
    void testGetValue() {
        assertEquals("hola", association.getValue());
    }

    @Test
    @DisplayName("compareTo() debe retornar 0 cuando las claves son iguales")
    void testCompareToEqual() {
        Association<String, String> other = new Association<>("hello", "otro");
        assertEquals(0, association.compareTo(other));
    }

    @Test
    @DisplayName("compareTo() debe retornar negativo cuando la clave es menor")
    void testCompareToLessThan() {
        Association<String, String> other = new Association<>("world", "mundo");
        assertTrue(association.compareTo(other) < 0);
    }

    @Test
    @DisplayName("compareTo() debe retornar positivo cuando la clave es mayor")
    void testCompareToGreaterThan() {
        Association<String, String> other = new Association<>("apple", "manzana");
        assertTrue(association.compareTo(other) > 0);
    }

    @Test
    @DisplayName("toString() debe retornar formato (key, value)")
    void testToString() {
        assertEquals("(hello, hola)", association.toString());
    }

    @Test
    @DisplayName("Association con clave entera debe funcionar correctamente")
    void testWithIntegerKey() {
        Association<Integer, String> intAssoc = new Association<>(42, "cuarenta y dos");
        assertEquals(42, intAssoc.getKey());
        assertEquals("cuarenta y dos", intAssoc.getValue());
    }

    @Test
    @DisplayName("Association con valor nulo debe permitirse")
    void testWithNullValue() {
        Association<String, String> nullVal = new Association<>("key", null);
        assertNull(nullVal.getValue());
    }
}
