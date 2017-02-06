package com.codefoundry.practise.general;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TicTacToe {

	public static void main(String[] args) throws Exception {

		TicTacToe ticTacToe = new TicTacToe();

		List<String> results = new LinkedList<String>();

		Scanner s = new Scanner(System.in);

		int noOfTestCase = Integer.valueOf(s.nextLine());

		boolean ji = false;

		for (int i = 0; i < noOfTestCase; i++) {

			String line = s.nextLine();

			String[] nums = line.split(" ");

			int rows = Integer.valueOf(nums[0]);

			int columns = Integer.valueOf(nums[0]);

			Character[][] input = new Character[rows][columns];

			for (int j = 0; j < rows; j++) {

				line = s.nextLine();

				nums = line.split(" ");

				for (int k = 0; k < columns; k++) {
					input[j][k] = nums[k].toCharArray()[0];
				}
			}

			String result = "";

			int count = ticTacToe.countScore(input, rows, columns, 'x');

			result = new String(String.valueOf(count));

			count = ticTacToe.countScore(input, rows, columns, 'o');
			

			result = result + " " + count;

			results.add(result);
		}

		for (String i : results) {
			System.out.println(i);
		}
	}

	private int countScore(Character M[][], int maxRow, int maxCol, Character player) {

		boolean visited[][] = new boolean[maxRow][maxCol];

		AtomicInteger count = new AtomicInteger(0);

		for (int i = 0; i < maxRow; ++i) {

			for (int j = 0; j < maxCol; ++j) {

				if (M[i][j] == player && !visited[i][j]) {
					depthFirst(M, i, j, visited, maxRow, maxCol, player, count);
				}
				visited[i][j] = true;
			}
		}
		return count.get();
	}

	private static void depthFirst(Character M[][], int row, int col, boolean visited[][], int maxRow, int maxCol,
			Character player, AtomicInteger count) {

		//System.out.println("row = " + row + " col = " + col + " count = " + count.get());

		int rowNbr[] = new int[] { -1, 1, -1, 1, -1, 1, 0, 0 };
		int colNbr[] = new int[] { -1, 1, 0, 0, 1, -1, 1, -1 };

		visited[row][col] = true;

		boolean isEndPoints = false;

		for (int k = 0; k < 8; ++k) {			
		

			int rowCheck = row + rowNbr[k];
			int colCheck = col + colNbr[k];

			boolean val = isSafe(M, rowCheck, colCheck, visited, maxRow, maxCol, player);

			if (val) {
				if (isEndPoints) {
					count.getAndIncrement();
					//System.out.println("=== row = " + row + ",  ==== col = " + col);
					//System.out.println("rowCheck = " + rowCheck + " colCheck = " + colCheck);

					isEndPoints = false;

				} else if(k % 2 == 0) {
					isEndPoints = true;
					//System.out.println("rowCheck = " + rowCheck + " colCheck = " + colCheck);
				}

				if (!visited[rowCheck][colCheck]) {					
					depthFirst(M, rowCheck, colCheck, visited, maxRow, maxCol, player, count);					
				//	System.out.println("row = " + rowCheck + " col = " + colCheck + " call finished..");
					

				}
			} else if (isEndPoints) {
				isEndPoints = false;
			}
		}
		return;

	}

	private static boolean isSafe(Character M[][], int row, int col, boolean visited[][], int maxRow, int maxCol,
			Character player) {

		return (row >= 0) && (row < maxRow) && (col >= 0) && (col < maxCol) && (M[row][col] == player);
	}

}
