import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileHandler {
    public static void writeToFile(List<CarPart> inventory, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    public static List<CarPart> readFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>(); // Returns an empty list if file doesn't exist

        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<CarPart>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
            return null;
        }
    }
}