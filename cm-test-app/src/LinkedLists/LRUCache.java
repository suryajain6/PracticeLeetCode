package LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head;
    ListNode tail;
    int capacity;
    LRUCache(int capacity){
        this.capacity = capacity;
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value){
        ListNode node = new ListNode(key,value);
        if(map.containsKey(key)){
            remove(node);
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insertToFront(node);
    }

    public ListNode get(int key){
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            remove(node);
            insertToFront(node);
            return node;
        }else {
            return null;
        }

    }

    public void insertToFront(ListNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        map.put(node.key,node);
    }

    public void remove(ListNode node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String [] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1); // [1]
        cache.put(2, 2); // [2,1]
        cache.get(1);    // returns 1, moves 1 to front -> [1,2]
        cache.put(3, 3); // evicts 2 -> [3,1]
        cache.get(2);
    }
}

class ListNode{
    ListNode prev, next;
    int key, value;
    ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
