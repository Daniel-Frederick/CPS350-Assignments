/*
 * The primary adjustment for quadratic probing involves changing how the class 
 * calculates the next index when handling collisions. Unlike linear probing, 
 * which simply moves to the next index, quadratic probing uses a quadratic 
 * function of the probe number (i * i). This approach helps spread out entries 
 * more evenly and reduces clustering, potentially improving performance in scenarios 
 * with high load factors.
 */

 package resources.dataStructures;

 public class QuadraticHashtable<K, V> {
     // Number of key-value pairs currently stored in the hash table.
     private int numberOfEntries;
     // The maximum capacity of the hash table to prevent it from growing too large.
     private final int MAX_CAPACITY = 100;
     // The current size of the hash table array; starts with a default value and grows as needed.
     private int currentCapacity;
     // The array that actually stores the key-value pairs (entries) in the hash table.
     private TableEntry<K, V>[] hashTable;
 
     // Constructor: Initializes the hash table with a default capacity.
     //@SuppressWarnings("unchecked")
     public QuadraticHashtable() {
         currentCapacity = 5; // Start with a small capacity to demonstrate resizing.
         // Java does not allow the creation of generic arrays directly, so we use a workaround.
         hashTable = (TableEntry<K, V>[]) new TableEntry[currentCapacity];
         numberOfEntries = 0; // Initially, the hash table is empty.
     }
 
     // Inner class that represents a key-value pair (an entry in the hash table).
     private static class TableEntry<K, V> {
         K key; // The key of the entry.
         V value; // The value associated with the key.
 
         // Constructor for creating a new table entry.
         TableEntry(K key, V value) {
             this.key = key;
             this.value = value;
         }
     }
 
     // Computes the initial index in the hash table for a given key.
     private int hash(K key) {
         // We use the hashCode of the key and modulo it with the current capacity to ensure it fits in the array.
         return Math.abs(key.hashCode()) % currentCapacity;
     }
 
     // Inserts a new key-value pair into the hash table or updates the value for an existing key.
     public void insert(K key, V value) {
         // Before inserting, check if the table needs resizing to maintain good performance.
         if (numberOfEntries >= currentCapacity * 0.75) {
             resize();
         }
 
         // Calculate the initial index for this key using the hash function.
         int index = hash(key);
         int i = 1; // Quadratic probing starts with i = 1.
 
         // Probe for the next open slot in case of a collision.
         while (hashTable[index] != null && !hashTable[index].key.equals(key)) {
             // Calculate the next index using quadratic probing.
             index = (index + i * i) % currentCapacity;
             i++;
         }
 
         // Once an open slot is found, insert the new entry.
         if (hashTable[index] == null) {
             numberOfEntries++; // Increase the count of entries.
         }
         hashTable[index] = new TableEntry<>(key, value);
     }
 
     // Dynamically resizes the hash table to accommodate more entries.
     private void resize() {
         // Store the old table and create a new table with double the capacity.
         TableEntry<K, V>[] oldTable = hashTable;
         int newSize = Math.min(currentCapacity * 2, MAX_CAPACITY);
         hashTable = (TableEntry<K, V>[]) new TableEntry[newSize];
         currentCapacity = newSize;
         numberOfEntries = 0; // Reset to 0, to be recalculated as entries are reinserted.
 
         // Re-insert entries from the old table into the new table.
         for (TableEntry<K, V> entry : oldTable) {
             if (entry != null) {
                 insert(entry.key, entry.value);
             }
         }
     }
 
     // Removes a key-value pair from the hash table.
     public void remove(K key) {
         // Calculate the initial index for the key.
         int index = hash(key);
         int i = 1; // Start with i = 1 for quadratic probing.
 
         // Probe for the key in case of collisions.
         while (hashTable[index] != null && !hashTable[index].key.equals(key)) {
             index = (index + i * i) % currentCapacity;
             i++;
         }
 
         // If the key is found, remove the entry by setting it to null.
         if (hashTable[index] != null) {
             hashTable[index] = null;
             numberOfEntries--; // Decrease the count of entries.
         }
     }
 
     // Attempts to locate and print the value for a given key.
     public void locate(K key) {
         int index = hash(key); // Initial index for the key.
         int i = 1; // Start with i = 1 for quadratic probing.
 
         // Probe for the key in case of collisions.
         while (hashTable[index] != null && !hashTable[index].key.equals(key)) {
             index = (index + i * i) % currentCapacity;
             i++;
         }
 
         // If the key is found, print its associated value.
         if (hashTable[index] != null && hashTable[index].key.equals(key)) {
             System.out.println("Value found: " + hashTable[index].value);
         } else {
             System.out.println("Key not found");
         }
     }
 }
 