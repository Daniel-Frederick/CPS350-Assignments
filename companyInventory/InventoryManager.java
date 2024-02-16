package companyInventory;

public class InventoryManager {
	private InventoryStack inventoryStack = new InventoryStack();

    // Purchases a new item and adds it to the inventory
    public void purchaseItem(double costPerItem, int quantity) {
        InventoryItem newItem = new InventoryItem(costPerItem, quantity);
        inventoryStack.push(newItem);
    }

    // Sells items from the inventory. Returns the total revenue generated.
    public double sellItem(int quantity) {
        double revenue = 0;
        while (quantity > 0 && !inventoryStack.isEmpty()) {
            InventoryItem currentItem = inventoryStack.peek();
            int sellQuantity = Math.min(quantity, currentItem.getQuantity());
            revenue += sellQuantity * currentItem.calculateSellingPrice();
            quantity -= sellQuantity;
            if (sellQuantity < currentItem.getQuantity()) {
                currentItem.setQuantity(currentItem.getQuantity() - sellQuantity);
            } else {
                inventoryStack.pop();
            }
        }
        return revenue;
    }
    
    public boolean isInventoryEmpty() {
        return inventoryStack.isEmpty();
    }
    
    public double calculateNetWorth() {
        return inventoryStack.calculateNetWorth();
    }
    
}
