import java.util.Scanner;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "inventory.dat";
    private static InventoryManager manager = new InventoryManager();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Loads inventory from file if available
        List<CarPart> loadedInventory = FileHandler.readFromFile(FILE_NAME);
        if (loadedInventory != null) {
            manager = new InventoryManager();
            manager.getInventory().addAll(loadedInventory);
        }

        while (true) {
            System.out.println("\nCar Parts Inventory System:");
            System.out.println("1. Add Part(s)");
            System.out.println("2. Update Part(s)");
            System.out.println("3. Remove Part(s)");
            System.out.println("4. Search Part(s)");
            System.out.println("5. Display Inventory");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter part name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scan.nextInt();
                    System.out.print("Enter the price: ");
                    double price = scan.nextDouble();
                    scan.nextLine();
                    manager.addPart(new CarPart(name, quantity, price));
                    break;

                case 2:
                    System.out.print("Please enter part name to update: ");
                    String updateName = scan.nextLine();
                    System.out.print("Please enter new quantity: ");
                    int newQuantity = scan.nextInt();
                    System.out.print("Please enter a new price: ");
                    double newPrice = scan.nextDouble();
                    scan.nextLine();
                    manager.updatePart(updateName, newQuantity, newPrice);
                    break;

                case 3:
                    System.out.print("Enter part name to remove: ");
                    String removeName = scan.nextLine();
                    manager.removePart(removeName);
                    break;

                case 4:
                    System.out.print("Enter part name to search: ");
                    String searchName = scan.nextLine();
                    CarPart foundPart = manager.searchPart(searchName);
                    if (foundPart != null) {
                        System.out.println("Part found: " + foundPart);
                    } else {
                        System.out.println("Sorry, part is not found.");
                    }
                    break;

                case 5:
                    manager.displayInventory();
                    break;

                case 6:
                    FileHandler.writeToFile(manager.getInventory(), FILE_NAME);
                    System.out.println("Exiting now...");
                    scan.close();
                    System.exit(0);

                default:
                    System.out.println("This input is invalid. Please try again.");
            }
        }
    }
}