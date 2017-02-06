package com.codefoundry.codechef.general;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ChefAndRoundRun {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int noOfTestCase = Integer.parseInt(br.readLine());

		List<Integer> results = new LinkedList<Integer>();

		for (int i = 0; i < noOfTestCase; i++) {

			int noOfBoxes = Integer.parseInt(br.readLine());

			int result = 0;

			List<Integer> boxTasteValues = new LinkedList<Integer>();

			String in[] = br.readLine().split(" ");

			for (int j = 0; j < in.length; j++) {
				boxTasteValues.add(Integer.valueOf(in[j]));				
			}

			int indexBox = -1;

			while (true) {

				indexBox++;

				if (indexBox >= noOfBoxes) {
					break;
				}

				int source = indexBox;

				int nextIndex = source;

				Set<Integer> alreadyVisited = new HashSet<Integer>();

				while (true) {
					alreadyVisited.add(nextIndex);
					int tasteValue = 0;
					
					tasteValue = boxTasteValues.get(nextIndex);
				
					


					int unRealIndex = nextIndex + tasteValue + 1;					

					if (unRealIndex > (noOfBoxes-1)) {
						
						nextIndex = unRealIndex % noOfBoxes;					
						
					}else {
						nextIndex = unRealIndex;	
					}

					if (source == nextIndex) {
						result++;
						break;
					}

					if (!alreadyVisited.add(nextIndex)) {
						break;
					}
				}
			}

			results.add(result);

		}

		for (Integer result : results) {
			System.out.println(result);
		}

	}

}
