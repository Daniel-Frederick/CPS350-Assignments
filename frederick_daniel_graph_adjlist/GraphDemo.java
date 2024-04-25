package frederick_daniel_graph_adjlist;

import java.util.Scanner;

public class GraphDemo {
  private static Graph graph = new Graph(); // Initiate the AVLTree tree Object
  private static Scanner scanner = new Scanner(System.in); // Initiate a Scanner for user input

  public static void main(String[] args) {
    System.out.println("Welcome to the Graph Manager!");

    while (true) { // Loop the menu and ask user for input 
      int menu; // Initiate menu option(int) for use input
      while (true) { // Loop to make sure user puts in correct input
        printMenu(); // Prints the menu
        if (scanner.hasNextInt()) { // Ask user for input and check if input is an integer
          menu = scanner.nextInt(); // Input is an integer
          break; // Jumps out of the while loop
        } else { // User input was not an integer
          System.out.println("Invalid input. Please enter one of the options!");
          scanner.nextLine(); // Consume the invalid input
        }
      }

      switch (menu) { // Switch to see what option user entered
        case 1:
          // User entered "1" and wants to insert nodes into AVLTree
          addVertex();
          break;
        case 2:
          // User entered "2" and wants to delete nodes from AVLTree
          addEdge();
          break;
        case 3:
          // User entered "3" and wants to search for a node in the AVLTree
          displayGraph();
          break;
        case 4:
          // User entered "5" and wants to exit the program
          System.out.println("Exiting the Graph Manager... ");
          System.exit(menu); // Exits the program
          break;
        default:
          // User entered a number less than 1 or greater than 5 which is not allowed
          System.out.println("Invalid input. Please enter one of the options!");
      }
    }
  }

  // Method to print the menu to the user
  private static void printMenu() {
    System.out.println(); // adds Spacing
    System.out.println("Please select an option: ");
    System.out.println("1. Add Vertex");
    System.out.println("2. Add Edge");
    System.out.println("3. Display Graph");
    System.out.println("4. Exit");
    System.out.print("Your choice: ");
  }

  public static void addVertex() {
    scanner.nextLine(); // Consume the invalid input

    System.out.print("Enter the vertex identifier(String): ");
    String vertex = scanner.nextLine();
    if(vertex != "") {
      graph.addVertex(vertex.trim());
    }
    else {
      System.out.println("Please enter a value");
    }
  }

public static void addEdge() {
    try {
      scanner.nextLine(); // Consume any input that my scanner could have

      // Get the name of the source vertex
      System.out.print("Enter the source vertex: ");
      String source = scanner.nextLine();
  
      // Get the name of the target vertex
      System.out.print("Enter the target vertex: ");
      String target = scanner.nextLine();
    
      // Get the weight for the edge
      System.out.print("Enter the weight of the edge: ");
      int weight = scanner.nextInt();
      scanner.nextLine();
  
      graph.addDirectedEdge(source, target, weight); // Give the user input to create a edge
      // This method will either print an error message or say the edge was successfully created. 
    }
    catch(Exception e) {
      scanner.nextLine();
      System.out.println("The weight must be an integer value!");
    } 
}


  public static void displayGraph() {
    // Call the the generateGraphRepresentation method from the Graph class to display the vertices and connections
    System.out.println("Graph Representation: ");
    System.out.print(graph.generateGraphRepresentation());
  }

}
