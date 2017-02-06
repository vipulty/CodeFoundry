package com.codefoundry.practise.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDiffArray {

	public MaxDiffArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static int maxDifference(int[] a) {
		
		List<Integer> intList = new ArrayList<Integer>();
		
		for (int index = 0; index < a.length; index++)
		{
		    intList.add(a[index]);
		}
		
		Collections.sort(intList);
		
		int greatest = intList.get(intList.size()-1);
		
		int i = -1;
		
		for(int k : a){
			
			i++;
			if(k == greatest){
				break;
			}
		}
		
		int smallest = Integer.MAX_VALUE;
		
		for (int index = 0; index <= i; index++)
		{
		   if(a[index] < smallest){
			   smallest = a[index];  
		   } 
		}
		
		return greatest - smallest;

  
    }

}
