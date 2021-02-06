public class DoublyLinkedList {

  private Node head;
  private Node tail;
  private int size = 0;
  static class Node{
 
    int i;
    Node next;
    Node prev;
    Node(int i){
      this.i = i;
    }
    public void displayData(){
      System.out.print(" " + i);
    }
  }
  
  public DoublyLinkedList(){
    this.head = null;
    this.tail = null;
  }

  public boolean isEmpty(){
    return head == null;
  }
    
  public void addFirst(int i){
    Node newNode = new Node(i);
    if(isEmpty()){
        tail = newNode;
    }else{
        head.prev = newNode;
    }
    newNode.next = head;
    head = newNode;
    size++;
  }
    

  public void addLast(int i){
    Node newNode = new Node(i);
    if(isEmpty()){
      head = newNode;
    }else{
      tail.next = newNode;
      newNode.prev = tail;
    }
    tail = newNode;
    size++;
  }
    
  public void addAtIndex(int i, int index){
    if(!isValidIndex(index)){
      throw new IndexOutOfBoundsException("Index " + index +" not valid for linked list of size " + size);
    }
    Node newNode = new Node(i);
    Node current = head;
    if(index == 0){
      insertFirst(i);
    }
    else if(index == size){
      insertLast(i);
    }else{
      for(int j = 0; j < index && current.next != null; j++){
        current = current.next;
      }
      newNode.next = current;
      current.prev.next = newNode;
      newNode.prev = current.prev;
      current.prev = newNode;
      size++;    
    }      
  }
    
  public Node removeFirst(){
    if(head == null){
      throw new RuntimeException("List is empty");
    }
    Node first = head;
    if(head.next == null){
      tail = null;
    }else{
      head.next.prev = null;
    }
    head = head.next;
    size--;
    return first;
  }
    
  public Node removeLast(){
    if(tail == null){
      throw new RuntimeException("List is empty");
    }
    Node last = tail;
    if(head.next == null){
      head = null;
    }else{
      
      tail.prev.next = null;
    }
    tail = tail.prev;
    size--;
    return last;
  }

  public Node removeAtIndex(int index){
    if(!isValidIndex(index+1)){
      throw new IndexOutOfBoundsException("Index " + index +" not valid for linked list of size " + size);
    }
    Node current = head;
   
    if(index == 0){
      return deleteFirst();
    }
   
    else if(index == size-1){
      return deleteLast();
    }else{
      for(int j = 0; j < index && current.next != null; j++){
        current = current.next;
      }
      current.prev.next = current.next;
      current.next.prev = current.prev;
      size--;
    }
    return current;
  }
   
   static int search(Node head_ref, int x)
  {   
    Node temp = head_ref;    
    int pos = 0;
    while (temp.data != x
               && temp.next != null)
    {
      pos++;
      temp = temp.next;
    }
     
    if (temp.data != x)
      return -1;
    return (pos + 1);
  }
}