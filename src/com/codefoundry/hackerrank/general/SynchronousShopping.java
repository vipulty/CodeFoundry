package com.codefoundry.hackerrank.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SynchronousShopping {

	class Value implements Comparable<Value> {

		int destinedStore;
		int distance;
		boolean bigCatVisited;
		boolean smallCatVisited;

		@Override
		public String toString() {
			return destinedStore + " " + distance;
		}

		public Value(int destinedStore, int distance) {
			super();
			this.destinedStore = destinedStore;
			this.distance = distance;
			this.bigCatVisited = false;
			this.smallCatVisited = false;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		@Override
		public int compareTo(Value o) {
			return this.distance - o.distance;
		}
	}

	public static void main(String[] args) {

		SynchronousShopping solution = new SynchronousShopping();

		Scanner in = new Scanner(System.in);
		int numOfStores = in.nextInt();

		int numOfRoads = in.nextInt();

		int numOfFishTypes = in.nextInt();

		in.nextLine();

		Map<Integer, List<Integer>> allStoreFishTypes = new HashMap<Integer, List<Integer>>();

		for (int i = 1; i <= numOfStores; i++) {

			int numOfFishTypeInStore = in.nextInt();

			List<Integer> storeFishTypes = new ArrayList<Integer>();

			for (int j = 1; j <= numOfFishTypeInStore; j++) {
				storeFishTypes.add(in.nextInt());
			}
			allStoreFishTypes.put(i, storeFishTypes);
			in.nextLine();
		}

		Map<Integer, List<Value>> roadsDistance = new HashMap<Integer, List<Value>>();

		for (int i = 1; i <= numOfRoads; i++) {

			int sourceStore = in.nextInt();

			Value value = solution.new Value(in.nextInt(), in.nextInt());

			if (roadsDistance.get(sourceStore) == null) {
				
				List<Value> destinedDistance = new ArrayList<Value>();
				destinedDistance.add(value);
				roadsDistance.put(sourceStore, destinedDistance);
				
				int reversedSourceStore = value.destinedStore;
				
				if (roadsDistance.get(reversedSourceStore) == null) {
					value = solution.new Value(sourceStore, value.distance);
					destinedDistance = new ArrayList<Value>();
					destinedDistance.add(value);					
					roadsDistance.put(reversedSourceStore, destinedDistance);
				}else{
					destinedDistance = roadsDistance.get(reversedSourceStore);
					value = solution.new Value(sourceStore, value.distance);
					destinedDistance.add(value);
					Collections.sort(destinedDistance);
					roadsDistance.put(reversedSourceStore, destinedDistance);	
				}
				
				
			} else {
				List<Value> destinedDistance = roadsDistance.get(sourceStore);
				destinedDistance.add(value);
				Collections.sort(destinedDistance);
				roadsDistance.put(sourceStore, destinedDistance);
				
				int reversedSourceStore = value.destinedStore;
				if (roadsDistance.get(reversedSourceStore) == null) {
					value = solution.new Value(sourceStore, value.distance);
					destinedDistance = new ArrayList<Value>();
					destinedDistance.add(value);					
					roadsDistance.put(reversedSourceStore, destinedDistance);
				}else{
					destinedDistance = roadsDistance.get(reversedSourceStore);
					value = solution.new Value(sourceStore, value.distance);
					destinedDistance.add(value);
					Collections.sort(destinedDistance);
					roadsDistance.put(reversedSourceStore, destinedDistance);	
				}				
				
			}			
		}

		System.out.println(allStoreFishTypes.entrySet());
		System.out.println(roadsDistance.entrySet());

		Integer bigCatCurrentStore = 1;
		Integer smallCatCurrentStore = 1;

		Integer totalDistanceBigCat = 0;
		Integer totalDistanceSmallCat = 0;

		Set<Integer> fishTypes = new HashSet<>();

		while (bigCatCurrentStore < numOfStores || smallCatCurrentStore < numOfStores) {

			List<Integer> currentStoreFishTypes = allStoreFishTypes.get(bigCatCurrentStore);
			
			
			if (fishTypes.size() == numOfFishTypes) {	
				
				System.out.println("bigCat path to target from = " + bigCatCurrentStore);
				
				int totalDistance = solution.getShortestPathToTarget(roadsDistance,bigCatCurrentStore, Integer.MAX_VALUE, numOfStores,0,true,new HashMap<Integer,Integer>()); 
			    System.out.println("bigCat totalDistance = " + totalDistance);
				
				totalDistanceBigCat = totalDistanceBigCat + totalDistance;
				System.out.println("bigCat totalDistanceBigCat = " + totalDistanceBigCat);
				bigCatCurrentStore = numOfStores;
			}
			
			
			if(bigCatCurrentStore < numOfStores){
				fishTypes.addAll(currentStoreFishTypes);

				List<Value> destinations = roadsDistance.get(bigCatCurrentStore);

				if (destinations != null) {

					for (int i = 0; i < destinations.size(); i++) {

						if (!destinations.get(i).bigCatVisited) {
							
							System.out.println("Big Cat Visiting -> " + destinations.get(i).destinedStore);

							currentStoreFishTypes = allStoreFishTypes.get(destinations.get(i).destinedStore);
							currentStoreFishTypes.removeAll(fishTypes);
							
							
							if (currentStoreFishTypes.size() > 0) {
								bigCatCurrentStore = destinations.get(i).destinedStore;
								totalDistanceBigCat = totalDistanceBigCat + destinations.get(i).distance;
								destinations.get(i).bigCatVisited = true;
								fishTypes.addAll(currentStoreFishTypes);
								break;
							}

						}
					}
				}
			}			
			
			if (fishTypes.size() == numOfFishTypes) {	
				
				System.out.println("smallcat path to target from = " + smallCatCurrentStore);
				
				int totalDistance = solution.getShortestPathToTarget(roadsDistance,smallCatCurrentStore, Integer.MAX_VALUE, numOfStores,0,false, new HashMap<Integer,Integer>());
				
			    System.out.println("smallcat totalDistance = " + totalDistance);
				
				totalDistanceSmallCat = totalDistanceSmallCat + totalDistance;
				System.out.println("smallcat totalDistanceSmallCat = " + totalDistanceSmallCat);
				smallCatCurrentStore = numOfStores;
				continue;
			}
			
			if(smallCatCurrentStore < numOfStores){ 
				currentStoreFishTypes = allStoreFishTypes.get(smallCatCurrentStore);
				fishTypes.addAll(currentStoreFishTypes);

				List<Value> destinations = roadsDistance.get(smallCatCurrentStore);

				if (destinations != null) {

					for (int i = 0; i < destinations.size(); i++) {

						if (!destinations.get(i).smallCatVisited) {
							
							System.out.println("Small Cat Visiting -> " + destinations.get(i).destinedStore);
							currentStoreFishTypes = allStoreFishTypes.get(destinations.get(i).destinedStore);
							currentStoreFishTypes.removeAll(fishTypes);
							
							
							if (currentStoreFishTypes.size() > 0) {
								destinations.get(i).smallCatVisited = true;
								smallCatCurrentStore = destinations.get(i).destinedStore;
								totalDistanceSmallCat = totalDistanceSmallCat + destinations.get(i).distance;
								
								fishTypes.addAll(currentStoreFishTypes);
								break;
							}
						}
					}
				}
			}


		}

		if (totalDistanceBigCat > totalDistanceSmallCat) {
			System.out.println(totalDistanceBigCat);
		} else {
			System.out.println(totalDistanceSmallCat);
		}
	}

	private Integer getShortestPathToTarget(Map<Integer, List<Value>> roadsDistance, Integer currentStore, Integer minDistance, Integer target, Integer currentPathDistance, boolean isBigCat,
			Map<Integer,Integer> visitedStores) {

	
	   System.out.println(currentStore + " " + minDistance + " " + currentPathDistance);
	   
	   if(visitedStores.get(currentStore) != null){
		   
		   if(visitedStores.get(currentStore) < currentPathDistance){
		      currentPathDistance =   visitedStores.get(currentStore);
		   }
	   }else {
		   visitedStores.put(currentStore, currentPathDistance);
	   }

		
		if(currentStore == target){
			
			//System.out.println("Base condition");
			if(currentPathDistance < minDistance){
				minDistance = currentPathDistance;			
			}
			return minDistance;			
		}
		
		List<Value> destinations = roadsDistance.get(currentStore);
		
		if(destinations == null){
			return minDistance;
		}
		
		for(int k=0; k < destinations.size(); k++){
			
			if(isBigCat){				
				
				if(destinations.get(k).bigCatVisited){
					System.out.println("destination = " + destinations.get(k) + " already visited");					
				
					continue;
				}
				
				destinations.get(k).bigCatVisited = true;
			}else {
				if(destinations.get(k).smallCatVisited){
					System.out.println("destination = " + destinations.get(k) + " already visited");					
				
					continue;
				}
			   destinations.get(k).smallCatVisited = true;
			}
			
			if(currentPathDistance + destinations.get(k).distance > minDistance){
				//System.out.println("minDistance is small");
				continue;
			}
			roadsDistance.put(currentStore, destinations);
			
			Integer shortestDistance = getShortestPathToTarget(roadsDistance, destinations.get(k).destinedStore, minDistance, target, currentPathDistance + destinations.get(k).distance, isBigCat,visitedStores);
			minDistance = shortestDistance; 
		}
		
		return minDistance;

	}

}
