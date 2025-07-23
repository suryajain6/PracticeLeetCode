package LinkedLists;

import java.util.HashSet;

public class ReverseLinkedList {
    Node head;

    ReverseLinkedList(Node head){
        this.head = head;
    }

    public void addNode(int data){
        Node newNode = new Node(data);
        Node current = head;
        while (current.next !=null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void reverseLinkedList(){
        Node current = head;
        Node prev = null;

        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static Node reverseBetween(Node head, int left, int right) {
        Node current = head;
        Node prev = null;
        int start = 1;
        Node leftstart = null;
        Node startNode = null;
        while(current != null){
            if(start >= left && start<= right){
                if(start == left){
                    leftstart = prev;
                    startNode = current;
                }

                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                if(start == right){
                    leftstart.next = prev;
                    startNode.next = current;

                }
            }  else{
                prev = current;
                current = current.next;

            }
            start = start +1;
        }
        return head;
    }

    public void printList(){
        Node current = head;
        while (current !=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void printList( Node start){
        Node current = start;
        while (current !=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void rotate(int num){
        Node rotateStart = head;
        int i=1;
        Node current = head;
        while(i<num){
            current = current.next;
            i++;
        }
        head = current.next;
        current.next = null;
        current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = rotateStart;

    }

    public void removeLoop(Node start){
        HashSet<Node> hashSet = new HashSet<>();
        Node current = start;
        Node prev = null;
        while(current != null){
            if(hashSet.contains(current)){
                prev.next = null;
                return;
            }
            hashSet.add(current);
            prev = current;
            current = current.next;
        }
    }

    public static boolean hasCycle(Node head) {

        Node current = head;
        HashSet<Node> set = new HashSet<>();
        while(current != null){
            if(set.contains(current)){
                return false;
            }else{
                set.add(current);
            }
            current = current.next;
        }
        return true;
    }

    public void reverseInGroup(int grpnum){
        Node current = head;
        int totalCount = 1;
        while (current.next != null){
            current = current.next;
           totalCount ++;
        }
        System.out.println("Total count is "+ totalCount);
        int noOfIteration = totalCount/grpnum;
        int remaining = totalCount%grpnum;
        current = head;
        Node prev = null;
        Node next = current;
        Node previousIteration = null;
        Node prevEnd = null;
        for(int i=0;i<noOfIteration; i++){

            for(int j=0;j<grpnum;j++) {

                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }



            Node tempCurrent = prev;

          for(int k=0; k<grpnum-1;k++){
                if(tempCurrent.next != null) {
                    tempCurrent = tempCurrent.next;
                }

            }
            if(i == 0){
                head = prev;

            }
            if(i != 0){
                //previousIteration.next = prev;
                prevEnd.next = prev;
            }
          prevEnd = tempCurrent;
        //    tempCurrent.next = current;
         //   previousIteration = tempCurrent;
           // current = current.next;

        }
        if(remaining > 0){
            for(int j=1;j<grpnum;j++) {
                if(current != null) {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
            }
            prevEnd.next = prev;

        }
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node current1 = l1;
        Node current2 = l2;
        Node result = null;
        int carry = 0;
        while(current1 != null && current2 !=null){
            int sum =carry;

            if(current1 != null){
                sum = sum + current1.data;
            }
            if(current2 != null){
                sum = sum + current2.data;
            }
            if(sum >=10){
                carry = sum/10;
                sum = sum %10;
            }else {
                carry = 0;
            }
            if(result == null){
                result = new Node(sum);
            }else {
                Node current3 = result;
                Node newNode = new Node(sum);
                while (current3.next != null){
                    current3 = current3.next;
                }
                current3.next = newNode;
            }

        }
        return result;
    }

    public Node getkthNode(int k){

        int totalNodes = 0;
        Node current = head;
        while (current != null){
            totalNodes = totalNodes + 1;
            current = current.next;
        }
        int n= totalNodes-k;
        current = head;
        for(int i=0;i<n;i++){
            current = current.next;
        }
        System.out.println(current.data);
        return current;
    }


    public static void main(String args[]){
        Node head = new Node(10);

        ReverseLinkedList linkedList = new ReverseLinkedList(head);
        linkedList.addNode(20);
        linkedList.addNode(30);
        linkedList.addNode(40);
        linkedList.addNode(50);
        linkedList.addNode(60);
        linkedList.addNode(70);
        linkedList.addNode(80);
        reverseBetween(head,2,4);
        linkedList.printList();

      //  linkedList.printList();
     //   linkedList.reverseLinkedList();
       /* linkedList.printList();
        linkedList.rotate(3);
        System.out.println("aftertotate");
        linkedList.printList();*/
      //  System.out.println("Reverse In Group");
       // linkedList.reverseInGroup(3);
       // linkedList.printList();
       /* Node start = new Node(50);
        start.next = new Node(20);
        start.next.next = new Node(15);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(10);

        start.next.next.next.next.next = start.next.next;
       System.out.println( hasCycle(start));*/
     //   linkedList.printList(start);
      /*  System.out.println("After remove loop");
        linkedList.removeLoop(start);
        linkedList.printList(start);*/
      //  linkedList.getkthNode(2);

    }
}
