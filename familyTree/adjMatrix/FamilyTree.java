package familyTree.adjMatrix;

import java.util.ArrayList;

// Define the FamilyTree class
public class FamilyTree {
    private ArrayList<String> names; // Stores names of individuals in the family tree
    private int[][] adjMatrix; // Represents relationships as an adjacency matrix

    // Constructor for the FamilyTree class
    public FamilyTree() {
        names = new ArrayList<>(); // Initialize the list of names
        adjMatrix = new int[1][1]; // Start with a 1x1 matrix, will expand as needed
    }

    // Adds an individual to the family tree or returns the index if already added
    private int getOrAddIndividual(String name) {
        int index = names.indexOf(name); // Check if the name already exists
        if (index == -1) { // If the name is not found
            names.add(name); // Add the new name
            index = names.size() - 1; // Update the index to the new name's position
            // Resize the adjacency matrix to accommodate the new individual
            int newSize = names.size();
            int[][] newMatrix = new int[newSize][newSize];
            // Copy the old matrix to the new matrix
            for (int i = 0; i < adjMatrix.length; i++) {
                System.arraycopy(adjMatrix[i], 0, newMatrix[i], 0, adjMatrix[i].length);
            }
            adjMatrix = newMatrix; // Update the matrix to the new matrix
        }
        return index; // Return the index of the name in the list
    }

    // Adds a parent-child relationship to the family tree
    public void addRelationship(String parent, String child) {
        int parentIndex = getOrAddIndividual(parent); // Get or add the parent
        int childIndex = getOrAddIndividual(child); // Get or add the child
        // Mark the parent-child relationship in the matrix
        adjMatrix[parentIndex][childIndex] = 1;
    }

    // Prints the family tree by displaying the relationships
    public void printFamilyTree() {
        // Iterate through each individual
        for (int i = 0; i < names.size(); i++) {
            System.out.print("Parent: " + names.get(i) + " has children: ");
            // Iterate through the matrix to find children of the current individual
            for (int j = 0; j < names.size(); j++) {
                if (adjMatrix[i][j] == 1) { // If a parent-child relationship exists
                    System.out.print(names.get(j) + " "); // Print the child's name
                }
            }
            System.out.println(); // New line for the next individual
        }
    }
}
