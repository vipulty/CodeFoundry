/**
 * 
 */
package com.codefoundry.practise.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlterSubArrPre {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(isr);
		int no_of_tests = Integer.parseInt(bf.readLine());

		while (no_of_tests > 0) {
			int n = Integer.parseInt(bf.readLine());
			int  data[] = new int [n];

			String stringdataArray[] = bf.readLine().split(" ");
			int i = 0;
			for (String s : stringdataArray) {
				data[i++] = Integer.parseInt(s);
			}
			int[] result = new int[n];
			
			for (i = 0; i < n; i++) {
				result[i] = 1;
			}
			
			for (i = n - 1; i > 0; i--) {

				if (Math.signum(data[i]) != Math.signum(data[i - 1])) {
					result[i - 1] = result[i] + 1;
				}
			}
			
			for (int k = 0; k < result.length; k++) {
				System.out.print(result[k] + " ");
			}

			System.out.println();

			no_of_tests--;
		}
	}
}
