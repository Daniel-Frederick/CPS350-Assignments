package familyTree.adjMatrix;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
           FamilyTree familyTree = new FamilyTree(); // Create a new family tree
            Scanner scanner = new Scanner(System.in); // Scanner for reading user input

            while (true) { // Continuously ask for user input
                System.out.print("Enter individual's name (or type 'done' to finish): ");
                String name = scanner.nextLine(); // Read the individual's name
                if ("done".equals(name)) { // If the user types 'done'
                    break; // Exit the loop
                }

                // Ask for the relationship of the entered individual
                System.out.print("Is " + name + " a parent or child of another individual? Enter 'parent' or 'child': ");
                String relation = scanner.nextLine();
                
                if ("parent".equals(relation)) { // If the individual is a parent
                    System.out.print("Enter the child's name: ");
                    String childName = scanner.nextLine(); // Read the child's name
                    familyTree.addRelationship(name, childName); // Add the relationship
                } else if ("child".equals(relation)) { // If the individual is a child
                    System.out.print("Enter the parent's name: ");
                    String parentName = scanner.nextLine(); // Read the parent's name
                    familyTree.addRelationship(parentName, name); // Add the relationship
                }

                // Ask the user if they want to add more individuals
                System.out.print("Do you want to add more individuals? (yes/no): ");
                String addMore = scanner.nextLine();
                if (!"yes".equals(addMore)) { // If the user answers 'no'
                    break; // Exit the loop
                }
            }

            familyTree.printFamilyTree(); // Print the completed family tree
            scanner.close(); // Close the scanner

    }// end of main

}// end of class

