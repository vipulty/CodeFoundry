package com.codefoundry.practise.general;

public class TescoMatrixPath {

	

	public TescoMatrixPath() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		TescoMatrixPath t = new TescoMatrixPath();
		
		String input1 = "4";
		int matSize = Integer.valueOf(input1);
		int[][] input = new int[matSize][matSize];
		
		String input2 = "(1,7,5,2),(5,12,3,6),(100,9,23,16),(16,4,5,9)";
		
		input2 = input2.replace('(',' ');
		input2 = input2.replace(')',' ');
		input2 = input2.trim();
		System.out.println(input2);
		
		String[] numbers = input2.split(",");
		
		for (int i = 0; i < matSize; ++i) {
		    for (int j = 0; j < matSize; ++j) {
		    	input[i][j] = Integer.valueOf(numbers[i * matSize + j].trim()); 
		    }		  
		}	
		
		int maxBen = t.maxCost(input, matSize-1, matSize-1);	
		System.out.println(maxBen);
	}
	
	int maxCost(int input[][], int m, int n)
	{
	   if (n < 0 || m < 0)
	      return Integer.MIN_VALUE;
	   else if (m == 0 && n == 0)
	      return input[m][n];
	   else
	      return input[m][n] + Math.max(maxCost(input, m-1, n), 
	    		  maxCost(input, m, n-1) );
	}

	
}
