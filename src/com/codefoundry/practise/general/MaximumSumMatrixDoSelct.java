package com.codefoundry.practise.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MaximumSumMatrixDoSelct {

	public MaximumSumMatrixDoSelct() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		MaximumSumMatrixDoSelct maximumSumMatrixDoSelct = new MaximumSumMatrixDoSelct();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int noOfTestCase = Integer.parseInt(br.readLine());

		List<Map<Integer, LinkedList<Integer>>> inputs = new LinkedList<Map<Integer, LinkedList<Integer>>>();

		for (int i = 0; i < noOfTestCase; i++) {

			Map<Integer, LinkedList<Integer>> inputData = new HashMap<Integer, LinkedList<Integer>>();

			int noOfColumns = Integer.parseInt(br.readLine());

			String in[] = br.readLine().split(" ");

			LinkedList<Integer> values = new LinkedList<Integer>();

			for (int j = 0; j < in.length; j++) {
				values.add(Integer.valueOf(in[j]));
			}

			inputData.put(0, values);
			

			// Second row
			Map<Integer, LinkedList<Integer>> inputData1 = new HashMap<Integer, LinkedList<Integer>>();
			LinkedList<Integer> values1 = new LinkedList<Integer>();

			String in1[] = br.readLine().split(" ");

			for (int j = 0; j < in1.length; j++) {
				values1.add(Integer.valueOf(in1[j]));
			}

			inputData.put(1, values1);

			inputs.add(i,inputData);
		}

		for (int i = 0; i < inputs.size(); i++) {

			// Input data
			Map<Integer, LinkedList<Integer>> matrix = inputs.get(i);
			System.out.println(matrix);

			int maxRow = 2;
			int maxCol = matrix.get(0).size();

			int maxResult = 0;

			for (int k = 0; k < maxRow; k++) {

				for (int j = 0; j < maxCol; j++) {

					boolean visited[][] = new boolean[maxRow][maxCol];
					int result = maximumSumMatrixDoSelct.maximumSum(matrix, i, j, maxRow, maxCol, visited);
					System.out.println("result = " + result);
					if (maxResult < result) {
						maxResult = result;
					}
				}
			}

			System.out.println("Case #" + i + 1 + ": " + maxResult);

		}
	}

	private int maximumSum(Map<Integer, LinkedList<Integer>> M, int row, int column, int maxRow, int maxCol,
			boolean visited[][]) {

		if (isVisitedDone(visited, maxRow, maxCol)) {
			return 0;
		}		
		int maxSum = 0;

		if (!visited[row][column]) {
			
			int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
			int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };


			// if we are selecting this row/column
			int includeMaxSum = 0;
			visited[row][column] = true;

			for (int k = 0; k < 8; ++k) {
				boolean val = isSafe(row + rowNbr[k], column + colNbr[k], maxRow, maxCol);
				if (val) {
					visited[row + rowNbr[k]][column + colNbr[k]] = true;
				}
			}

			List<Integer> values = M.get(row);			
			
			for (int k = 0; k < maxRow; k++) {
				for (int j = 0; j < maxCol; j++) {
					if(!visited[k][j]) {
						int includeSum = values.get(column) + maximumSum(M, k, j, maxRow, maxCol, visited);
						
						if (includeSum > includeMaxSum) {
							includeMaxSum = includeSum;
						}
					}
				}
			}			
			

			visited[row][column] = false;
			for (int k = 0; k < 8; ++k) {
				boolean val = isSafe(row + rowNbr[k], column + colNbr[k],  maxRow, maxCol);
				if (val) {
					visited[row + rowNbr[k]][column + colNbr[k]] = false;
				}
			}
			

			// if we are not selecting this row/column
			visited[row][column] = true;
			int excludeMaxSum = 0;
			for (int k = 0; k < 8; ++k) {
				boolean val = isSafe(row + rowNbr[k], column + colNbr[k],  maxRow, maxCol);
				if (val) {
					int excludeSum = maximumSum(M, row + rowNbr[k], column + colNbr[k], maxRow, maxCol, visited);
					if (excludeSum > excludeMaxSum) {
						excludeMaxSum = excludeSum;
					}
				}
			}
			visited[row][column] = false;

			maxSum = Math.max(includeMaxSum, excludeMaxSum);
		}

		return maxSum;
	}

	private static boolean isSafe(int row, int col,int maxRow, int maxCol) {
		return (row >= 0) && (row < maxRow) && (col >= 0) && (col < maxCol);
	}

	private static boolean isVisitedDone(boolean visited[][], int maxRow, int maxCol) {

		for (int k = 0; k < maxRow; k++) {
			for (int j = 0; j < maxCol; j++) {
				if (!visited[k][j]) {
					return false;
				}
			}
		}

		return true;

	}

}
