/**
 * 
 */
package com.codefoundry.hackerrank.string;

import java.util.Scanner;

/**
 * @author vipul
 *
 */
public class AlternatingCharacters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		
		int numOfTestCase = in.nextInt();
		in.nextLine(); 
		for(int i=0; i<numOfTestCase; i++ ){		
			
	        String input = in.nextLine();    
	        
	        int count = 0;
	        
	        char[] inputArray = input.toCharArray();     
	       
	        
	        char prev = '-';
	        
	        for(int j=0; j <inputArray.length; j++ ){
	        	char nextChar = inputArray[j];
	        	
	        	if(nextChar != prev){
	        		prev = nextChar;
	        		continue;
	        	}else {
	        		count++;
	        	}
	        }	
	        System.out.println(count);
			
		}
	}

}
