package com.codefoundry.practise.general;

public class JumpGateProblem {
	

	public static void main(String[] args) {

		int[] input = { 2,4,6,9 };

		JumpGateProblem jumpGateProblem = new JumpGateProblem();
		
		int minJumpCost = jumpGateProblem.getMinimumCost(input, 0, 0);
		int minOpenCost = jumpGateProblem.getMinimumCost(input, 0, 1);
		
		if(minJumpCost > minOpenCost){
			System.out.println(minOpenCost);
		}else
		
		System.out.println(minJumpCost);

	}

	int getMinimumCost(int[] input, int position, int state) {
		
		if(input.length == position){
			return 0;
		}

		if (state == 0) {
			
			int openGateCost = getMinimumCost(input, position + 1, 1);
			int jumpGateCost = getMinimumCost(input, position + 1, 0);			
	
			
			if(openGateCost > jumpGateCost){
				return  jumpGateCost + input[position];
			}else {
				return  openGateCost + input[position];
			}			
		} 
		
		int openGateCost = getMinimumCost(input, position + 1, 0);
		return openGateCost;
	}

}
