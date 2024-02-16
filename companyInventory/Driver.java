package companyInventory;

public class Driver {

	public static void main(String[] args) {
		// Create the inventory manager and stack
        InventoryManager manager = new InventoryManager();

        // Simulate purchasing items
        manager.purchaseItem(100.0, 5); // Purchase 5 items at $100 each
        manager.purchaseItem(200.0, 3); // Purchase 3 items at $200 each

        // Display the net worth of the inventory
        System.out.println("Net worth of inventory: $" + manager.calculateNetWorth());

        // Simulate selling items
        double revenueGenerated = manager.sellItem(4); // Attempt to sell 4 items
        System.out.println("Revenue generated from selling items: $" + revenueGenerated);

        // Check and display if inventory is empty after operations
        System.out.println("Is inventory empty? " + manager.isInventoryEmpty());

        // Display the remaining net worth of the inventory
        System.out.println("Remaining net worth of inventory: $" + manager.calculateNetWorth());
	}

}
