package companyInventory;

public class InventoryItem {
    private double costPerItem;
    private int quantity;

    // Constructor for inventory item
    public InventoryItem(double costPerItem, int quantity) {
        this.costPerItem = costPerItem;
        this.quantity = quantity;
    }

    // Calculates and returns the selling price of this item
    public double calculateSellingPrice() {
        return costPerItem * 1.2; // Selling price is 120% of cost
    }

    // Returns the cost of this item
    public double getCost() {
        return costPerItem;
    }

    // Returns the quantity of this item
    public int getQuantity() {
        return quantity;
    }

    // Sets the quantity of this item
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
