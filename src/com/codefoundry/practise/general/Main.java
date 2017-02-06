/**
 * 
 */
package com.codefoundry.practise.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String userInput = br.readLine();
		String inputSplit[] = userInput.split(" ");

		BigInteger noOfElements = new BigInteger(inputSplit[0]);
		BigInteger maxDistance = new BigInteger(inputSplit[1]);

		
		String elements = br.readLine();
		String elementsArrayInput[] = elements.split(" ");

		BigInteger[] elementsArray = new BigInteger[noOfElements.intValue()];
		BigInteger[] resultArray = new BigInteger[noOfElements.intValue()];

		Arrays.fill(resultArray, new BigInteger("-1"));

		int k = 0;
		for (String s : elementsArrayInput) {
			elementsArray[k] = new BigInteger(s);
			k++;
		}

		for (int i = 0; i < noOfElements.intValue(); i++) {

			BigInteger elementIth = elementsArray[i];

			for (int j = i; j < noOfElements.intValue(); j++) {

				BigInteger elementJth = elementsArray[j];

				BigInteger diff = elementJth.subtract(elementIth);

				if (j == 0) {
					resultArray[j] = elementJth;
				}			
				if (diff.compareTo(new BigInteger(inputSplit[1])) <= 0) {
					BigInteger value = resultArray[i].multiply(elementJth);
					if (resultArray[j].signum() == -1) {
						resultArray[j] = value;
					}else if(resultArray[j].compareTo(value) > 0) {
						resultArray[j] = value;
					}
				}			
			}			
		}
		System.out.print(resultArray[noOfElements.intValue() - 1].mod(BigInteger.valueOf(1000000007)).intValue());
	}
}
