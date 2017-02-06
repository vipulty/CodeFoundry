package com.codefoundry.hackerrank.array;

//https://www.hackerrank.com/contests/may-world-codesprint/challenges/richie-rich

import java.util.Scanner;

public class RichieRich {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int numOfDigits = in.nextInt();
		int numOfChangesAllowed = in.nextInt();

		String number = in.next();		

		Integer[] input = new Integer[numOfDigits];

		for (int i = 0; i < numOfDigits; i++) {
			input[i] = number.charAt(i) - '0';
		}

		//System.out.println(numOfDigits);
		//System.out.println(numOfChangesAllowed);
		

		Boolean[] trackChanges = new Boolean[numOfDigits];
		
		for(int i=0; i<numOfDigits; i++ ){
			trackChanges[i] = false;
		}
		
		int startIndex = 0;
		int endIndex = input.length - 1;

		int numOfChangesMade = 0;

		boolean isPalindrome = false;

		while (true) {	
			
			if(isPalindrome && numOfChangesMade >= numOfChangesAllowed){
				break;
			}

			if (startIndex > endIndex) {
				
				if (numOfChangesMade > numOfChangesAllowed) {
					
					isPalindrome = false;
					break;
				} else if(numOfChangesMade == numOfChangesAllowed){
					
					isPalindrome = true;
					break;
				}

				if (numOfChangesMade < numOfChangesAllowed) {
					
					startIndex = 0;
					endIndex = input.length - 1;
					isPalindrome = true;					
				}				
			}

			int startElement = input[startIndex];
			int endElement = input[endIndex];

			if (startElement == endElement) {

				if (isPalindrome) {

					if (startElement != 9 && startIndex != endIndex) {
						
						if(trackChanges[startIndex] || trackChanges[endIndex]){
							numOfChangesMade = numOfChangesMade - 1;
						}

						if ((numOfChangesMade + 2) <= numOfChangesAllowed) {
							
							input[startIndex] = 9;
							input[endIndex] = 9;
							numOfChangesMade = numOfChangesMade + 2;
						}
					}else if(startElement != 9 && startIndex == endIndex){
						if ((numOfChangesMade + 1) <= numOfChangesAllowed) {
							
							input[startIndex] = 9;
							input[endIndex] = 9;
							numOfChangesMade = numOfChangesMade + 1;
						}
					}
				}

			} else if (startElement > endElement) {

				input[endIndex] = startElement;
				numOfChangesMade++;
				trackChanges[endIndex] = true;

			} else if (startElement < endElement) {
				trackChanges[startIndex] = true;
				input[startIndex] = endElement;
				numOfChangesMade++;
			}
			startIndex++;
			endIndex--;
		}

		if (isPalindrome) {
            
			for(int i=0; i<numOfDigits; i++ ){
				System.out.print(input[i]);	
			}
		} else {
			System.out.println(-1);
		}
		
	}

}
