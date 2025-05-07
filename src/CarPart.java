import java.io.Serializable;

public class CarPart implements Serializable {

    private String name;
    private int quantity;
    private double price;

    // Full constructor
    public CarPart(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public CarPart(String name) {
        this.name = name;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Quantity: %d, Price: $%.2f", name, quantity, price);
    }
}
