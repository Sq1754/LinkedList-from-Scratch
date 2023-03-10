// Creating a Linked list from Scratch

public class Linked_List {

	node head;
	private int size;
Linked_List(){
	size= 0;
}
  class node{
	  String data;
	  node next;
	
	  node(String data){
		  this.data=data;
		  this.next=null;
		  size++;
	  }
  }
	
  public void addFirst(String data) {
	 node newNode = new node(data);
	 newNode.next= head;
	 head = newNode;
  }
  
  public void addLast(String data) {
	  node newNode = new node(data);
	  
	  if(head==null) {
		  head = newNode;
		  return;
	  }
	  
	  node lastNode= head;
	  while(lastNode.next != null) {
		  lastNode = lastNode.next;
	  }
	    lastNode.next = newNode;
  }
  
  public void printList() {
       node currNode = head;
       while(currNode != null) {
    	   System.out.print(currNode.data+"->");
    	   currNode = currNode.next;
       }
         System.out.println("NULL");
  }	  
  
  public void removeFirst() {
	  if(head==null) {
		  System.out.println("Empty List,Nothung to delete");
	  return;
      }
	    head = this.head.next;
	    size--;
  }	  
  
  public void removeLast() {
	 if (head==null) {
		 System.out.println("Empty List,Nothung to delete");
        return;
	 } 
	 
	 size--;
	 if(head.next==null) {
		 head = null;
		 return;
	 }
	 
	 node currNode= head;
	 node lastNode = head.next;
	 while(lastNode.next!=null) {
		 currNode = currNode.next;
		 lastNode = lastNode.next;
	 }
	 
	   currNode.next = null;
  }
  
  public void addInMiddle(int idx, String data) {
	  if(idx>size||idx<0) {
		  System.out.println("Invalid Index");
	    return;
	  }
	  size++;
      node newNode =new node(data);
      if(head==null||idx==0) {
    	  newNode.next=head;
    	  head = newNode;
    	  return;
      }
      
      node currNode = head;
      for(int i=1;i<size;i++) {
    	  if(i==idx) {
    		  node nextNode = currNode.next;
    		  currNode.next= newNode;
    		  newNode.next=nextNode;
    		  break;
    	  }
    	  currNode = currNode.next;
      }
  }
  
  public int getSize() {
	  return size;
  }
  
  // Reversing Linked list Iterative method
  public void reverseList() {
	 if(head==null||head.next==null) {
		 return;
	 } 
	  
	  node prevNode = head;
	  node currNode = head.next;
	  while(currNode!=null) {
		  node nextNode = currNode.next;
		  currNode.next= prevNode;
		  
		  //update
		  prevNode = currNode;
		  currNode = nextNode;
	  }
	     head.next = null;
	     head = prevNode;
  }
  
  // recursive Method to revere list
  public node reverseListRecursive(node head) {
	  if(head==null||head.next==null) {
			 return head;
		 }
	  node newHead = reverseListRecursive(head.next);
	  
	  head.next.next = head; // new connection established
	  head.next = null; // previous connection cut
	  
	  return newHead;
  }
  
	public static void main(String[]args) {
	
		Linked_List list = new Linked_List();
		list.addFirst("MY");
		list.addLast("Saqlain");
		list.addInMiddle(1, "Name is");
		
		list.printList();
		
		 System.out.println("Size of List "+list.getSize());
		
		//list.removeFirst();
		//list.printList();
		
		//list.removeLast();
		//list.printList();
		
		list.reverseList();
		list.printList();
		
	list.head =	list.reverseListRecursive(list.head);
		list.printList();
	}
}
