package babynames.linkedlist;
/**
 * 
 * @author nfatima
 *this class contains doubly sorted linked list and methods for printing totals and percentages
 */
        

public class BabyLinkedList {
	

/**declaration of fields
 * 
 */

		private Node head,tail; 
		private int size; 
		
		public BabyLinkedList() { //empty constructor because initializing parameters inside
			this.size = 0;
			this.head=null;
			this.tail=null;
		}
		
/**getters and setters
 *
 */
		public Node getHead(){
			return this.head;
		}

		public Node getTail(){
			return this.tail;
		}
	
		
	/**methods for a sorted linked list
	 * 	
	 */
			
		public Node add(String element)
		{
			
			if (size==0)
			{
				Name newname= new Name();
				head = new Node(element, null, null,newname);
				tail = head;
				size++;
				return head;
			}
			else
			{
			 if (element.compareTo(head.getElement()) < 0)
			{
					// insert before head, make new head
					// set next to head, previous to null
					Name newname= new Name();
					Node newNode = new Node(element, head, null,newname);
					// point old head previous to new node
					head.setPrevious(newNode);
					// make new node head
					head = newNode;
					size++;
					return head;
			}
				if (element.equals(head.getElement())){
					return head;
			
			}
				else
				{
					Node current = head.getNext();
					while (current != null && element.compareTo(current.getElement()) > 0)
					{
						current = current.getNext();
							
			}
					if(current==null) 
					{
						Name newname= new Name();
						Node newNode = new Node(element, null, tail,newname);
						tail.setNext(newNode);
						tail = newNode;
						size++;
						return tail;
		   }
						
					if (element.equals(current.getElement()))
						{
						return current;
						
						
		   }
					
					if(current != null) 
					{
						Name newname= new Name();
						Node newNode = new Node(element, current, current.getPrevious(),newname);
						
						current.getPrevious().setNext(newNode);
				
						current.setPrevious(newNode);
						size++;
						return newNode;
			}
					
					
			}
	
			}
			return null;
			
			
			}
		
	/**methods for printing the total and the yearly info for male and female babynames
	 * 
	 */
		public void printMale(String name, int globalMaleTotal) { //prints stats for male names
			Node current = head; //current is a node that is being set to head
			int pos = 0; //initializing the position for that name in the linked list of given csvs
			while (current != null &&!current.getElement().equals(name)) //while loop to go through the list to find that name
			{
				current = current.getNext(); //keeps on moving to the next element
				pos++; //increasing the position to find where the name is in the list
		}
			int myNum=current.getName().getNumber(); //initializing myNum which is the total number of names in the years given
			int count=1; //initializing count which is the rank of the name in a linked list from csv
			Node curr=head; //curr is a node being initialized as equal to head, it will keep on moving forward as it keeps on finding the name
			while(curr!=null) { //so that it loops through the whole list
				if (curr.getName().getNumber()>myNum) { //its gonna check and count the number of names with higher total number than that of the name i gave(mynum)

				count +=1;} //this is the rank of the name givem=n, will keep on adding 1 whenever a name with greater frequency is found
				curr=curr.getNext(); //will help keep on moving through the list
		}
			double percentage= (double) myNum/ (double)globalMaleTotal; //finds percentage for that name in the total names for all the csvs provided, globalmaletotal was defined in main
			/**printing out the stats
			 * 
			 */
			System.out.println(pos);
			System.out.println("                       ");
			current.getName().print(current.getElement()); //prints stats for a year using the method in Name class
			
			System.out.println("Total");
			System.out.println(name+":"+""+count+","+""+myNum+","+""+percentage);

		}
		
		
		/** same commenting for female stats
		 * 
		 */
		
		public void printFemale(String name, int globalFemaleTotal) {
			Node current = head;
			int pos = 0;
			while (current != null &&!current.getElement().equals(name))
			{
				current = current.getNext();
				pos++;
		}
			int myNum=current.getName().getNumber();
			int count=1;
			Node curr=head;
			while(curr!=null) {
				if (curr.getName().getNumber()>myNum) {

				count +=1;}
				curr=curr.getNext();
		}
			double percentage= (double) myNum/ (double)globalFemaleTotal;
			System.out.println(pos);
			System.out.println("                       ");
			current.getName().print(current.getElement());
			
			System.out.println("Total");
			System.out.println(name+":"+""+count+","+""+myNum+","+""+percentage);
			

		}
			
			
			
}			
			

