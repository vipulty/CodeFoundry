package com.codefoundry.practise.general;

import java.util.Scanner;

public class StringPermu {

	public static void main(String arg[]) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		permutation(input);

	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {

		if(str.length() == 0){
			System.out.println(prefix);
		}
		
		for(int i=0;  i < str.length(); i++) {
		  permutation(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1,str.length()));
		}		
	}
}
