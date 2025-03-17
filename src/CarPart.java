import java.text.DecimalFormat;
import java.io.Serializable;

public class CarPart implements Serializable  {

    public String name;
    public int quantity;
    public double price;

    public CarPart(String startModel,
                int amountOfItems,
                double startGallonsOfGas) {

        name = startModel;
        quantity = amountOfItems;
        price = price;
    }

    public CarPart(String startModel) {
        name = startModel;
    }

    public String getModel() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // Accessor method for variable "milesDriven"
    public double getPrice() {
        return price;
    }

    public void setModel(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int setQuantity(int quantity){
        return quantity;
    }

    public double setPrice(double price) {
        return quantity;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Quantity: " + quantity + ", Price: $ " + price;
    }
}
