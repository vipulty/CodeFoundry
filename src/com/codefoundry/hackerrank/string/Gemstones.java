package com.codefoundry.hackerrank.string;

import java.util.Arrays;
import java.util.Scanner;

public class Gemstones {

	public Gemstones() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfRocks = in.nextInt();

		String[] stones = new String[numOfRocks];

		int[] currentIndexes = new int[numOfRocks];

		int minLength = Integer.MAX_VALUE;
		int minIndex = -1;
		String minString = null;

		for (int i = 0; i < numOfRocks; i++) {

			char[] chars = in.next().toCharArray();
			Arrays.sort(chars);
			String sorted = new String(chars);

			stones[i] = sorted;

			if (sorted.length() < minLength) {
				
				minLength = sorted.length();
				minIndex = i;
				minString = sorted;
			}
			currentIndexes[i] = -1;
			
			//System.out.print(sorted + " ");
		}

		int gemCount = 0;

		char[] minStringCharArray = minString.toCharArray();

		for (int j = 0; j < minLength; j++) {

			Character currentChar = new Character(minStringCharArray[j]);
			currentIndexes[minIndex] = j;

			boolean isGem = true;
			boolean isDone = false;

			for (int k = 0; k < stones.length; k++) {

				if (k == minIndex) {
					continue;
				}

				String stone = stones[k];
				
				//System.out.println("stone = " + stone);

				char[] stoneArray = stone.toCharArray();

				while (true) {
					
					int nextCharIndex = currentIndexes[k] + 1;
					// currentIndexes[k] = nextCharIndex;
					
					if(nextCharIndex >= stone.length() ){
						
						isDone = true;
						isGem = false;
						break;
					}
					
					Character nextChar = stoneArray[nextCharIndex];

					if (nextChar.compareTo(currentChar) == 0) {
						
					//	System.out.println(currentChar + " matched");
						currentIndexes[k] = nextCharIndex;
						isGem = true;
						break;
					} else if (nextChar.compareTo(currentChar) > 0) {
						isGem = false;
						currentIndexes[k] = nextCharIndex;
						break;
					} else if (nextChar.compareTo(currentChar) < 0) {
						currentIndexes[k] = nextCharIndex;
						isGem = false;
					}
				}
				
				if (isDone) {
					break;
				}

			}

			if (isGem) {
				gemCount++;
			}
		}

		System.out.println(gemCount);

	}

}
