package dsa;

public class SLL {
	Node head;
	private int size;
	SLL(){
		this.size = 0;
	}
	class Node{
		int data;
		Node next;	
		Node(int data){
			this.data = data;
			this.next = null;
			size++;
		}
	}
	public void addFirst(int data) {
		Node  newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	public void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}
	public void printList() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		}
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.data + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println("NULL");
	}
	public void deleteFirst() {
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}
		size--;
		head = head.next;
	}
	public void deleteLast() {
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}	
		size--;
		if (head.next == null) {
			head = null;
			return;
		}
		Node secondLast = head;
		Node lastNode = head.next;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
			secondLast = secondLast.next;
		}
		secondLast.next = null;
	}
	public int getSize() {
		return size;
	}
	public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {  // Insert at the head
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {  // Traverse to the (position-1)th node
            if (temp == null) {
                throw new IndexOutOfBoundsException("Position out of range");
            }
            temp = temp.next;
        }    
        newNode.next = temp.next;
        temp.next = newNode;
    }
	 public void deleteAtPosition(int position) {
	        if (head == null) {
	            throw new IndexOutOfBoundsException("List is empty");
	        }
	        if (position == 0) {  // Delete the head
	            head = head.next;
	            return;
	        }
	        Node temp = head;
	        for (int i = 0; i < position - 1; i++) {  // Traverse to the (position-1)th node
	            if (temp == null || temp.next == null) {
	                throw new IndexOutOfBoundsException("Position out of range");
	            }
	            temp = temp.next;
	        }
	        if (temp.next == null) {
	            throw new IndexOutOfBoundsException("Position out of range");
	        }
	        temp.next = temp.next.next;  // Skip the node at the specified position
	    }
	public static void main(String[] args) {
		SLL llist = new SLL();
		llist.addFirst(1);
		llist.addLast(2);
		llist.addLast(3);
		llist.addFirst(0);
		llist.deleteFirst();
		llist.deleteLast();
		llist.insertAtPosition(10, 0);  
        llist.insertAtPosition(20, 1); 
		llist.printList();
		System.out.println("Size of the list is " + llist.getSize());
	}
}
