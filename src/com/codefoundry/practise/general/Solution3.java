package com.codefoundry.practise.general;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		//String total = in.nextLine();
		
		String[] s = new String[6];
		
		s[0]  = "5";
		s[1]  = "10000";
		s[2]  = "01000";
		s[3]  = "00100";
		s[4]  = "00010";
		s[5]  = "00001";		


		String total = s[0];
		
		int totalInt = Integer.valueOf(total);

		int matrix[][] = new int[totalInt][totalInt];

		for (int i = 0; i < totalInt; i++) {
			String line = s[i+1];

			for (int j = 0; j < totalInt; j++) {
				char c = line.charAt(j);
				matrix[i][j] = Integer.valueOf(c);
			}
		}

		Map<Integer, Set<Integer>> mapping = new HashMap<>();

		for (int i = 0; i < totalInt; i++) {

			Set<Integer> list = new HashSet<>();

			for (int j = 0; j < totalInt; j++) {

				if (j > i && matrix[i][j] == 49) {
					list.add(j);
				}
			}
			mapping.put(i, list);
			//System.out.println(i + " " + list);
		}



		Map<Integer, Set<Integer>> cluster = new ConcurrentHashMap<>();
		
		boolean add = true;

		for (Entry<Integer, Set<Integer>> entry : mapping.entrySet()) {

			add = true;
			for (Entry<Integer, Set<Integer>> clusterentry : cluster.entrySet()) {
				
				if (clusterentry.getValue().contains(entry.getKey())) {
					
					if(entry.getValue().size() > 0){
					clusterentry.getValue().addAll(entry.getValue());
					cluster.put(clusterentry.getKey(), clusterentry.getValue());
					}
					add = false;					
				}
			}
			
			if(add){
				cluster.put(entry.getKey(), entry.getValue());	
			}
			
		}
		
		System.out.println(cluster.size());

		for (int i = 0; i < totalInt; i++) {
		//	System.out.println("");
			for (int j = 0; j < totalInt; j++) {
			//	System.out.print(" " + matrix[i][j]);
			}
		}

	}

	static int zombieCluster(String[] zombies) {
		return 0;

	}

}
