package frederick_daniel_BST;

import java.util.Scanner;

public class AVLTreeDemo {
    private static AVLTree avltree = new AVLTree(null);
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            while(true) {
                System.out.println(
                    "AVLTree Operations: \n 1. Insert\n 2. Delete\n 3. Search\n 4. Print Tree\n 5. Exit\n Choose an option: "
                    );
                int menu = scan.nextInt();

                switch (menu) {
                    case 1:
                        avlInsert();
                        break;
                    case 2:
                        avlDelete();
                        break;
                    case 3:
                        avlSearch();
                        break;
                    case 4:
                        avlPrintTree();
                        break;
                    case 5:
                        System.out.println("Existing Program... ");
                        System.exit(menu);
                        break;
                }
            }
        
            
        } catch (Exception e) {
          // Handle any unexpected errors
          e.printStackTrace();
        }


    }

    public static void avlInsert() {
        while(true) {
            // if statment somewhere
            int data = scan.nextInt();
            avltree.insert(data);
        }
    }

    public static void avlDelete() {
        int data = scan.nextInt();
        avltree.delete(data);
    }

    public static void avlSearch() {
        int data = scan.nextInt();
        avltree.search(data);
    }

    // Prints the AVLTree in Pre-Order
    public static void avlPrintTree() { // Might not need this
        avltree.printTree();
    }
}
