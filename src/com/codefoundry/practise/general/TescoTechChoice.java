package com.codefoundry.practise.general;

public class TescoTechChoice {

	

	public TescoTechChoice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		TescoTechChoice t = new TescoTechChoice();
		
		int maxBen = t.maxBenefit(3, new int[] {10,20,10}, new int[] {10,20,11}, 20, 0,0);
		System.out.println(maxBen);

	}

	int maxBenefit(int input1, int input2[], int input3[], int input4, int start, int sum) {
	
		if (start >= input1 || input4 <= 0) {
			return sum;
		}

		int resultInclude = 0;
		int excludeInclude = 0;	
		

		if (input2[start] <= input4) {
			resultInclude = maxBenefit(input1, input2, input3, (input4 - input2[start]), start + 1, sum + input3[start]);			
		}
		
		excludeInclude = maxBenefit(input1, input2, input3, input4, start + 1, sum);	
		
	
		return Math.max(excludeInclude, resultInclude);
	}
}
