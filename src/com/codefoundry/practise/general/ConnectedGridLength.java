package com.codefoundry.practise.general;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectedGridLength {

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
		System.out.println(count);
		

	}

	private static int countIslands(int M[][], int maxRow, int maxCol) {

		boolean visited[][] = new boolean[maxRow][maxCol];

		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < maxRow; ++i)
			for (int j = 0; j < maxCol; ++j)

				if (M[i][j] == 1 && !visited[i][j]) {
					Integer g = new Integer(0);
					g = depthFirst(M, i, j, visited, maxRow, maxCol, g);					
					g = g + 1;
					results.add(g.intValue());					
				}
        Collections.sort(results);
		return results.get(results.size()-1);
	}

	private static Integer depthFirst(int M[][], int row, int col, boolean visited[][], int maxRow, int maxCol, Integer g) {
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;		

		for (int k = 0; k < 8; ++k) {
			
			boolean val = isSafe(M, row + rowNbr[k], col + colNbr[k], visited, maxRow, maxCol);
			
			if (val) {
				depthFirst(M, row + rowNbr[k], col + colNbr[k], visited, maxRow, maxCol, g);	
				g = g + 1;
				return g;				
			}			
		}	
		return g;
	}

	private static boolean isSafe(int M[][], int row, int col, boolean visited[][], int maxRow, int maxCol) {

		return (row >= 0) && (row < maxRow) && (col >= 0) && (col < maxCol) && (M[row][col] == 1 && !visited[row][col]);
	}

}
