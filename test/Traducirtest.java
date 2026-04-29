package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para el método estático Main.traducir().
 * Se construye un árbol de diccionario en cada prueba y se verifica
 * la traducción de frases.
 */
public class TraducirTest {

    private BinarySearchTree<Association<String, String>> dictTree;

    @BeforeEach
    void setUp() {
        dictTree = new BinarySearchTree<>();
        dictTree.add(new Association<>("hello",  "hola"));
        dictTree.add(new Association<>("world",  "mundo"));
        dictTree.add(new Association<>("cat",    "gato"));
        dictTree.add(new Association<>("dog",    "perro"));
        dictTree.add(new Association<>("house",  "casa"));
        dictTree.add(new Association<>("book",   "libro"));
        dictTree.add(new Association<>("the",    "el"));
        dictTree.add(new Association<>("is",     "es"));
        dictTree.add(new Association<>("big",    "grande"));
    }

    @Test
    @DisplayName("Traducir palabra única conocida")
    void testTranslateSingleWord() {
        String result = Main.traducir("hello", dictTree);
        assertEquals("hola", result);
    }

    @Test
    @DisplayName("Traducir frase con varias palabras conocidas")
    void testTranslateMultipleWords() {
        String result = Main.traducir("hello world", dictTree);
        assertEquals("hola mundo", result);
    }

    @Test
    @DisplayName("Palabra desconocida debe aparecer entre asteriscos")
    void testUnknownWordMarkedWithAsterisks() {
        String result = Main.traducir("hello unknown", dictTree);
        assertTrue(result.contains("*unknown*"),
                "La palabra desconocida debe estar marcada con asteriscos");
    }

    @Test
    @DisplayName("Frase completamente desconocida: todas las palabras con asteriscos")
    void testAllUnknownWords() {
        String result = Main.traducir("xyz abc", dictTree);
        assertTrue(result.contains("*xyz*"));
        assertTrue(result.contains("*abc*"));
    }

    @Test
    @DisplayName("Puntuación adjunta a la palabra debe conservarse")
    void testPunctuationPreserved() {
        String result = Main.traducir("hello,", dictTree);
        assertTrue(result.contains("hola,"),
                "La puntuación debe mantenerse junto a la traducción");
    }

    @Test
    @DisplayName("Mayúsculas en el texto deben ignorarse (case-insensitive)")
    void testCaseInsensitive() {
        String result = Main.traducir("Hello", dictTree);
        assertEquals("hola", result);
    }

    @Test
    @DisplayName("Texto vacío debe retornar cadena vacía")
    void testEmptyString() {
        String result = Main.traducir("", dictTree);
        assertTrue(result.isEmpty() || result.isBlank());
    }

    @Test
    @DisplayName("Frase mixta: palabras conocidas y desconocidas")
    void testMixedSentence() {
        String result = Main.traducir("the cat is big", dictTree);
        assertEquals("el gato es grande", result);
    }

    @Test
    @DisplayName("Traducción con signos de puntuación en múltiples palabras")
    void testMultiplePunctuation() {
        String result = Main.traducir("hello, world.", dictTree);
        assertTrue(result.contains("hola,") && result.contains("mundo."));
    }
}