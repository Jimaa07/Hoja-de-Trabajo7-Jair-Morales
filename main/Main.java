package main;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Association<String, String>> tree = new BinarySearchTree<>();

        // Cargar diccionario
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.replace("(", "").replace(")", "");
                String[] parts = line.split(",");

                String english = parts[0].trim().toLowerCase();
                String spanish = parts[1].trim().toLowerCase();

                tree.add(new Association<>(english, spanish));
            }

        } catch (IOException e) {
            System.out.println("Error leyendo diccionario");
        }

        System.out.println("Diccionario ordenado:");
        tree.inOrder();

        // Traducir texto
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;

            System.out.println("\nTraducción:");

            while ((line = br.readLine()) != null) {
                System.out.println(traducir(line, tree));
            }

        } catch (IOException e) {
            System.out.println("Error leyendo texto");
        }
    }

    public static String traducir(String texto, BinarySearchTree<Association<String, String>> tree) {
        String[] palabras = texto.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {

            String limpia = palabra.toLowerCase().replaceAll("[^a-z]", "");
            String puntuacion = palabra.replaceAll("[a-zA-Z]", "");

            Association<String, String> buscada = new Association<>(limpia, "");
            Association<String, String> encontrada = tree.get(buscada);

            if (encontrada != null) {
                resultado.append(encontrada.getValue()).append(puntuacion).append(" ");
            } else {
                resultado.append("*").append(palabra).append("* ");
            }
        }

        return resultado.toString().trim();
    }
}