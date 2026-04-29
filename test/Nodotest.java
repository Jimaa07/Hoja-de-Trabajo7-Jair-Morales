package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Nodo.
 * Verifica la inicialización correcta de datos y punteros.
 */
public class NodoTest {

    @Test
    @DisplayName("Nodo nuevo debe tener los hijos en null")
    void testInitialChildrenAreNull() {
        Nodo<Integer> nodo = new Nodo<>(10);
        assertNull(nodo.left,  "El hijo izquierdo debe ser null al crear el nodo");
        assertNull(nodo.right, "El hijo derecho debe ser null al crear el nodo");
    }

    @Test
    @DisplayName("Nodo debe almacenar el dato correctamente")
    void testDataStored() {
        Nodo<String> nodo = new Nodo<>("test");
        assertEquals("test", nodo.data);
    }

    @Test
    @DisplayName("Se puede asignar hijo izquierdo")
    void testAssignLeftChild() {
        Nodo<Integer> parent = new Nodo<>(10);
        Nodo<Integer> left   = new Nodo<>(5);
        parent.left = left;
        assertSame(left, parent.left);
    }

    @Test
    @DisplayName("Se puede asignar hijo derecho")
    void testAssignRightChild() {
        Nodo<Integer> parent = new Nodo<>(10);
        Nodo<Integer> right  = new Nodo<>(15);
        parent.right = right;
        assertSame(right, parent.right);
    }

    @Test
    @DisplayName("Nodo acepta tipo genérico Association")
    void testNodoWithAssociation() {
        Association<String, String> assoc = new Association<>("hello", "hola");
        Nodo<Association<String, String>> nodo = new Nodo<>(assoc);
        assertEquals("hello", nodo.data.getKey());
        assertEquals("hola",  nodo.data.getValue());
    }

    @Test
    @DisplayName("Nodo con dato null no lanza excepción")
    void testNodoWithNullData() {
        assertDoesNotThrow(() -> new Nodo<>(null));
    }
}