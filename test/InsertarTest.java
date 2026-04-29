package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class InsertarTest {

    private BinarySearchTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>();
    }

    @Test
    @DisplayName("Insertar un elemento y verificar que existe")
    void testInsertarUno() {
        tree.add(10);
        assertNotNull(tree.get(10));
    }

    @Test
    @DisplayName("Insertar varios elementos")
    void testInsertarVarios() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        assertNotNull(tree.get(10));
        assertNotNull(tree.get(5));
        assertNotNull(tree.get(15));
    }

    @Test
    @DisplayName("Insertar elemento duplicado no lanza excepción")
    void testInsertarDuplicado() {
        tree.add(10);
        assertDoesNotThrow(() -> tree.add(10));
    }
}