package com.codefoundry.practise.general;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 08/01/2014
 * @author Tushar Roy
 *
 *         Given a total and coins of certain denominations find number of ways
 *         total can be formed from coins assuming infinity supply of coins
 *
 *         References:
 *         http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
public class CoinChanging {

	class Result {
		int totalWays = 0;
	}

	/**
	 * This method actually prints all the combination. It takes exponential
	 * time.
	 */
	public void printCoinChangingSolution(int total, int coins[], int count[]) {
		List<Integer> result = new ArrayList<>();
		printActualSolution(result, total, coins, 0, count);

		Result result1 = new Result();
		totalNumOfWays(total, coins, 0, count, result1);
		System.out.println("totalWays = " + result1.totalWays);

		int totalWays = totalNumOfWays(total, coins, 0, count);
		System.out.println("totalWays = " + totalWays);

		totalWays = totalNumOfWays(total, coins, count, 0);
		System.out.println("totalWays = " + totalWays);
	}

	private void printActualSolution(List<Integer> result, int total, int coins[], int pos, int count[]) {
		if (total == 0) {
			for (int r : result) {
				System.out.print(r + " ");
			}
			System.out.print("\n");
		}
		for (int i = pos; i < coins.length; i++) {
			if (total >= coins[i] && count[i] > 0) {
				result.add(coins[i]);
				count[i]--;
				printActualSolution(result, total - coins[i], coins, i, count);
				result.remove(result.size() - 1);
				count[i]++;
			}
		}
	}

	private void totalNumOfWays(int total, int coins[], int pos, int count[], Result result1) {
		if (total == 0) {
			result1.totalWays = result1.totalWays + 1;
			return;
		}

		for (int i = pos; i < coins.length; i++) {

			if (total >= coins[i] && count[i] > 0) {
				count[i]--;
				totalNumOfWays(total - coins[i], coins, i, count, result1);
				count[i]++;

			}
		}
	}

	private int totalNumOfWays(int total, int coins[], int pos, int count[]) {
		if (total == 0) {
			return 1;
		}

		int NumOfWays = 0;

		for (int i = pos; i < coins.length; i++) {
			if (coins[i] <= total && count[i] > 0) {

				count[i]--;
				int subNumWays = totalNumOfWays(total - coins[i], coins, i, count);

				count[i]++;

				NumOfWays = NumOfWays + subNumWays;
			}
		}
		return NumOfWays;
	}
	
	
	private int totalNumOfWays(int total, int coins[], int count[], int index) {
		
		if(total == 0){
			return 1;
		}
		
		if(index == coins.length || total < 0){
			return 0;
		}

		int NumOfWays = 0;

	    if (coins[index] <= total && count[index] > 0) {
	    	
	    	count[index]--;
			int include = totalNumOfWays(total - coins[index], coins, index, count);
			count[index]++;
			
			int exclude = totalNumOfWays(total, coins, index + 1, count);
			
			NumOfWays = include + exclude;
		}

		return NumOfWays;
	}

	public static void main(String args[]) {
		CoinChanging cc = new CoinChanging();
		// int total = 15;
		// int coins[] = {3,4,6,7,9};

		int total = 5;
		int coins[] = { 1, 2, 5, 10 };
		int count[] = { 10, 10, 10, 10 };

		cc.printCoinChangingSolution(total, coins, count);
	}
}
