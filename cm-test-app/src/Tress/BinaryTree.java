package Tress;

public class BinaryTree {
    Node root;

    public void insertNode(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }else{
            Node current = root;

            while(current != null){
                if(newNode.data < current.data){
                    if(current.left == null){
                        current.left = newNode;
                        break;
                    }
                    current = current.left;
                }else if(newNode.data > current.data){
                    if(current.right == null){
                        current.right = newNode;
                        break;
                    }
                    current = current.right;
                }else{
                    break;
                }
            }
        }
    }
    public void inOrderTraversal(){
        System.out.println("In order traversal ");
        inOrder(root);
        System.out.println(" ");

    }

    public void preOrderTraversal(){
        System.out.println("pre order traversal ");
        preOrder(root);
        System.out.println(" ");

    }

    public void preOrder(Node root){
        if(root == null ){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrderTraversal(){
        System.out.println("post order traversal ");
        postOrder(root);
        System.out.println(" ");

    }

    private void postOrder(Node root) {
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }


    public void searchData(int data){
        Node current = root;

        while (current != null){
            if( data < current.data){
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            }else {
                System.out.println("Node found - " +current.data);
                break;
            }
        }
    }

    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void deleteNode(int data){

        Node current = root;
        Node parent = current;
        Node delNode = null;
        while (current != null){
            if(data <current.data){
                parent = current;
                current = current.left;
            }else if(data > current.data){
                parent = current;
                current = current.right;
            }else {
                delNode = current;
                break;
            }
        }

        if(delNode.left != null){
            Node succesorParent = delNode.left;
            Node succesorNode = succesorParent;
            if(succesorParent.right == null){
                    delNode.data = succesorNode.data;
                    Node successorChild = succesorNode.left;
                    delNode.left = successorChild;

            }else {
                succesorNode = succesorParent.right;
                while (succesorNode.right != null) {
                    succesorParent = succesorNode;
                    succesorNode = succesorNode.right;
                }
                delNode.data = succesorNode.data;

                Node successorChild = succesorNode.left != null ? succesorNode.left : succesorNode.right;
                if (succesorParent.left.data == succesorNode.data) {
                    succesorParent.left = successorChild;
                } else if (succesorParent.right.data == succesorNode.data) {
                    succesorParent.right = successorChild;
                }
            }
        }


    }

    public static void main(String [] args){
        BinaryTree bt = new BinaryTree();
        bt.insertNode(8);
        bt.insertNode(3);
        bt.insertNode(10);
        bt.insertNode(1);
        bt.insertNode(6);
        bt.insertNode(13);
        bt.insertNode(14);
        bt.insertNode(4);
        bt.insertNode(7);
        bt.inOrderTraversal();
      //  bt.searchData(6);
      //  bt.preOrderTraversal();
      //  bt.postOrderTraversal();
        bt.deleteNode(3);
        bt.inOrderTraversal();

    }
}
