package com.codefoundry.practise.general;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 class IslandsOfOne {

	public static void main(String[] args) throws Exception {
		
		IslandsOfOne islandsOfOne = new IslandsOfOne();

		List<Integer> results = new LinkedList<Integer>();

		Scanner s = new Scanner(System.in);

		int noOfTestCase = Integer.valueOf(s.nextLine());
		

		for (int i = 0; i < noOfTestCase; i++) {
			
			String line = s.nextLine();	
			
			String[] nums = line.split(" ");

			int rows = Integer.valueOf(nums[0]);

			int columns =  Integer.valueOf(nums[1]);

			int[][] input = new int[rows][columns];

			for (int j = 0; j < rows; j++) {

			    line = s.nextLine();				

				nums = line.split(" ");

				for (int k = 0; k < columns; k++) {
					input[j][k] = Integer.valueOf(nums[k]);
				}
			}

			int count = islandsOfOne.countIslands(input, rows, columns);			
			results.add(count);
		}

		for(Integer i : results){
			System.out.println(i);
		}
		// System.out.println(count);

	}

	private  int countIslands(int M[][], int maxRow, int maxCol) {

		boolean visited[][] = new boolean[maxRow][maxCol];	

		Integer g = new Integer(0);
		for (int i = 0; i < maxRow; ++i) {
			
			for (int j = 0; j < maxCol; ++j) {

				if (M[i][j] == 1 && !visited[i][j]) {			
					
					 depthFirst(M, i, j, visited, maxRow, maxCol);
					 g++;
					// results.add(count);
				}
			}
		}	
	//	Collections.sort(results);
		//System.out.println(g);
		return g;
	}

	private static void depthFirst(int M[][], int row, int col, boolean visited[][], int maxRow, int maxCol) {
		
		//System.out.println("row = " + row + " col = " + col);
		
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][col] = true;	
		

		for (int k = 0; k < 8; ++k) {
			
			int rowCheck = row + rowNbr[k];
			int colCheck = col + colNbr[k];

			boolean val = isSafe(M, rowCheck, colCheck, visited, maxRow, maxCol);
			
			if (val) {
				
				//System.out.println("row = " + row + " col = " + col + " value = " + (M[row][col]));
				
				depthFirst(M, rowCheck,colCheck, visited, maxRow, maxCol);				
			}
		}			
		return;		
		
	}

	private static boolean isSafe(int M[][], int row, int col, boolean visited[][], int maxRow, int maxCol) {		
		
		return (row >= 0) && (row < maxRow) && (col >= 0) && (col < maxCol) && (M[row][col] == 1 && !visited[row][col]);
	}

}
