package com.codefoundry.hackerrank.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PalindromeArraySequence {

	public PalindromeArraySequence() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		String[] input = {"vipul","tyagi","amit","kumar","anku","kuhu","pihu","amit","tyagi","anku","kuhu"};
		
	
		List<String> reverseInputList = Arrays.asList(input);
		
		Collections.reverse(reverseInputList);
		
		for(String s : reverseInputList){
			System.out.println(s);
		}
		

	}

}
