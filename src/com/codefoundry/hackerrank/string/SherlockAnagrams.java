package com.codefoundry.hackerrank.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SherlockAnagrams {

	public SherlockAnagrams() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		Integer noTestCases = in.nextInt();
		
		in.nextLine(); 

		List<String> inputs = new ArrayList<String>();

		for (int k = 0; k < noTestCases; k++) {

			String input = in.nextLine();   
		
			inputs.add(input);
		}

		for (String input : inputs) {
			Set<String> result = new HashSet<String>();

			SherlockAnagrams sherlockAnagrams = new SherlockAnagrams();

			AtomicInteger counter = new AtomicInteger(0);

			sherlockAnagrams.getAllSubStrings(input, 1, result, counter);
			System.out.println(counter);
		}

	}

	public void getAllSubStrings(String input, Integer length, Set<String> result, AtomicInteger counter) {

		if (length > input.length()) {
			return;
		}

		int loopLength = input.length() - length;

		for (int i = 0; i <= loopLength; i++) {

			char[] chars = input.substring(i, i + length).toCharArray();
			Arrays.sort(chars);
			//System.out.println(new String(chars));
			
			if (!result.add(new String(chars))) {
				//System.out.println("DONE");
				counter.incrementAndGet();
			}
		}

		length++;
		getAllSubStrings(input, length, result, counter);

	}

}
