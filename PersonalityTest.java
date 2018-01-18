/**
*  author: Emil Dides and Bryan Vuong
*  date:  11-17-10
*  CS 305j Assignment 2
*  On my honor, Emil Dides and Bryan Vuong this programming assignment is my (our) own work.
*
*  EID: ED6295, B
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
11/15/10, 9-11 Bryan 1 Hour
total time 2 hours, 2 hours of pair programming.

only problems we encountered was the casting in the last part of the program.
We learned more about casting and also file input and output, how it works.
*/

//Emil starts Driving.
import java.util.*;
import java.io.*;
public class PersonalityTest {

	public static void main(String[] args) 
	throws IOException
    {
      
		// ask the user for the filename
          Scanner scan  = new Scanner(System.in);
          System.out.print("Input file name: ");
          String theFile = scan.nextLine();  // file may contain more than one word
          File fileIn = new File(theFile);

          // ask the user for another filename if the given file doesn't exist/ can't be read.
          while(!fileIn.exists()) 
          {
             System.out.print("File not found. Try again: ");
             theFile = scan.nextLine();
             fileIn = new File(theFile);
          }

          //Prompt for Output File
          System.out.print("Output file name: ");
          String outFile = scan.nextLine();
          File fileOut = new File(outFile);
          PrintStream writeStream = new PrintStream(fileOut);
          
         //Emil has stopped driving. Bryan is now Driving.
          
          //The array to write to file.
         int[] array = new int[4];
         //The Arrays for the personality group problems.
         int[] first = {1,8,15,22,29,36,43,50,57,64,0,0,0,0,0,0,0,0,0,0};
         int[] second = {2,3,9,10,16,17,23,24,30,31,37,38,44,45,51,52,58,59,65,66};
         int[] third = {4,5,11,12,18,19,25,26,32,33,39,40,46,47,53,54,60,61,67,68};
         int[] fourth = {6,7,13,14,20,21,27,28,34,35,41,42,48,49,55,56,62,63,69,70};
      
        
          //Scanning line by line, first to record name.
			Scanner fileScan = new Scanner(fileIn);
			while (fileScan.hasNextLine())
			{
				//Get person's name
				String line = fileScan.nextLine();
				if ( line.length() < 70 ){
					writeStream.print(line + ": ");
				}
				else {
				
				int countFA = 0;
				int countFB = 0;
				int countSA = 0;
				int countSB = 0;
				int countTA = 0;
				int countTB = 0;
				int countFOA = 0;
				int countFOB = 0;
				//Bryan has stopped driving. Emil is now Driving.
				
				
				//Checking each line for A's and B's, if found then compare to which group the problem answered belongs to.
				//If it is in a certain group, then increment counter for that group, for both A and B.
				
				//Introvert/Extrovert
					for ( int i =1; i <= line.length();i++){
						char ch = line.charAt(i-1);{
							for (int j=0; j < 20;j++){
							if( first[j] == i ){
								if ( ch == 'a' || ch == 'A'){
									countFA++;}
								if ( ch == 'B' || ch == 'b'){
									countFB++;
								}
							}

					//Sensing/Intuition
							if( second[j] == i ){
								if ( ch == 'a' || ch == 'A'){
									countSA++;}
								if ( ch =='B' || ch == 'b'){
									countSB++;
								}
							}
					//Thinking/Feeling
							if( third[j] == i ){
								if ( ch == 'a' || ch == 'A'){
									countTA++;}
								if ( ch =='B' || ch == 'b'){
									countTB++;
								}
							}
					//Judging/Perceiving
							if( fourth[j] == i ){
								if ( ch == 'a' || ch == 'A'){
									countFOA++;}
								if ( ch =='B' || ch == 'b'){
									countFOB++;
								}
							}
							}
						}
					}
				//Output to file
					
				String str = "";
					
				//Extrovert/Introvert
				
				//Taking how many A's and B's and printing to file, information.
				if(countFB > countFA){
					str+="I";}
				else if(countFB < countFA){
					str += "E";}
				else {
					str += "X";}
				
				double percent1 = (countFB* 100.0/(countFA+countFB) + .5);
				array[0] = (int) percent1;
				
				//Emil has stopped Driving. Bryan is now Driving.
				
				//Group 2: Sensing/Intuition
				
				//Taking how many A's and B's and printing to file, information.
				if(countSB > countSA)
					str+="N";
				else if(countSB < countSA)
					str += "S";
				else 
					str += "X";
					
				double percent = (countSB* 100.0/(countSA+countSB) + .5);
				array[1] = (int) percent;
				//array[1] = (countSB* 100/(countSA+countSB));
					
				//Thinking/Feeling
				
				//Taking how many A's and B's and printing to file, information.
				if(countTB > countTA)
					str+="F";
				else if(countTB < countTA)
					str += "T";
				else 
					str += "X";
				//Bryan has stopped Driving. Emil is Driving.
				double percent2 = (countTB * 100.0 /(countTA+countTB)+.5);
				array[2] = (int) percent2;
				
				//Judging/Perceiving
				
				//Taking how many A's and B's and printing to file, information.
				if(countFOB > countFOA)
					str += "P";
				else if(countFOB < countFOA)
					str += "J";
				else 
					str += "X";
				
				//Emil has stopped Driving. Bryan is Driving.
				
				double percent3 = (countFOB * 100.0 /(countFOA+countFOB) +.5);
				array[3] = (int) percent3;

				String a = Arrays.toString(array);
				writeStream.println(a + " = " + str);
				
				}
			}
    }
}

		
