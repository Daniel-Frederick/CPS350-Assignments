package companyInventory;

import java.util.Stack;

public class InventoryStack {
    private Stack<InventoryItem> items = new Stack<>();

    // Adds a new item to the stack
    public void push(InventoryItem item) {
        items.push(item);
    }

    // Removes and returns the most recent item from the stack
    public InventoryItem pop() {
        return items.pop();
    }

    // Returns the most recent item without removing it
    public InventoryItem peek() {
        return items.peek();
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
