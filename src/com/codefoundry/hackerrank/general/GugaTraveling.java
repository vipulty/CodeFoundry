package com.codefoundry.hackerrank.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class GugaTraveling {

	class Value implements Comparable<Value> {

		Integer targetDestination;
		Integer weight;
		Boolean special = false;		

		@Override
		public String toString() {
			return targetDestination + " "  + weight;
		}

		public Value(int targetDestination, int weight) {
			super();
			this.targetDestination = targetDestination;
			this.weight = weight;
		}

		public Value(int targetDestination, int weight, Boolean special) {
			super();
			this.targetDestination = targetDestination;
			this.weight = weight;
			this.special = special;
		}

		@Override
		public int compareTo(Value o1) {
			return weight.compareTo(o1.weight);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		GugaTraveling matrixInversion = new GugaTraveling();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String firstInputLine[] = br.readLine().split(" ");

		int noOfCitites = Integer.valueOf(firstInputLine[0]);
		int noOfNormalWay = Integer.valueOf(firstInputLine[1]);
		int noOfSpecialWay = Integer.valueOf(firstInputLine[2]);

		Map<Integer, List<Value>> paths = new HashMap<Integer, List<Value>>();
		
		Map<Integer, List<Value>> specialPaths = new HashMap<Integer, List<Value>>();	
		

		matrixInversion.readInput(noOfNormalWay, paths, matrixInversion, br, false);
		matrixInversion.readInput(noOfSpecialWay, specialPaths, matrixInversion, br, true);
		
		//System.out.println(specialPaths);
		
		for(Entry<Integer, List<Value>> s : specialPaths.entrySet()){
			
			if(paths.get(s.getKey()) == null){
				paths.put(s.getKey(), s.getValue());
			}else {
				List<Value> v = paths.get(s.getKey());
				v.addAll(s.getValue());				
				paths.put(s.getKey(), v);
			}
		}

		Map<Integer, Value> binaryMinHeap = new HashMap<Integer, Value>();
		binaryMinHeap.put(1, matrixInversion.new Value(1, 0));

		for (int i = 2; i <= noOfCitites; i++) {
			binaryMinHeap.put(i, matrixInversion.new Value(i, Integer.MAX_VALUE));
		}

		int minCount = 1;
		
		Map<Integer, Value> resultMinDistance = new HashMap<Integer, Value>();

		while (binaryMinHeap.size() > 0) {

			Value value = binaryMinHeap.get(minCount);

			binaryMinHeap.remove(minCount);

			resultMinDistance.put(minCount, matrixInversion.new Value(minCount,value.weight));

			List<Value> values = paths.get(minCount);
			
			if(values == null || values.size() <= 0){
				Collection<Value> binaryMinHeapValues = binaryMinHeap.values();

				if (binaryMinHeapValues.size() > 0) {
					List<Value> binaryMinHeapValuesList = new ArrayList<Value>(binaryMinHeapValues);
					Collections.sort(binaryMinHeapValuesList);

					minCount = binaryMinHeapValuesList.get(0).targetDestination;
				}
				continue;
			}

			for (Value pathValue : values) {

				Value existingWeight = binaryMinHeap.get(pathValue.targetDestination);

				if (existingWeight != null) {

					int newDistance = value.weight + pathValue.weight;

					if (existingWeight.weight > newDistance) {
						binaryMinHeap.put(pathValue.targetDestination,
								matrixInversion.new Value(pathValue.targetDestination, newDistance));
					}
				}
			}

			Collection<Value> binaryMinHeapValues = binaryMinHeap.values();

			if (binaryMinHeapValues.size() > 0) {
				List<Value> binaryMinHeapValuesList = new ArrayList<Value>(binaryMinHeapValues);
				Collections.sort(binaryMinHeapValuesList);

				minCount = binaryMinHeapValuesList.get(0).targetDestination;
			}

		}
		//System.out.println(specialPaths);
		Collection<Value> resultMinDistanceValues = resultMinDistance.values();
		
		List<Value> resultMinDistanceList = new ArrayList<Value>(resultMinDistanceValues);
		Collections.sort(resultMinDistanceList);
		
		//System.out.println(resultMinDistanceList);
		
		int totalCost = 0;
		
		int visitedCount = 0;
		
		int startIndex = 0;	
		
		int sourceSpecialPath = 0;
		
		for(Value v : resultMinDistanceList){
			
			List<Value> v1 = specialPaths.get(v.targetDestination);
			
			if(v.weight > 0 && specialPaths.get(v.targetDestination) != null) {	
				
				sourceSpecialPath = v.targetDestination;
				
				if(v1.size() == 1) {
					totalCost = totalCost + v.weight;
					break;
				}
			}
		}
		
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(sourceSpecialPath);
		
		Map<Integer, Integer> shortestDistanceFormSource = new HashMap<Integer, Integer>();
		
		for(Value v : resultMinDistanceList) {
			
			shortestDistanceFormSource.put(v.targetDestination, v.weight);
		}
		
		while(visitedCount < noOfSpecialWay) {		
			
			List<Value> v1 = specialPaths.get(sourceSpecialPath);	
			boolean isPath = false;
			
			for(Value v0 : v1) {
				
				if(!visited.contains(v0.targetDestination)){
					
					visited.add(v0.targetDestination);
					totalCost = totalCost + v0.weight;
					
					sourceSpecialPath = v0.targetDestination;
					visitedCount++;
					isPath = true;
					break;
				}				
			}
			
			if(!isPath){				
				totalCost = totalCost + shortestDistanceFormSource.get(sourceSpecialPath);
				sourceSpecialPath = 1;
			}
		}
		
		System.out.println(totalCost);
	}

	void readInput(int loopEnd, Map<Integer, List<Value>> paths, GugaTraveling matrixInversion, BufferedReader br,
			boolean isSpecial) throws IOException {
		for (int i = 0; i < loopEnd; i++) {
			String pathInfo[] = br.readLine().split(" ");

			int source = Integer.valueOf(pathInfo[0]);
			int target = Integer.valueOf(pathInfo[1]);
			int weight = Integer.valueOf(pathInfo[2]);

			Value sourceValue = matrixInversion.new Value(source, weight, isSpecial);

			Value targetValue = matrixInversion.new Value(target, weight, isSpecial);

			if (paths.get(source) == null) {

				List<Value> values = new ArrayList<Value>();
				values.add(targetValue);

				paths.put(source, values);		
				
			} else {
				List<Value> values = paths.get(source);
				values.add(targetValue);

				Collections.sort(values);
				paths.put(source, values);
			
			}
			if (paths.get(target) == null) {

				List<Value> values = new ArrayList<Value>();
				values.add(sourceValue);

				paths.put(target, values);
			} else {
				List<Value> values = paths.get(target);
				values.add(sourceValue);

				Collections.sort(values);
				paths.put(target, values);
			}

		}
	}

}
