package babynames.linkedlist;

import java.util.ArrayList;
/**
 * 
 * @author nfatima
 *this class stores stats for years and totals
 */

public class Name { 
	/**year class to store all the stats for years
	 *
	 */
	private class Year{
		/**declaring the variables
		 * 
		 */
		private int rank;
		private int number;
		private double percentage;
		private int year;
		
		private Year(int rank, int number, double percentage, int year) { //constructor for the year class, will use this later to put stuff in arraylist of year
			this.rank=rank;
			this.number=number;
			this.percentage=percentage;
			this.year=year;
			
		}
		/**getters and setters
		 * 
		 */
		//no setters because info isn't gonna change
		public int getRank() {
			return rank;
		}
	
		public int getNumber() {
			return number;
		}

		public double getPercentage() {
			return percentage;
		}

		public int getYear() {
			return year;
		}

		
	}
/**declaring fields for name class
 * 
 */
	 
	public int rank;
	public int number;
	public String name;
	public ArrayList<Year> year; //this array list stores data for each year
	
	
	public Name() { //initializing info inside the constructor
		year=new ArrayList<Year>();
		this.number=0;
		
		

	}
	
	
/**getters and setters for name class
 */
	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public void addYear(int rank, int number, double percentage, int year) { //this methods adds info to the arraylist year
		Year newyear= new Year(rank, number, percentage, year); //this helps get yearly stats in main
		this.year.add(newyear); //adds all the stats together for total
		this.number=this.number+number; //adds for the total stats
		
		
	}

	public void print(String name) { //method to print out yearly info
		/**initializing the variables
		 * 
		 */
		double percentage = 0; 
		int yearOfInstance = 0;
		
		for(int i=0; i<year.size();i++) { //for loop goes through the year arraylist
			rank= year.get(i).getRank(); //gets rank for the specific year 
			number=year.get(i).getNumber(); //gets the total number for specific year
			percentage=year.get(i).getPercentage(); //gets percentage for the year
			yearOfInstance=year.get(i).getYear(); //gets the year for that year
			/**printing out the necessary stuff but will call it in the BabyLinkedList file method, wont actually call in main
			 * 
			 */
			System.out.println(yearOfInstance);
			System.out.println(name+":"+" "+ rank + "," + " " + number + ", "+ percentage);
			System.out.println("                        ");
		}
	
		}
		
		
		
		
		
	}
	
	
	


