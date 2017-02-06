package com.codefoundry.practise.general;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Fibo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int f = in.nextInt();
        int s = in.nextInt();
        int pos = in.nextInt();

        
        BigDecimal first = new BigDecimal(f);
        BigDecimal second = new BigDecimal(s);      
        BigDecimal square = null;
        
        for(int i = 2; i <= pos; i++) {        	
        	 square = new BigDecimal(Math.pow(second.doubleValue(), 2));        
        	 square = square.add(first);      
        	 first = second;
        	second = square;        	
        }
        System.out.println(square.intValue());        
    }  
    
   
}
