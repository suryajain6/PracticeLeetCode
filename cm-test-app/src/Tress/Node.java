package Tress;

class Node {
    int data;
    Node left;
    Node right;

    Node() {

    }

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
