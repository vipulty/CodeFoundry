package com.codefoundry.hackerrank.string;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SherlockValidString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		char[] inputArr = input.toCharArray();
		
		Map<Character,Integer> charFreqs = new HashMap<Character,Integer>();
		
		for(char charV : inputArr){
			
			Integer freq = charFreqs.get(charV);
			
			if(freq == null){
				charFreqs.put(charV, 1);
			}else {
				freq++;
				charFreqs.put(charV, freq);
			}
			
		}
		
		Map<Integer,Integer> freqs = new HashMap<Integer,Integer>();
		
		for(Entry<Character, Integer> charFreq : charFreqs.entrySet()){		
			Integer freq = freqs.get(charFreq.getValue());
			
			if(freq == null){
				freqs.put(charFreq.getValue(), 1);
			}else {
				freq++;
				freqs.put(charFreq.getValue(), freq);
			}
		}
		
		
		
		if(freqs.size() > 2){
			 System.out.println("NO");	
		}else if(freqs.size() == 1) {		
			System.out.println("YES");	
		}else if(freqs.size() > 0) {			
			boolean outPut = false;
			for(Entry<Integer, Integer> freq : freqs.entrySet()){
				if(freq.getValue() == 1) {
					System.out.println("YES");	
					outPut = true;
					break;
				}
			}		
			if(!outPut){
				System.out.println("NO");		
			}
		} else {
			System.out.println("NO");	
		}
		
	}
}
