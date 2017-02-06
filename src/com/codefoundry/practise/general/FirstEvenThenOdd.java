package com.codefoundry.practise.general;

import java.util.Scanner;

public class FirstEvenThenOdd {

	public static void main(String arg[]) {
		   Scanner s = new Scanner(System.in);
		   int count = s.nextInt(); 
		   
		   int [] numbers = new int[count];
	       Scanner numScanner = new Scanner(s.nextLine());
	       for (int i = 0; i < count; i++) {
	           if (numScanner.hasNextInt()) {
	               numbers[i] = numScanner.nextInt();
	             
	           } else {
	               System.out.println("You didn't provide enough numbers");
	               break;
	           }
	       }
	       
	       int [] result = new int[count];
	       
	       for (int i = 0; i < count; i++) {
	    	   
	    	   
	    	   
	       }
	       
	}      
	
}
