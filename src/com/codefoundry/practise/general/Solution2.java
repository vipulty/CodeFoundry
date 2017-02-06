package com.codefoundry.practise.general;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int totalSum = in.nextInt();
		int numOfEle = in.nextInt();
		numOfEle = numOfEle+1;

		int[] arr = new int[numOfEle];
		arr[0] = 0;

		for (int i = 1; i < numOfEle; i++) {
			int pos = in.nextInt();
			arr[i] = pos;
		}

		int result[][] = new int[numOfEle][numOfEle];

		for (int i = 0; i < numOfEle; i++) {
			System.out.print("i = " + i);
			
			for (int j = 0; j < numOfEle; j++) {
				System.out.print("j = " + j);
				if (i == 0) {
					result[i][j] = 0;
				} else if (arr[i] > arr[j]) {
					result[i][j] = result[i - 1][j];
				} else {
					int total = 0;
					if (arr[j] % arr[i] == 0) {
						total = result[i-1][j] + 1; 						
					} else {
						int backIndex = arr[j] - arr[i];
						total = result[i-1][j] + result[i][backIndex] + 1;
					}
					result[i][j] = total;
				}
				System.out.print(" " + result[i][j]);
			}
		
		}
		
		System.out.println(result[numOfEle-1][numOfEle-1]);
		
	//	for (int i = 0; i < numOfEle; i++) {
	//		System.out.println("");
	//		for (int j = 0; j < numOfEle; j++) {
     //        System.out.print(" " + result[i][j]);
	//		}
	//	}		
	}
}
