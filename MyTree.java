package Try;

public class MyTree {

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public MyTree() {
        root = null;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.data) {
            currentNode.left = addRecursive(currentNode.left, value);
        } else if (value > currentNode.data) {
            currentNode.right = addRecursive(currentNode.right, value);
        } else {
        }
        return currentNode;
    }

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }
        if (value == currentNode.data) {
            return true;
        }
        if (value < currentNode.data) {
            return searchRecursive(currentNode.left, value);
        } else {
            return searchRecursive(currentNode.right, value);
        }
    }

    public String listAll() {
        if (root == null) {
            return "Tree: [] (Empty)";
        }
        String output = "Tree (In-Order): [";

        StringBuilder sb = new StringBuilder();
        listInOrder(root, sb);

        String result = sb.toString();
        if (result.length() > 2) {
            result = result.substring(0, result.length() - 2);
        }

        return "Tree (In-Order): [" + result + "]";
    }

    private void listInOrder(Node node, StringBuilder sb) {
        if (node != null) {
            listInOrder(node.left, sb);
            sb.append(node.data);
            sb.append(", ");
            listInOrder(node.right, sb);
        }
    }

    public void clear() {
        root = null;
    }
}
