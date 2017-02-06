package com.codefoundry.hackerrank.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MinimumDistances {

	

	public static void main(String[] args) {
		    Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int A[] = new int[n];
	        for(int A_i=0; A_i < n; A_i++){
	            A[A_i] = in.nextInt();
	        }
		
		TreeMap<Integer, List<Integer>> nums = new TreeMap<Integer, List<Integer>>();	
		
		boolean isAllDifferent = true;
		

		for (int i = 0; i < A.length; i++) {
			
			int value = A[i] - '0';
			
			List<Integer> indexes = nums.get(value);
			
			if(indexes == null){
				indexes = new LinkedList<Integer>();
				indexes.add(i);
				nums.put(value, indexes);
			}else{
				indexes.add(i);
				nums.put(value, indexes);
				isAllDifferent = false;
			}	
			
		}
		
		if(isAllDifferent){
			System.out.println(-1);
		}
		
		
		int minDistance = Integer.MAX_VALUE;
		
		Set<Entry<Integer, List<Integer>>> entries = nums.entrySet();
		
		for(Entry<Integer, List<Integer>> entry : entries){
			
			if(entry.getValue().size() <= 1){
				continue;
			}
			
			int diff = entry.getValue().get(entry.getValue().size()-1) - entry.getValue().get(0);
			
			if(minDistance > diff){
				minDistance = diff;
			}			
		}
		System.out.println(minDistance);

	}

}
