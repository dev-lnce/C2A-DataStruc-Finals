package Try

import java.util.Scanner;

public class MyTree {
    BinaryTree btree= new BinaryTree();
    Scanner sc = new Scanner(System.in);
    String choice2;
    public void run(){
        System.out.println("====================================================");
        System.out.println("          Welcome to Trees Implementation!          ");
        System.out.println("====================================================");
        do {
            System.out.println("\nPick a Command You'd like to try: ");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Exit Trees");
            System.out.print("Choice: ");
            int choice1 = sc.nextInt();

            switch (choice1) {
                case 1:
                    System.out.print("Enter value to add: ");
                    int add = sc.nextInt();
                    btree.insert(new Node(add));
                    break;
                case 2:
                    System.out.print("Enter value to Delete: ");
                    int delete = sc.nextInt();
                    btree.remove(delete);
                    break;
                case 3:
                    System.out.print("Enter value to Search: ");
                    int search = sc.nextInt();
                    boolean found = btree.search(search);
                    if (found) {
                        System.out.println(search + " was found in the tree.");
                    } else {
                        System.out.println(search + " was not found in the tree.");
                    }
                    break;
                case 4:
                    btree.display();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.print("Would you like to choose another option? (Y/N): ");
            sc.nextLine();  // Clear the buffer from previous nextInt()
            choice2 = sc.nextLine().trim();
        }
        while(choice2.equalsIgnoreCase("Y"));
    }
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BinaryTree{
    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;

        if(root==null){
            root=node;
            return root;
        }
        else if(data < root.data){
            root.left=insertHelper(root.left, node);
        }
        else{
            root.right=insertHelper(root.right, node);
        }
        return root;
    }

    public void display() {
        if (root == null) {
            System.out.println("Tree: [] (Empty)");
            return;
        }

        StringBuilder sb = new StringBuilder();
        displayHelper(root, sb);

        String result = sb.toString();
        if (result.length() > 2) {
            result = result.substring(0, result.length() - 2);
        }

        System.out.println("Tree (In-Order): [" + result + "]");
    }

    private void displayHelper(Node node, StringBuilder sb) {
        if (node != null) {
            displayHelper(node.left, sb);
            sb.append(node.data);
            sb.append(", ");
            displayHelper(node.right, sb);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if(root==null){
            return false;
        }
        else if(root.data==data){
            return true;
        }
        else if(root.data>data){
            return searchHelper(root.left, data);
        }
        else{
            return searchHelper(root.right, data);
        }
    }

    public void remove(int data) {
        if(search(data)){
            removeHelper(root, data);
        }
        else{
            System.out.println(data + " Could not be found");
        }
    }

    public Node removeHelper(Node root, int data) {
        if(root==null){
            return root;
        }
        else if(data < root.data){
            root.left=removeHelper(root.left, data);
        }
        else if(data > root.data){
            root.right=removeHelper(root.right, data);
        }
        else{
            if(root.left==null && root.right==null){
                root = null;
            }
            else if(root.right!=null){ //find a successor to replace this node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else{ //find a predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return null;
    }

    private int successor(Node root){ //Find least value below the right child of this root node
        root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root){ //Find greatest value below the left child of this root node
        root = root.left;
        while(root.right!=null){
            root = root.right;
        }
        return root.data;
    }
}

