package LinkedLists;

public class QueueUsingLinkedlist {

    Node front, rear;
    QueueUsingLinkedlist(){
        front = rear = null;
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(rear == null){
            front = rear = newNode;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Node dequeue(){
        if(front == null){
            return null;
        }
        Node temp = front;
        front = front.next;
        return temp;
    }

    public static void main(String args[]){
        QueueUsingLinkedlist linkedlist = new QueueUsingLinkedlist();
        linkedlist.enqueue(10);
        linkedlist.enqueue(20);
        linkedlist.enqueue(30);
        linkedlist.enqueue(40);
        linkedlist.enqueue(50);
        linkedlist.dequeue();
        linkedlist.dequeue();
        
    }
}
