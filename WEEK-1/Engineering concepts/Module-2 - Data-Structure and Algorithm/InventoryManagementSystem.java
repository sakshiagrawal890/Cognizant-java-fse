import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private final Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String itemName, int quantity) {
        inventory.put(itemName, inventory.getOrDefault(itemName, 0) + quantity);
    }

    public void updateStock(String itemName, int quantity) {
        inventory.put(itemName, quantity);
    }

    public int getStock(String itemName) {
        return inventory.getOrDefault(itemName, 0);
    }

    public void displayInventory() {
        System.out.println("Inventory Items:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem system = new InventoryManagementSystem();
        system.addItem("Laptop", 10);
        system.addItem("Mouse", 25);
        system.addItem("Laptop", 5);
        system.updateStock("Mouse", 20);

        System.out.println("Current stock of Laptop: " + system.getStock("Laptop"));
        system.displayInventory();
    }
}
