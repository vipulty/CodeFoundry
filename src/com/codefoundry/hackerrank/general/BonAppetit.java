package com.codefoundry.hackerrank.general;

import java.util.Scanner;

public class BonAppetit {

	public BonAppetit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numOfFood = scanner.nextInt();
		
		int itemLeft = scanner.nextInt();
		
		//int[] costs = new int[numOfFood];
		
		int correctCost = 0;
		
		for(int i = 0; i < numOfFood; i++){
			//costs[i] = scanner.nextInt();
			
			int cost = scanner.nextInt();
			
			if(i != itemLeft){
				correctCost = correctCost + cost;
			}
		}
		
		correctCost = correctCost / 2;
		
		int costOfCheck = scanner.nextInt();
		
		if(costOfCheck == correctCost){
			System.out.println("Bon Appetit");
		}else {
			if(costOfCheck > correctCost){
				System.out.println(costOfCheck - correctCost);
			}else{
				System.out.println(correctCost - costOfCheck);
			}
		}
	}

}
