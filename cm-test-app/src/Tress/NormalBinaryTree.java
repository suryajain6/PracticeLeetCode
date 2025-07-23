package Tress;


import java.util.LinkedList;
import java.util.Queue;

public class NormalBinaryTree {
    Node root;

    public void insertNode(int data){

        Node newNode = new Node(data);
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            root = newNode;
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();

            if(current.left == null){
                current.left = newNode;
                return;
            }else {
                queue.add(current.left);
            }

            if(current.right == null){
                current.right = newNode;
                return;
            }else {
                queue.add(current.right);
            }
        }

    }

    public Node findNode(int data){
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);

       while (!queue.isEmpty()){
           Node node = queue.poll();
           if(node.data == data){
               return node;
           }
           if(node.left != null){
               queue.add(node.left);
           }
           if(node.right != null){
               queue.add(node.right);
           }
       }
       return null;
    }

    public void levelTraversal(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String [] args){
        NormalBinaryTree normalBinaryTree = new NormalBinaryTree();
        normalBinaryTree.insertNode(10);
        normalBinaryTree.insertNode(20);
        normalBinaryTree.insertNode(30);
        normalBinaryTree.insertNode(40);
        normalBinaryTree.levelTraversal();
    }

}
