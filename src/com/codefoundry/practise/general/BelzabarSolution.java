package com.codefoundry.practise.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BelzabarSolution {

	public static void main(String args[]) {
		final BelzabarSolution belzabarSolution = new BelzabarSolution();

		final int input = 2;

		final int matrixSize = input + (input - 1);

		final List<List<Integer>> results = new ArrayList<>(matrixSize);

		for (int i = 0; i < matrixSize; i++) {
			
			final List<Integer> result = new ArrayList<>(matrixSize);
			belzabarSolution.printMatrix(input, result, i, matrixSize);
			results.add(result);
		}
		
		System.out.println(results);
	}

	private List<Integer> printMatrix(int input, List<Integer> result, int start, int matrixSize) {

		if (input < 1) {
			return result;
		}

		if (start >= (matrixSize-1)) {
			result.add(start, input);
			return result;
		}

		for (int i = start; i < result.size(); i++) {
			printMatrix(input-1, result, start+1, matrixSize);			
		}
		return result;
	}

}
