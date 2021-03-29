class Node{
  
  int data;
  int min;
  Node next;
  
}

class MinStack {

    
    Node head;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int val) {
        
        if(head == null){
          head = new Node();
          head.data = val;
          head.min = val;
        }
        else{
          Node temp = new Node();
          temp.data = val;
          temp.min = Math.min(temp.data, head.min);
          temp.next = head;
          head = temp;
        }
        
    }
    
    public void pop() {
        
        head = head.next;
        
    }
    
    public int top() {
      
      return head.data;
      
    }
    
    public int getMin() {
        return head.min;
    }
}
