package com.codefoundry.geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllCombinationPerm {

	public AllCombinationPerm() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] input = {1, 2, 3};
		int[] count = {1, 1, 1};
		
		AllCombinationPerm allCombinationPerm = new AllCombinationPerm();
		
		int[] result = new int[input.length];
		
		//allCombinationPerm.printAllPerm(input, count, result, 0, 0);
		List<Set<Integer>> allSets = new ArrayList<>();
		allCombinationPerm.generateCombination(input, 0, 0, allSets, result);
		
		for(Set<Integer> s : allSets){
        	System.out.println("");
        	for(Integer i : s){
        		System.out.print(i + " ");
        	}
        }
	}
	
	
	void printAllPerm(int[] input , int[] count, int[] result, int level, int pos){
		
		if(level == input.length){
			System.out.println("");
			for(int r : result){
				System.out.print(r);
			}
			return;
		}
		
		for(int i=0; i < input.length; i++){
			
			if(count[i] == 0){
				continue;
			}
			result[level] = input[i];
			count[i]--;
			
			printAllPerm(input,count, result,level + 1, pos + 1);
			count[i]++;
		}
		
	}
	
	
	 private void generateCombination(int input[], int start, int pos, List<Set<Integer>> allSets, int result[]) {    	
	    	if(pos == input.length) {
	            return;
	        }
	        Set<Integer> set = createSet(result, pos);
	        allSets.add(set);
	        for(int i=start; i < input.length; i++) {
	            result[pos] = input[i];
	            generateCombination(input, i+1, pos+1, allSets, result);
	        }
	    }
   
   private static Set<Integer> createSet(int input[], int pos) {
       if(pos == 0) {
           return new HashSet<>();
       }
       Set<Integer> set = new HashSet<>();
       for(int i = 0; i < pos; i++) {
           set.add(input[i]);
       }
       return set;
   }

}
