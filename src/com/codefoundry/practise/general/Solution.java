package com.codefoundry.practise.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
		int rows = s.nextInt();

		int columns = s.nextInt();

		int[][] input = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			String line = s.nextLine();

			if (line.equals("")) {
				i--;
				continue;
			}
			String[] nums = line.split(" ");
			for (int j = 0; j < columns; j++) {
				input[i][j] = Integer.valueOf(nums[j]);
			}
		}

		int count = countIslands(input, rows, columns);
		// System.out.println(count);

	}

	private static int countIslands(int M[][], int maxRow, int maxCol) {

		boolean visited[][] = new boolean[maxRow][maxCol];

		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < maxRow; ++i) {
			for (int j = 0; j < maxCol; ++j) {

				if (M[i][j] == 1 && !visited[i][j]) {
					Integer count = new Integer(1);
					count = depthFirst(M, i, j, visited, maxRow, maxCol, count);
					results.add(count);
					System.out.println(count);
				}
			}
		}
		Collections.sort(results);
		return results.get(results.size() - 1);
	}

	private static Integer depthFirst(int M[][], int row, int col, boolean visited[][], int maxRow, int maxCol,
			Integer count) {
		visited[row][col] = true;
		System.out.println(" row = " + row + " , col = " + col);
		int origRow = row;
		int origCol = col;

		int rows[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int cols[] = { -1, 0, 1, 1, 1, 0, 1, -1 };		

		for (int i = 0; i < 8; i++) {

			row = origRow + rows[i];
			col = origCol + cols[i];
			
			//System.out.println(" row = " + row + " , col = " + col + " , run = " + run);
			
			boolean isRun = isSafe(row, col, visited, maxRow, maxCol);

			if (isRun && M[row][col] == 1) {	
				visited[row][col] = true;
				count = depthFirst(M, row, col, visited, maxRow, maxCol, count);
				count++;				
				
			} else if (isRun && M[row][col] == 0) {
				visited[row][col] = true;
			}
		}
		return count;
	}

	private static boolean isSafe(int row, int col, boolean visited[][], int maxRow, int maxCol) {

		if (row < 0 || col < 0 || (row > (maxRow - 1) || (col > (maxCol - 1)))) {
			return false;
		}
		if (visited[row][col]) {
			return false;
		}
		return true;
	}
}
