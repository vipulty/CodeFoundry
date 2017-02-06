package com.codefoundry.hackerrank.general;

import java.util.Scanner;

public class HackerLand {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int noOfCities = in.nextInt();
		
		int noOfRoads = in.nextInt();
		
		int noOfTestCases = in.nextInt();
		
		int[] typeOfBuildings = new int[noOfCities];
		
		in.nextLine();
		
		for(int i = 0; i < noOfCities; i++){
			typeOfBuildings[i] = in.nextInt();	
		}
		
		in.nextLine();
		
		for(int i = 0; i < noOfCities; i++){
			typeOfBuildings[i] = in.nextInt();	
		}
		
		
				
	
	}

}
