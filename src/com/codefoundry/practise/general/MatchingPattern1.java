package com.codefoundry.practise.general;

import java.util.HashMap;
import java.util.Map;

public class MatchingPattern1 {

	public static void main(String[] args) {
	    Map<Character, String> map = new HashMap<>();
		String str = "GkTrGk";		
		
		String patt = "aba";
		boolean result = ifPattern(str, patt, str.length()-1, patt.length()-1, 0, 0, map);
		
		System.out.println(result);
	}
	
	
	private static boolean ifPattern(String str, String patt, int strLen,int pattLen, int i, int j,  Map<Character, String> map) {
		
		System.out.println("i = " + i + " , j = " + j);
		
		if(i > strLen  || j > pattLen ){
			return false;
		}
		
	    String exist = map.get(patt.charAt(j));
		
		if(exist != null){		
			
			String s = str.substring(i, i+1);
			
			System.out.println(exist + " ----> " + s);
			
			if(!s.equals(exist)){
				return false;
			}
			
			//boolean res = ifPattern(str, patt, strLen, pattLen, k+i+1, j+1, map);
			
			return false;
		}
		
		
		for(int k = 0; k <= strLen; k++){
			
			Character ch = patt.charAt(j);			
			String s = str.substring(i, k+i+1);
			
			System.out.println(ch + " -> " + s);
			
			map.put(ch, s);
			
			boolean res = ifPattern(str, patt, strLen, pattLen, k+i+1, j+1, map);
			
			if(!res){
				map.remove(ch);
				System.out.println("Removed " + ch);
			}
		}
		
		
		
		return false;	
	}

}
