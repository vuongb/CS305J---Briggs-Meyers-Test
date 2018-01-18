/**
*  author: Emil Dides and Bryan Vuong
*  date:  11-17-10
*  CS 305j Assignment 2
*  On my honor, Emil Dides and Bryan Vuong this programming assignment is my (our) own work.
*
*  EID: ED6295, BKV85
*  Section: Emil - 11-12 (Oliver) Bryan - 3-4(Christian)
*
* <Brief Description - what does the program do? This program asks the user for the file name of the personality test information.
* Once the user has typed in the file name, then the program will take how many A's and B's are in the line and prints information regarding
* the program for the first name in the list. Then, the output with the percentages etc. are printed in the output file.
*
* Slip Days I am using on this project: 0
* Slip Days I have used this semester: 0
* 
* 11/15/10, 9-11 Emil 1 Hour
* 11/15/10, 9-11 Bryan 1 Hour
* total time 2 hours, 2 hours of pair programming.

* The problems we encountered was the casting in the last part of the program and breaking
* our code into methods as well as passing files as parameters, and creating the objects for each
* method
* We learned more about casting and also file input and output, how it works.
*/

//Emil starts Driving.
import java.util.*;
import java.io.*;
public class PersonalityTest {

	public static void main(String[] args) 
	throws IOException
    {
      
		// Get input file
		File fileIn = input();
		
		//Get desired output name and create it
		File fileOut = output();
        
		//This method does all of the processing and outputs
		//the date to the desired output file.
		process(fileIn, fileOut);
    }
//End of Emil Driving, Bryan starts Driving.
	
	// The method gets the user's desired file to be analyzed and
	// requests for another file to be given if the file can't be read
	// or doesn't exist
	// The method returns the input file object
	public static File input()
	{
        Scanner scan  = new Scanner(System.in);
        //Prompt the user for the desired input file to be processed
        System.out.print("Input file name: ");
       
        //Create the input file object
        String theFile = scan.nextLine();  // file may contain more than one word
        File fileIn = new File(theFile);
        
        // If the file is unable to be read or doesn't exist, the program
        // will continuously request a new file until one that can be
        // read and exists is given.
        while(!fileIn.canRead()) 
        {
           System.out.print("File not found. Try again: ");
           theFile = scan.nextLine();
           fileIn = new File(theFile);
        }
        return fileIn;
	}

//End of Bryan Driving, Emil starts Driving.
	
	// This method gets and creates the user's desired output file
	// The method returns the output file object
	public static File output() throws IOException
	{
        Scanner scan  = new Scanner(System.in); 
		System.out.print("Output file name: ");
	    String outFile = scan.nextLine();
	    File fileOut = new File(outFile);
	    return fileOut;
	}
	
