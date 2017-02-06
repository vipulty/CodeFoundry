package com.codefoundry.practise.general;

public class CoinChangingProblem {	

	public static void main(String[] args) {
		
		int[] coins =  {2,5,6,3}; 

		CoinChangingProblem jumpGateProblem = new CoinChangingProblem();
		
		int minCoins = jumpGateProblem.getMinCoins(coins, 4, 0);
	
		System.out.println(minCoins);

	}

	int getMinCoins(int[] coins , int totalRemaining, int position) {	
		
		
		if(totalRemaining == 0){
			return 0;
		}
		
		int minNoOfCoins = Integer.MAX_VALUE;
		
		for(int i=0; i < coins.length; i++){
			
			if(totalRemaining < coins[i]){
				continue;
			}
			
			totalRemaining = totalRemaining - coins[i];
			
			int result = getMinCoins(coins,totalRemaining, position + 1);							
			
			result = result + 1;
			
			if(minNoOfCoins > result) {
				minNoOfCoins = result;	
			}
			
			totalRemaining = totalRemaining + coins[i];	
		}	
		
		return minNoOfCoins;			
	}

}
