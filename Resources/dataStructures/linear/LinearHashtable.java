package resources.dataStructures.linear;

// Definition of the HashedDictionary class with generic types K (for Key) and V (for Value).
public class LinearHashtable<K, V> {
    // Tracks the number of entries in the hash table to manage resizing and provide size information.
    private int numberOfEntries;
    // Maximum capacity of the hash table to prevent it from growing indefinitely.
    private final int MAX_CAPACITY = 100;
    // Current capacity of the hash table, starts with a default size and grows as needed.
    private int currentCapacity;
    // The array acting as the internal storage mechanism for the hash table entries.
    private TableEntry<K, V>[] hashTable;

    // Constructor initializes the hash table with a default capacity.
    @SuppressWarnings("unchecked")
    public LinearHashtable() {
        currentCapacity = 5; // Default initial capacity set to 5.
        // Creation of the hash table array with type safety suppression due to generic array creation issue.
        hashTable = (TableEntry<K, V>[]) new TableEntry[currentCapacity];
        numberOfEntries = 0; // Initially, there are no entries in the hash table.
    }

    // Inner class representing a key-value pair, the basic element of the hash table.
    private static class TableEntry<K, V> {
        K key; // The key of the entry, used for indexing and lookup.
        V value; // The value associated with the key.

        // Constructor for creating a new table entry with a key and its associated value.
        TableEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Computes the index in the array for a given key using its hash code.
    private int hash(K key) {
        // The absolute value of the hashCode modulo the size of the hash table ensures a valid index.
        return Math.abs(key.hashCode()) % currentCapacity;
    }

    // Inserts a new key-value pair into the hash table or updates the value for an existing key.
    public void insert(K key, V value) {
        // If the hash table is 75% full, resize it before inserting a new entry.
        if (numberOfEntries >= currentCapacity * 0.75) {
            resize();
        }

        // Find the correct index for the new entry, using linear probing in case of collisions.
        int index = hash(key);
        while (hashTable[index] != null && !hashTable[index].key.equals(key)) {
            index = (index + 1) % currentCapacity;
        }

        // Insert the new entry or update the existing entry's value.
        if (hashTable[index] == null) {
            numberOfEntries++;
        }
        hashTable[index] = new TableEntry<>(key, value);
    }

    // Resizes the hash table to accommodate more entries, doubling its size.
    private void resize() {
        // Save the current table and create a new table with double the capacity.
        TableEntry<K, V>[] oldTable = hashTable;
        int newSize = Math.min(currentCapacity * 2, MAX_CAPACITY);
        hashTable = (TableEntry<K, V>[]) new TableEntry[newSize];
        currentCapacity = newSize;
        numberOfEntries = 0; // Reset before re-inserting entries.

        // Rehash and insert each entry from the old table into the new table.
        for (TableEntry<K, V> entry : oldTable) {
            if (entry != null) {
                insert(entry.key, entry.value);
            }
        }
    }

    // Removes a key-value pair from the hash table, identified by its key.
    public void remove(K key) {
        // Locate the entry to remove, using linear probing to handle collisions.
        int index = hash(key);
        while (hashTable[index] != null && !hashTable[index].key.equals(key)) {
            index = (index + 1) % currentCapacity;
        }

        // If the entry is found, remove it and decrement the number of entries.
        if (hashTable[index] != null) {
            hashTable[index] = null;
            numberOfEntries--;
        }
    }

    // Locates and prints the value associated with a given key, if it exists in the hash table.
    public void locate(K key) {
        // Compute the index for the key and search for it in the table.
        int index = hash(key);
        while (hashTable[index] != null && !hashTable[index].key.equals(key)) {
            index = (index + 1) % currentCapacity;
        }

        // If the key is found, print its value; otherwise, indicate that the key was not found.
        if (hashTable[index] != null && hashTable[index].key.equals(key)) {
            System.out.println("Value found: " + hashTable[index].value);
        } else {
            System.out.println("Key not found");
        }
    }
}
