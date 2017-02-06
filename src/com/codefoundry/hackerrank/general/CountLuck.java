package com.codefoundry.hackerrank.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CountLuck {

	public static void main(String[] args) throws NumberFormatException, IOException {
		CountLuck countLuck = new CountLuck();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer noOfTestCases = Integer.valueOf(br.readLine());

		List<String> results = new LinkedList<String>();

		for (int i = 0; i < noOfTestCases; i++) {

			String inputLine[] = br.readLine().split(" ");

			Integer noOfRows = Integer.valueOf(inputLine[0]);
			Integer noOfColumns = Integer.valueOf(inputLine[1]);

			Character[][] matrix = new Character[noOfRows][noOfColumns];

			AtomicInteger startRow = new AtomicInteger(0);
			AtomicInteger startColumn = new AtomicInteger(0);

			Boolean[][] visited = new Boolean[noOfRows][noOfColumns];

			for (int j = 0; j < noOfRows; j++) {

				String matrixInputLine = br.readLine();

				char[] lineChar = matrixInputLine.toCharArray();

				for (int k = 0; k < noOfColumns; k++) {

					matrix[j][k] = lineChar[k];
					visited[j][k] = false;

					if (lineChar[k] == 'M') {
						startRow.set(j);
						startColumn.set(k);
					}

				}
			}

			int expectedWave = Integer.valueOf(br.readLine());

			AtomicInteger actualWave = new AtomicInteger(0);

			actualWave = countLuck.countWave(matrix, startRow, startColumn, visited, noOfRows, noOfColumns, actualWave);
			// System.out.println(actualWave);

			if (expectedWave == actualWave.get()) {
				results.add("Impressed");
			} else {
				results.add("Oops!");
			}

		}
		for (String s : results) {
			System.out.println(s);

		}
	}

	private AtomicInteger countWave(Character[][] matrix, AtomicInteger startRow, AtomicInteger startColumn,
			Boolean visited[][], int noOfRows, int noOfColumns, AtomicInteger actualWave) {

		System.out.println(startRow + " " + startColumn + " " + actualWave.get());

		visited[startRow.get()][startColumn.get()] = true;

		if (matrix[startRow.get()][startColumn.get()] == '*') {
			return actualWave;
		}

		int rowNbr[] = new int[] { 0, 0, -1, 1 };
		int colNbr[] = new int[] { -1, 1, 0, 0 };

		int possiblePath = 0;

		for (int k = 0; k < 4; k++) {

			if (isSafe(matrix, startRow.get() + rowNbr[k], startColumn.get() + colNbr[k], visited, noOfRows,
					noOfColumns)) {
				actualWave = countWave(matrix, new AtomicInteger(startRow.get() + rowNbr[k]), new AtomicInteger(startColumn.get() + colNbr[k]), visited, noOfRows, noOfColumns, actualWave);
				possiblePath++;
			}

		}

		if (possiblePath >= 2) {
			actualWave.getAndIncrement();
		}

		// startRow.set(nextRow);
		// startColumn.set(nextColumn);

		return actualWave;

	}

	private boolean isSafe(Character M[][], Integer row, Integer col, Boolean visited[][], int noOfRows,
			int noOfColumns) {

		// int rowNbr[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
		// int colNbr[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

		return (row >= 0) && (row < noOfRows) && (col >= 0) && (col < noOfColumns)
				&& ((M[row][col] == '.' || M[row][col] == '*') && !visited[row][col]);
	}

}
