package babynames.linkedlist;

/**
 * 
 * @author nfatima
 * this is the necessary class for Nodes and name stats storage
 */

public class Node {
	/**declaring fields
	 * 
	 */
		private Name name; //this object provides storage for rank and number and name
		private String element; //element is the name
		private Node next; //this points to the next element in the list
		private Node previous; //points to the previous element in the list 
		
		public Node(String element, Node next, Node previous, Name name) { //constructor for all the fields
			this.element=element;
			this.next=next;
			this.previous=previous;
			this.name=name;
		}
/**
 * Getters and setters for the fields
 *
 */
		
		public String getElement(){
			return this.element;
		}
		public void setElement(String element) {
			this.element=element;
		}
		public Node getNext(){
			return this.next;
		}
		public void setNext(Node next) {
			this.next=next;
		}
		public Node getPrevious(){
			return this.previous;
		}
		public void setPrevious(Node previous) {
			this.previous=previous;
		}
		public Name getName(){
			return this.name;
		}
		
		
		
		}

