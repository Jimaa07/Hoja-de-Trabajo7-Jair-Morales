package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BuscarTest {

    private BinarySearchTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
    }

    @Test
    @DisplayName("Buscar elemento que existe retorna el valor")
    void testBuscarExistente() {
        assertEquals(10, tree.get(10));
    }

    @Test
    @DisplayName("Buscar elemento que no existe retorna null")
    void testBuscarNoExistente() {
        assertNull(tree.get(99));
    }

    @Test
    @DisplayName("Buscar en árbol vacío retorna null")
    void testBuscarEnArbolVacio() {
        BinarySearchTree<Integer> vacio = new BinarySearchTree<>();
        assertNull(vacio.get(10));
    }
}