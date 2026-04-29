package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase BinarySearchTree.
 * Verifica inserción, búsqueda y recorrido inOrder.
 */
public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>();
    }

    // ── add / get básicos ────────────────────────────────────────────────────

    @Test
    @DisplayName("get() en árbol vacío debe retornar null")
    void testGetOnEmptyTree() {
        assertNull(tree.get(10));
    }

    @Test
    @DisplayName("add() y get() de un único elemento")
    void testAddAndGetSingleElement() {
        tree.add(5);
        assertEquals(5, tree.get(5));
    }

    @Test
    @DisplayName("get() de elemento inexistente debe retornar null")
    void testGetNonExistentElement() {
        tree.add(5);
        tree.add(3);
        assertNull(tree.get(99));
    }

    @Test
    @DisplayName("add() múltiples elementos y recuperar cada uno")
    void testAddMultipleElements() {
        int[] values = {10, 5, 15, 3, 7};
        for (int v : values) tree.add(v);

        for (int v : values) {
            assertEquals(v, tree.get(v),
                    "No se encontró el elemento: " + v);
        }
    }

    @Test
    @DisplayName("add() elemento duplicado no debe lanzar excepción")
    void testAddDuplicate() {
        tree.add(5);
        assertDoesNotThrow(() -> tree.add(5));
    }

    @Test
    @DisplayName("get() después de insertar en subárbol derecho")
    void testGetRightSubtree() {
        tree.add(10);
        tree.add(20);
        assertEquals(20, tree.get(20));
    }

    @Test
    @DisplayName("get() después de insertar en subárbol izquierdo")
    void testGetLeftSubtree() {
        tree.add(10);
        tree.add(3);
        assertEquals(3, tree.get(3));
    }

    // ── BST con Association (uso real del proyecto) ──────────────────────────

    @Test
    @DisplayName("BST de Association: add y get por clave String")
    void testBSTWithAssociation() {
        BinarySearchTree<Association<String, String>> dictTree = new BinarySearchTree<>();
        dictTree.add(new Association<>("hello", "hola"));
        dictTree.add(new Association<>("world", "mundo"));
        dictTree.add(new Association<>("apple", "manzana"));

        Association<String, String> found = dictTree.get(new Association<>("world", ""));
        assertNotNull(found);
        assertEquals("mundo", found.getValue());
    }

    @Test
    @DisplayName("BST de Association: búsqueda de palabra no registrada retorna null")
    void testBSTAssociationMissing() {
        BinarySearchTree<Association<String, String>> dictTree = new BinarySearchTree<>();
        dictTree.add(new Association<>("hello", "hola"));

        assertNull(dictTree.get(new Association<>("cat", "")));
    }

    // ── inOrder no lanza excepción ───────────────────────────────────────────

    @Test
    @DisplayName("inOrder() en árbol vacío no debe lanzar excepción")
    void testInOrderEmptyTree() {
        assertDoesNotThrow(() -> tree.inOrder());
    }

    @Test
    @DisplayName("inOrder() con elementos no debe lanzar excepción")
    void testInOrderWithElements() {
        tree.add(10);
        tree.add(5);
        tree.add(15);
        assertDoesNotThrow(() -> tree.inOrder());
    }
}