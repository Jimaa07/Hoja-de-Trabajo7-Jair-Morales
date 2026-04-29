import java.io.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Association<String, String>> tree = new BinarySearchTree<>();

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
    }
}