package Try;

//hello ako si dev, Tinapos ko lahat ng gawain ko para makapag concert

import java.util.Scanner;


public class DataStructure {

    static MyArrayList myArrayList = new MyArrayList();
    static MyLinkedList myLinkedList = new MyLinkedList();
    static MyStack myStack = new MyStack(10);
    static MyQueue myQueue = new MyQueue(10);
    static MyTree myTree = new MyTree();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("         DATA STRUCTURE VISUALIZER          ");
        System.out.println("============================================");

        boolean running = true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Array List");
            System.out.println("2. Linked List");
            System.out.println("3. Stack");
            System.out.println("4. Queue");
            System.out.println("5. Tree");
            System.out.println("6. Exit");
            System.out.print("Select a data structure (1-6): ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    runArrayListMenu();
                    break;
                case 2:
                    runLinkedListMenu();
                    break;
                case 3:
                    runStackMenu();
                    break;
                case 4:
                    runQueueMenu();
                    break;
                case 5:
                    runTreeMenu();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void runArrayListMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n>>> ARRAY LIST OPERATIONS");
            System.out.println(myArrayList.listAll()); // Visualize current state
            System.out.println("1. Add at End");
            System.out.println("2. Add at Start");
            System.out.println("3. Add at Index");
            System.out.println("4. Remove by Index");
            System.out.println("5. Get by Index");
            System.out.println("6. Get size");
            System.out.println("7. Search");
            System.out.println("8. Sort");
            System.out.println("9. Show all");
            System.out.println("10. Clear");
            System.out.println("11. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    myArrayList.addEnd(getIntInput());
                    break;
                case 2:
                    System.out.print("Enter number: ");
                    myArrayList.addStart(getIntInput());
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    int idx = getIntInput();
                    System.out.print("Enter number: ");
                    myArrayList.addAtIndex(idx, getIntInput());
                    break;
                case 4:
                    System.out.print("Enter index to remove: ");
                    int index = getIntInput();
                    myArrayList.removeByIndex(index);
                    break;
                case 5:
                    System.out.print("Enter index: ");
                    int index2 = getIntInput();
                    System.out.println("Value: " + myArrayList.get(index));
                    break;
                case 6:
                    System.out.println("Size: " + myArrayList.getSize());
                    break;
                case 7:
                    System.out.print("Enter value to search: ");
                    boolean found = myArrayList.search(getIntInput());
                    System.out.println("Result: " + (found ? "FOUND" : "NOT FOUND"));
                    break;
                case 8:
                    myArrayList.sort();
                    System.out.println("List sorted.");
                    myArrayList.showAll();
                    break;
                case 9:
                    myArrayList.showAll();
                    break;
                case 10:
                    myArrayList.clear();
                    System.out.println("List cleared.");
                    break;
                case 11:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void runLinkedListMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n>>> LINKED LIST OPERATIONS");
            System.out.println(myLinkedList.listAll()); // Visualize
            System.out.println("1. Add at End");
            System.out.println("2. Add at Start");
            System.out.println("3. Add at Index");
            System.out.println("4. Search");
            System.out.println("5. Sort");
            System.out.println("6. Clear");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to add (End): ");
                    myLinkedList.addEnd(getIntInput());
                    break;
                case 2:
                    System.out.print("Enter value to add (Start): ");
                    myLinkedList.addStart(getIntInput());
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    int idx = getIntInput();
                    System.out.print("Enter value: ");
                    myLinkedList.addAtIndex(idx, getIntInput());
                    break;
                case 4:
                    System.out.print("Enter value to search: ");
                    boolean found = myLinkedList.search(getIntInput());
                    System.out.println("Result: " + (found ? "FOUND" : "NOT FOUND"));
                    break;
                case 5:
                    myLinkedList.sort();
                    System.out.println("List sorted.");
                    break;
                case 6:
                    myLinkedList.clear();
                    System.out.println("List cleared.");
                    break;
                case 7:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void runStackMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n>>> STACK OPERATIONS (LIFO)");
            System.out.println(myStack.listAll()); // Visualize
            System.out.println("1. Push (Add at End)");
            System.out.println("2. Search");
            System.out.println("3. Sort");
            System.out.println("4. Clear");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to Push: ");
                    myStack.push(getIntInput());
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    boolean found = myStack.search(getIntInput());
                    System.out.println("Result: " + (found ? "FOUND" : "NOT FOUND"));
                    break;
                case 3:
                    myStack.sort();
                    System.out.println("Stack sorted.");
                    break;
                case 4:
                    myStack.clear();
                    System.out.println("Stack cleared.");
                    break;
                case 5:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void runQueueMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n>>> QUEUE OPERATIONS (FIFO)");
            System.out.println(myQueue.listAll()); // Visualize
            System.out.println("1. Enqueue (Add at End)");
            System.out.println("2. Search");
            System.out.println("3. Sort");
            System.out.println("4. Clear");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to Enqueue: ");
                    myQueue.enqueue(getIntInput());
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    boolean found = myQueue.search(getIntInput());
                    System.out.println("Result: " + (found ? "FOUND" : "NOT FOUND"));
                    break;
                case 3:
                    myQueue.sort();
                    System.out.println("Queue sorted.");
                    break;
                case 4:
                    myQueue.clear();
                    System.out.println("Queue cleared.");
                    break;
                case 5:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void runTreeMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("====================================================");
            System.out.println("          Welcome to Trees Implementation!          ");
            System.out.println("====================================================");
            System.out.println(myTree.listAll()); // Visualize
            System.out.println("Pick a Command You'd like to try: ");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Exit Trees");
            System.out.print("Choice: ");
            int choice1 = sc.nextInt();

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    myTree.add(getIntInput());
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    boolean found = myTree.search(getIntInput());
                    System.out.println("Result: " + (found ? "FOUND" : "NOT FOUND"));
                    break;
                case 3:
                    System.out.println(myTree.listAll());
                    break;
                case 4:
                    myTree.clear();
                    System.out.println("Tree cleared.");
                    break;
                case 5:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("That's not a number! Try again: ");
            sc.next(); // discard bad input
        }
        return sc.nextInt();
    }
}






