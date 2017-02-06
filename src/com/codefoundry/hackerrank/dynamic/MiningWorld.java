package com.codefoundry.hackerrank.dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MiningWorld {

	public MiningWorld() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		MiningWorld mw = new MiningWorld();
		
		Scanner in = new Scanner(System.in);		
		
		int numOfMines = in.nextInt();
		int numOfCollectedMines = in.nextInt();
		
		int[][] inputs = new int[numOfMines][2]; 
		
		for(int i=0 ; i < numOfMines; i++){
			inputs[i][0] = in.nextInt();
			inputs[i][1] = in.nextInt();
		}
		
		int[] inputArray = new int[numOfMines];
		
		for(int i=0 ; i < numOfMines; i++){
			inputArray[i] = i;
		}		
		

	}
	
	
	private void getAllPermutations(int[] inputArray, int maxGroup, int start, int end, List<Set<Integer>> perms){	
	
		
		if(end >  maxGroup){
			return;
		}
		
		for(int i = start; i < start + maxGroup && i < inputArray.length; i++){
			
			if((perms.size() > 0 && perms.get(start) == null) || perms.size() == 0){
				Set<Integer> set = new LinkedHashSet<Integer>();
				set.add(inputArray[i]);
				perms.add(set);
			} else {
				Set<Integer> set = perms.get(start); 
				set.add(inputArray[i]);
				perms.add(set);
			}	
			
			getAllPermutations(inputArray,maxGroup, start+1, end+1, perms);
		}
	}

}