	// This method does the main work of the program. It gets
	// the test taker's name file, sorts the test questions
	// and answers into its 4 respective groups, determines
	// the person's characteristics based on answers in each
	// group, determines the % of the test taker's answers
	// were B, and outputs all of this to the desired output file.
	// The method takes the input and output file objects as parameters
	public static void process(File fileIn, File fileOut) throws IOException
	{
        // Initialization
		
		// Array "array" is the output array containing the
		// % of B answers in the 4 groups from left to right, Group 1-4
		int[] array = new int[4];
       
		// Array first contains all of the problem numbers for group 1
        int[] first = {1,8,15,22,29,36,43,50,57,64,0,0,0,0,0,0,0,0,0,0};
        
		// Array second contains all of the problem numbers for group 2
        int[] second = {2,3,9,10,16,17,23,24,30,31,37,38,44,45,51,52,58,59,65,66};
        
		// Array third contains all of the problem numbers for group 3
        int[] third = {4,5,11,12,18,19,25,26,32,33,39,40,46,47,53,54,60,61,67,68};
        
		// Array fourth contains all of the problem numbers for group 4
        int[] fourth = {6,7,13,14,20,21,27,28,34,35,41,42,48,49,55,56,62,63,69,70};
		
        //Scanning line by line, first to record name.
		Scanner fileScan = new Scanner(fileIn);
		PrintStream writeStream = new PrintStream(fileOut);
		
		// The program will take each line and convert it into
		// a string while there still exists a line to be analyzed
		while (fileScan.hasNextLine())
		{
			// Get person's name
			// There are 70 Q's, if the string contains less than 70
			// characters, the string must be the name
			String line = fileScan.nextLine();
			if ( line.length() < 70 ){
				writeStream.print(line + ": ");
			}
			
			//If it isn't a name, the string must be the test answers
			else {
			
			// The variables keep track of how many A's and B's 
			// were answered in each group
			int countFA = 0;
			int countFB = 0;
			int countSA = 0;
			int countSB = 0;
			int countTA = 0;
			int countTB = 0;
			int countFOA = 0;
			int countFOB = 0;
			
// Emil has stopped driving. Bryan is now Driving.
			
			//Checking each line for A's and B's, if found then compare to which group the problem answered belongs to.
			//If it is in a certain group, then increment counter for that group, for both A and B.
			
				// i keeps track of what problem # is currently
				// being examined and extracts the test taker's answer
				// for that question
				for ( int i =1; i <= line.length();i++){
					char ch = line.charAt(i-1);
						for (int j=0; j < 20;j++)
						{	
							// Introvert/Extrovert
							// Checks to see if the answer is among
							// the first group
							if( first[j] == i )
							{
								if ( ch == 'a' || ch == 'A'){
									countFA++;}
								if ( ch == 'B' || ch == 'b'){
									countFB++;}
							}

							//Sensing/Intuition
							// Checks to see if the answer is among
							// the second group
							if( second[j] == i ){
								if ( ch == 'a' || ch == 'A'){
									countSA++;}
								if ( ch =='B' || ch == 'b'){
									countSB++;}
							}
							//Thinking/Feeling
							// Checks to see if the answer is among
							// the third group
							if( third[j] == i ){
								if ( ch == 'a' || ch == 'A'){
									countTA++;}
								if ( ch =='B' || ch == 'b'){
									countTB++;}
							}
							//Judging/Perceiving
							// Checks to see if the answer is among
							// the fourth group
							if( fourth[j] == i ){
								if ( ch == 'a' || ch == 'A'){
									countFOA++;}
								if ( ch =='B' || ch == 'b'){
									countFOB++;}
							}
						}
				}
			
//Bryan has stopped Driving. Emil is now Driving.
				
				//Output to file
			
			// String str contains the test taker's personality
			String str = "";
				
			//Group 1: Extrovert/Introvert
			
			//Taking how many A's and B's and printing to file, information.
			//If # of B's > # of A's, str gets I for Introvert
			//If # of B's < # of A's, str gets E for Extrovert
			//Otherwise if the # of B's = # of A's, str gets X.
			if(countFB > countFA){
				str+="I";}
			else if(countFB < countFA){
				str += "E";}
			else {
				str += "X";}
			
			// Gets the % of answers that were B in Group 1 and outputs it
			// to slot 1 of the output array
			double percent1 = (countFB* 100.0/(countFA+countFB) + .5);
			array[0] = (int) percent1;
			
			
			//Group 2: Sensing/Intuition
			
			//Taking how many A's and B's and printing to file, information.
			//If # of B's > # of A's, str gets N for Intuition
			//If # of B's < # of A's, str gets S for Sensing
			//Otherwise if the # of B's = # of A's, str gets X.
			if(countSB > countSA)
				str+="N";
			else if(countSB < countSA)
				str += "S";
			else 
				str += "X";
				
			// Gets the % of answers that were B in Group 2 and outputs it
			// to slot 2 of the output array
			double percent = (countSB* 100.0/(countSA+countSB) + .5);
			array[1] = (int) percent;
				
			//Group 3: Thinking/Feeling
			
			//Taking how many A's and B's and printing to file, information.
			//If # of B's > # of A's, str gets F for Feeling
			//If # of B's < # of A's, str gets T for Thinking
			//Otherwise if the # of B's = # of A's, str gets X.
			if(countTB > countTA)
				str+="F";
			else if(countTB < countTA)
				str += "T";
			else 
				str += "X";
			// Gets the % of answers that were B in Group 3 and outputs it
			// to slot 3 of the output array
			double percent2 = (countTB * 100.0 /(countTA+countTB)+.5);
			array[2] = (int) percent2;
			
			//Group 4: Judging/Perceiving
			
			//Taking how many A's and B's and printing to file, information.
			//If # of B's > # of A's, str gets P for Perceiving
			//If # of B's < # of A's, str gets J for Judging
			//Otherwise if the # of B's = # of A's, str gets X.
			if(countFOB > countFOA)
				str += "P";
			else if(countFOB < countFOA)
				str += "J";
			else 
				str += "X";
			
//Emil has stopped Driving. Bryan is Driving.
			
			// Gets the % of answers that were B in Group 4 and outputs it
			// to slot 4 of the output array
			double percent3 = (countFOB * 100.0 /(countFOA+countFOB) +.5);
			array[3] = (int) percent3;

			// Converts the output array to a string and writes it
			// to the output file and also writes the person's
			// personality traits from the test.
			String a = Arrays.toString(array);
			writeStream.println(a + " = " + str);
			}
		}
	}
}

		
