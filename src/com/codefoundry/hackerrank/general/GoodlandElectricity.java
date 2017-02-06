package com.codefoundry.hackerrank.general;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;



public class GoodlandElectricity {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int inputSize = in.nextInt();
		int distance = in.nextInt();
		in.nextLine();
		String input = in.nextLine();

		String inputArray[] = input.split(" ");
		int inputLength = inputArray.length;
		
		Map<Integer, GoodlandElectricityKey> map = new LinkedHashMap<>();

		int index = 1;

		for (String s : inputArray) {

			Integer value = Integer.valueOf(s);
			
			if(value == 0){
				index++;
				continue;				
			}

			Set<Integer> connectedValues = new HashSet<>();

			int startconnectedValue = index - (distance - 1);

			if (startconnectedValue < 1) {
				startconnectedValue = 1;
			}

			int endconnectedValue = index + (distance - 1);

			if (endconnectedValue > inputLength) {
				endconnectedValue = inputLength;
			}

			for (int i = startconnectedValue; i <= endconnectedValue; i++) {
				connectedValues.add(i);
			}

			GoodlandElectricityKey key = new GoodlandElectricityKey(connectedValues, value);

			map.put(index, key);
			index++;
		}
		
	

		Map<Integer, Set<Integer>> values = new HashMap<>();
		Set<Integer> distincts = new HashSet<>();

		Integer prev = 0;

		for(Entry<Integer, GoodlandElectricityKey> entry : map.entrySet())
		{
			
		
			Set<Integer> lastValue = values.get(prev);
			
			if(lastValue != null){			 
				if(entry.getValue().connectedValues.containsAll(lastValue)){					
					
					distincts.removeAll(lastValue);
					values.remove(prev);					
					
					if(values.size() > 0){
						entry.getValue().connectedValues.removeAll(distincts);
					}					
					prev = entry.getKey();
					distincts.addAll(entry.getValue().connectedValues);
					values.put(entry.getKey(), entry.getValue().connectedValues);	
			
				}else{
			
					entry.getValue().connectedValues.removeAll(distincts);
			
					prev = entry.getKey();
					values.put(entry.getKey(), entry.getValue().connectedValues);	
					distincts.addAll(entry.getValue().connectedValues);
				}
			}else{
			 values.put(entry.getKey(), entry.getValue().connectedValues);
			 distincts.addAll(entry.getValue().connectedValues);
			 prev = entry.getKey();
			}
	
		}
		
		if(distincts.size() == inputArray.length){
			System.out.println(values.size());
			return;
		}

		System.out.println("-1");
	}
}

class GoodlandElectricityKey {

	Set<Integer> connectedValues;
	Integer hasTower;
	
	

	public GoodlandElectricityKey(Set<Integer> connectedValues, Integer hasTower) {
		super();
		this.connectedValues = connectedValues;
		this.hasTower = hasTower;
	}

	@Override
	public String toString() {
		return "[connectedValues=" + connectedValues + ", hasTower=" + hasTower + "]";
	}

}
