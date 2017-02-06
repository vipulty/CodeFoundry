package com.codefoundry.practise.general;

public class knapsack01Problem {	

	public static void main(String[] args) {

		int[] weight = { 2,2,4,5};
		int[] value =  { 2,4,6,9}; 


		knapsack01Problem jumpGateProblem = new knapsack01Problem();
		
		int maxValue = jumpGateProblem.getMaximumValue(weight, value, 0, 8);
	
		System.out.println(maxValue);

	}

	int getMaximumValue(int[] weight, int[] value, int position, int remainingWeight) {
		
		if(weight.length == position){
			return 0;
		}
		
		if(remainingWeight < weight[position]){
			return 0;
		}
		
			
		int includeMaximumValue = getMaximumValue(weight, value, position+1, (remainingWeight-weight[position]));	
		includeMaximumValue = includeMaximumValue + value[position];
		
		int excludeMaximumValue = getMaximumValue(weight, value, position+1, remainingWeight);
		
		if(includeMaximumValue > excludeMaximumValue){
			return includeMaximumValue;
		}	
		
		return excludeMaximumValue;			
	}

}
