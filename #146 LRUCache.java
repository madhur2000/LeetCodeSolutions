class DoublyLinkedListNode<T>{
    T key;
    T val;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;
    
    public DoublyLinkedListNode(){
        
    }
    public DoublyLinkedListNode(T key, T val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    Map<Integer, DoublyLinkedListNode<Integer>> hm;
    DoublyLinkedListNode<Integer> head;
    DoublyLinkedListNode<Integer> tail;
    
    int capacity;
    
    public LRUCache(int capacity) {
        hm = new HashMap<>();
        head = new DoublyLinkedListNode<>();
        tail = new DoublyLinkedListNode<>();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        
        DoublyLinkedListNode<Integer> node = hm.get(key);
        int value = node.val;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        
        return value;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            DoublyLinkedListNode<Integer> node = hm.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            
            return;
        }
        if(hm.size() < capacity){
            DoublyLinkedListNode<Integer> node = new DoublyLinkedListNode<>(key, value);
            
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            
            hm.put(key, node);
            
            return;
        }
        
        hm.remove(tail.prev.key);
        
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        // tail.prev.prev = null;
        // tail.prev.next = null;
        
        DoublyLinkedListNode<Integer> node = new DoublyLinkedListNode<>(key, value);    
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        
        hm.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
