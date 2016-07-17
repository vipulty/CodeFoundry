/**
 * 
 */
package com.codefoundry.hackerrank.array;

//https://www.hackerrank.com/contests/101hack39/challenges/equality-in-a-array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author vipul
 *
 */
public class EqualizeArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		
		int inputSize = in.nextInt();
		in.nextLine();
        String input = in.nextLine();			
		
		String inputArray[] = input.split(" ");
		int inputLength = inputArray.length;
		
		
		Map<String,Integer> map = new HashMap<>();
		
		for(String s : inputArray){			
			
			
			if(map.get(s) != null){
				int count = map.get(s);
				map.put(s, ++count);
			}else {
				map.put(s, 1);
			}
		}
		List<Integer> list = new ArrayList(map.values());
		Collections.sort(list);	
		
		
		int heighestNum = list.get(list.size()-1);
		
		
		System.out.println(inputLength - heighestNum);
		
		
		
		
		

		
	}		

}
