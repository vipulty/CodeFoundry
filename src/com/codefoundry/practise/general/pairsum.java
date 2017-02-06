package com.codefoundry.practise.general;

import java.util.ArrayList;

public class pairsum {
	
	private static ArrayList<SumIndex> numbers = new ArrayList<SumIndex>();

	public pairsum() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) {
		
		ArrayList<SumIndex> numberCheckList = new ArrayList<SumIndex>();
		
		int sum = 5;
		
	//	numbers.add(new SumIndex(0,1));
	//	numbers.add(new SumIndex(1,2));
	//	numbers.add(new SumIndex(2,4));
		//numbers.add(new SumIndex(3,3));
	//	numbers.add(new SumIndex(4,5));
	//	numbers.add(new SumIndex(5,7));
	//	numbers.add(new SumIndex(6,0));	
		
		
		int indexCounter = -1;
		
		for(SumIndex num : numbers) {
			indexCounter++;
			
			int remaining_sum = sum - (num.getRemainingsum());
			
			SumIndex sumIndex = new SumIndex(indexCounter, remaining_sum);
			numberCheckList.add(sumIndex);
		}		
		
		for(SumIndex numberCheck : numberCheckList) {			
			
			if(numbers.contains(numberCheck)){
				//System.out.println(arg0);
			}
			
		}
		
	}

}
