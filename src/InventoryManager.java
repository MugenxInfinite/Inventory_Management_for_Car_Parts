import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<CarPart> inventory;

    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    public void addPart(CarPart part) {
        inventory.add(part);
        System.out.println("Part added successfully.");
    }

    public void updatePart(String name, int newQuantity, double newPrice) {
        for (CarPart part : inventory) {
            if (part.getName().equalsIgnoreCase(name)) {
                part.setQuantity(newQuantity);
                part.setPrice(newPrice);
                System.out.println("Part updated successfully.");
                return;
            }
        }
        System.out.println("Part not found.");
    }

    public void removePart(String name) {
        inventory.removeIf(part -> part.getName().equalsIgnoreCase(name));
        System.out.println("Part removed successfully.");
    }

    public CarPart searchPart(String name) {
        for (CarPart part : inventory) {
            if (part.getName().equalsIgnoreCase(name)) {
                return part;
            }
        }
        return null;
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No parts in inventory.");
        } else {
            for (CarPart part : inventory) {
                System.out.println(part);
            }
        }
    }

    public List<CarPart> getInventory() {
        return inventory;
    }
}