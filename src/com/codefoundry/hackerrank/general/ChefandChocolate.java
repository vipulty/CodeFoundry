package com.codefoundry.hackerrank.general;

import java.util.Scanner;

 class ChefandChocolate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCase = in.nextInt();

		int[][] inputData = new int[noOfTestCase][2];

		for (int i = 0; i < noOfTestCase; i++) {
			inputData[i][0] = in.nextInt();
			inputData[i][1] = in.nextInt();
		}

		for (int i = 0; i < noOfTestCase; i++) {

			if (inputData[i][0] % 2 == 0) {

				if (inputData[i][1] % 2 != 0) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			} else if (inputData[i][0] % 2 != 0) {
				
				if (inputData[i][1] % 2 == 0) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}

	}

}
