package companyInventory;

public class InventoryManager {
    private InventoryStack inventoryStack = new InventoryStack();

    // Purchase new item
    public void purchaseItem(double costPerItem, int quantity) {
        InventoryItem newItem = new InventoryItem(costPerItem, quantity);

        // Add item in step 8
        inventoryStack.push(newItem);
    }

    // Sell an item(s)
    public void sellItem(int quantity) {
        double revenue = 0;
        while(quantity > 0 && !inventoryStack.isEmpty()) {
            InventoryItem currentItem = inventoryStack.peek();
            int sellQuantity = Math.min(quantity, currentItem.getQuantity());
        }
    }

    // Calculate networth
    

}