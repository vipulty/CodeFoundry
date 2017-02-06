package com.codefoundry.practise.general;

import java.util.Stack;

public class Braces {

	public Braces() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		String[] values = new String[2];
		
		values[0] = "{}[]()";
		values[1] = "{[}]}";
		
		 String[] s1 = braces(values);
		 
		 for(String s : s1){ 
			 System.out.println(s);
		 }

	}
	
	static String[] braces(String[] values) {
		
		char[] startC = new char[3];
		startC[0] = '{';
		startC[1] = '[';
		startC[2] = '(';
		
		
		char[] endC = new char[3];
		endC[0] = '}';
		endC[1] = ']';
		endC[2] = ')';
		
		String[] results = new String[values.length];
		
		int i = 0;
		
		for(String s : values){
			
			boolean resultFound = true;
			
			java.util.Stack s1 = new java.util.Stack();
			
			char [] sChar = s.toCharArray();
			
			for(char c : sChar){
				
				for(char start : startC){
					
					if(c == start){
						s1.push(c);
						break;
					}
					
				}
				
				int j = 0;
				
				for(char end : endC){
					
					char pop;
					
					if(c == end){
						pop = (char) s1.pop();
						
						if(pop != startC[j]){
							
							resultFound = false;
						}						
						break;
					}
					
				 j++;	
				}
				
				if(!resultFound){
					break;
				}
				
			}
			
			if(resultFound){
				results[i] = "YES";
			}else {
				results[i] = "NO";
			}
			
			
			i++;
		}
		
		
		return results;


    }

}
