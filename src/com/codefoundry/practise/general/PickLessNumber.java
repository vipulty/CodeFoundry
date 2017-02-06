package com.codefoundry.practise.general;

import java.util.Scanner;

public class PickLessNumber {

   public static void main(String arg[]) {
	   Scanner s = new Scanner(System.in);
	   int count = s.nextInt(); 
	   
	   int [] numbers = new int[count];
       Scanner numScanner = new Scanner(s.nextLine());
       for (int i = 0; i < count; i++) {
           if (numScanner.hasNextInt()) {
               numbers[i] = numScanner.nextInt();
             
           } else {
               System.out.println("You didn't provide enough numbers");
               break;
           }
       }
       
       int result = Integer.MAX_VALUE;
       
       for (int i = 0; i < count; i++) {
    	   
    	   int prevIndex = i - 1;
    	   int nextIndex = i + 1;
    	   
    	   if(prevIndex < 0 || i == (count-1)){
    		   continue;
    	   }
    	   
    	   if(numbers[prevIndex] <= numbers[i] && numbers[nextIndex] <= numbers[i]){
    		   
    		   if(result > numbers[i]){
    		   result = numbers[i];
    		  
    		   }
    	   }
       }
       
       System.out.println("result = " + result);
       
   }

}
