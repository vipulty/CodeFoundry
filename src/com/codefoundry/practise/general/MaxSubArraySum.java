package com.codefoundry.practise.general;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxSubArraySum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCase = in.nextInt();

		for (int i = 0; i < noOfTestCase; i++) {

			int numOfEle = in.nextInt();

			int[] arr = new int[numOfEle];

			for (int j = 0; j < numOfEle; j++) {
				int pos = in.nextInt();
				arr[j] = pos;
			}

			BigInteger[] result = new BigInteger[numOfEle];
			BigInteger max = new BigInteger("-9999");

			for (int j = 0; j < numOfEle; j++) {
				result[j] = max;
			}

			for (int j = 0; j < numOfEle; j++) {
			
				boolean isIncluded = true;
				for (int k = 0; k < numOfEle; k++) {

					if (!isIncluded) {
						break;
					}

					BigInteger bigIntegerk = new BigInteger(String.valueOf(arr[k]));

					if (j == 0 && k == 0) {
						result[k] = bigIntegerk;
					} else if (j > k) {
						continue;
					} else {
						if (j != k) {
							bigIntegerk = result[k - 1].add(bigIntegerk);
						}						
						

						if (bigIntegerk.compareTo(result[k]) > 0) {
							result[k] = bigIntegerk;
						} else {
							isIncluded = false;
						}
					}				
				
				
					
					if (result[k].compareTo(max) > 0) {
						max = result[k];
					}
				}

			}

			BigInteger maxnoncon = new BigInteger("-9999");
			boolean isPosPre = false;

			for (int j = 0; j < numOfEle; j++) {
				
				if (arr[j] >= 0) {
					if (!isPosPre) {
						maxnoncon = new BigInteger("0");
						isPosPre = true;			
						}
					BigInteger bigIntegerj = new BigInteger(String.valueOf(arr[j]));
					maxnoncon = maxnoncon.add(bigIntegerj);
				} else if (!isPosPre) {
					BigInteger bigIntegerj = new BigInteger(String.valueOf(arr[j]));
					if (bigIntegerj.compareTo(maxnoncon) > 0) {
						maxnoncon = bigIntegerj;
					}
				}
			}
			System.out.println(max + " " + maxnoncon);
			
			

		}

	}
}
