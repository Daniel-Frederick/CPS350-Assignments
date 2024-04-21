package familyTree.adjList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Defines the FamilyTree class to represent and manage a family tree
public class FamilyTree {
    // A list to store the names of individuals in the family tree
    private List<String> names;
    // A list of lists to represent parent-child relationships as an adjacency list
    private List<List<String>> adjList;

    // Constructor of the FamilyTree class
    public FamilyTree() {
        names = new ArrayList<>(); // Initializes the list of names
        adjList = new ArrayList<>(); // Initializes the adjacency list
    }

    // Adds an individual to the family tree if not already added and returns their index
    private int addIndividual(String name) {
        int index = names.indexOf(name); // Checks if the name already exists and gets its index
        if (index == -1) { // If the name does not exist
            names.add(name); // Adds the new name to the names list
            adjList.add(new ArrayList<>()); // Adds a new list for this individual's children in the adjacency list
            return names.size() - 1; // Returns the index of the newly added individual
        }
        return index; // Returns the index of the existing individual
    }

    // Adds a parent-child relationship to the family tree
    public void addRelationship(String parent, String child) {
        int parentIndex = addIndividual(parent); // Ensures the parent is added to the list and gets the parent's index
        addIndividual(child); // Ensures the child is added to the list but its index is not needed here
        adjList.get(parentIndex).add(child); // Adds the child to the parent's list in the adjacency list
    }

    // Prints the family tree by displaying the relationships
    public void printFamilyTree() {
        for (int i = 0; i < names.size(); i++) { // Iterates through each individual in the names list
            System.out.print("Parent: " + names.get(i) + " has children: "); // Prints the parent's name
            List<String> children = adjList.get(i); // Gets the list of children for the current parent
            for (String child : children) { // Iterates through the list of children
                System.out.print(child + " "); // Prints each child's name
            }
            System.out.println(); // Moves to the next line after printing all children for the current parent
        }
    }

    // The main method - the entry point of the program
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(); // Creates a new FamilyTree object
        Scanner scanner = new Scanner(System.in); // Creates a Scanner object for reading user input

        while (true) { // Enters an infinite loop to continuously ask for user input
            System.out.print("Enter individual's name (or type 'done' to finish): ");
            String name = scanner.nextLine(); // Reads the individual's name from user input
            if ("done".equals(name)) { // Checks if the user types 'done' to finish input
                break; // Exits the loop if 'done' is entered
            }

            // Asks for the relationship of the entered individual
            System.out.print("Is " + name + " a parent or child of another individual? Enter 'parent' or 'child': ");
            String relation = scanner.nextLine(); // Reads the relationship from user input
            if ("parent".equals(relation)) { // Checks if the individual is a parent
                System.out.print("Enter the child's name: ");
                String childName = scanner.nextLine(); // Reads the child's name
                familyTree.addRelationship(name, childName); // Adds the parent-child relationship
            } else if ("child".equals(relation)) { // Checks if the individual is a child
                System.out.print("Enter the parent's name: ");
                String parentName = scanner.nextLine(); // Reads the parent's name
                familyTree.addRelationship(parentName, name); // Adds the child-parent relationship
            }

            // Asks the user if they want to add more individuals
            System.out.print("Do you want to add more individuals? (yes/no): ");
            String addMore = scanner.nextLine(); // Reads the user's response
            if (!"yes".equals(addMore)) { // Checks if the user answers 'no'
                break; // Exits the loop if the user does not want to add more individuals
            }
        }

        familyTree.printFamilyTree(); // Prints the completed family tree
        scanner.close(); // Closes the scanner
    }
}