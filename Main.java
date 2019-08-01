package babynames.linkedlist;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
/**
 * Noor Fatima's Lab
 * this main class calls all the imp stats
 */

/**
 * This is where you will parse the given command line arguments indicating which sex, name, and
 * files to include.
 */
public class Main 
{
    public static void main( String[] args ) throws IOException{	
    	ArrayList<String> Mnames= new ArrayList<String>(); //making arraylist for male names that stores the info from args in command line
    	ArrayList<String> Fnames= new ArrayList<String>(); //same as above for females
    	ArrayList<String> fileNames= new ArrayList<String>(); //stores the filenames
    	
    	
    	for(int i=0;i<args.length;i++) {  //for loop that goes through the command line args
    		if (args[i].equals("-m")) { //if -m then adds the next element which is male name to the Mnames array list
    			Mnames.add(args[i+1]);
    			i++;
    		}
    		else if (args[i].equals("-f")){
    			Fnames.add(args[i+1]);
    			i++;
    		}	
    		else { //if its not -m or -f then that line would be csv names, adds it to the filenames arraylist
    			fileNames.add(args[i]);		
    		}
    	}
    	
    	

    	 BabyLinkedList maleNames= new BabyLinkedList(); //making a linked list for male names
    	 BabyLinkedList femaleNames= new BabyLinkedList();//^^for femmale names
    	 int globalMaleTotal = 0; //global int for male names keeps total of the total number of name in all files
    	 int globalFemaleTotal=0;
    	 
    	 for(int i=0;i<fileNames.size();i++) {
			CSVReader reader = new CSVReader(new FileReader(fileNames.get(i))); //reads all the csvs by using names from filenames array
			int maleTotalNumber=0; //total male number in a specific csv
			int femaleTotalNumber=0;
			String[] nextline; //string array is the whole csv line
			while((nextline = reader.readNext())!=null) { //keeps on reading the whole file
				maleTotalNumber+=Integer.parseInt(nextline[2]); //the position of the male name number in csv
				femaleTotalNumber+=Integer.parseInt(nextline[4]);
			}
			globalMaleTotal+=maleTotalNumber; //global number is adding up all the number of names in csv
			globalFemaleTotal +=femaleTotalNumber;
			    	 		 		  	
	       reader.close();	
    	 		
    	 		
    	 		 
	       	reader = new CSVReader(new FileReader(fileNames.get(i))); //reading it again to get other stats for year
    		      
					int year=Integer.parseInt(fileNames.get(i).substring(5, 9)); //takes the year out from the csv file
					
					while((nextline = reader.readNext())!=null) 
					{

						Node males=maleNames.add(nextline[1]);  //males is the male names in the csv
						Node females=femaleNames.add(nextline[3]);
						
				  /**
				   * this gets the name from the males/females and uses addyear method to get the required stats
				   */
					    males.getName().addYear(Integer.parseInt(nextline[0]),  Integer.parseInt(nextline[2]), (double) Integer.parseInt(nextline[2])/ (double) maleTotalNumber, year);
					    females.getName().addYear(Integer.parseInt(nextline[0]),  Integer.parseInt(nextline[4]), (double) Integer.parseInt(nextline[4])/ (double) femaleTotalNumber, year);	 	    	   
				}
					    	 		 		  	
    		       reader.close();	
    	 		}

    	 		Node maleBabies=maleNames.getHead(); //definfing node for male babies, gets the names
    	 		while(maleBabies!=null) {
//    	 			System.out.println(maleBabies.getElement()); //prints a sorted list of all the names from the files
    	 			maleBabies=maleBabies.getNext(); //adds all names to a sorted linked list

    	 			
    	 		}
    	 		
    	 		
    	 		Node femaleBabies=femaleNames.getHead();
    	 		while(femaleBabies!=null) {
//    	 			System.out.println(femaleBabies.getElement());
    	 			femaleBabies=femaleBabies.getNext();
    	 		}
    	 		
    	 		/**
    	 		 * these print out all the total and yearly stats for male or female names using method from babylinkedlist class
    	 		 */
    	 		
    	 		for(int i=0; i<Mnames.size(); i++) {  
    	 			maleNames.printMale(Mnames.get(i), globalMaleTotal);}
    	 	
    	
    	 		for(int i=0; i<Fnames.size(); i++) {
    	 			femaleNames.printFemale(Fnames.get(i), globalFemaleTotal);}
 	
    			}
    
	

    			}
    	

