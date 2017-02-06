/**
 * 
 */
package com.codefoundry.practise.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PalindroSubStr {

	public static void main(String[] args) throws NumberFormatException, IOException  {	

		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(isr);
		int no_of_tests = Integer.parseInt(bf.readLine());
		
		HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();

		while (no_of_tests > 0) {			
			
			boolean resultFound =  false;	
			charMap.clear();
			
			String s1 = bf.readLine();		
			String s2 = bf.readLine();
		
			char[] s1char = s1.toCharArray();
			char[] s2char = s2.toCharArray();
			
			for(char c : s1char) {
				if(charMap.get(c) == null) {
				charMap.put(c, 0);
				}
				
			}
			
			for(char c : s2char) {
				if(charMap.get(c) != null){
					resultFound = true;
					System.out.println("Yes");
					break;
				}
			}
			
			if(!resultFound){
				System.out.println("No");
			}			

			no_of_tests--;
		}
		
	}
}
