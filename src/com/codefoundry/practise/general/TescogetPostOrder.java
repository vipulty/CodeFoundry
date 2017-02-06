package com.codefoundry.practise.general;


import java.io.*;
import  java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


// Read only region start
class TescogetPostOrder
{

	public int[] Find_PostOrder(int input1,int[] input2,int[] input3){

       
		int result[] = new int[input1];
	
		makeBTree(input2, input3, 0, 0, input1, result,0);
		return result;
	}
	

	
	public void makeBTree(int[] inOrder,int[] preOrder, int preIndex, int inIndex, int n, int[] result, int resultIndex){
		if(preIndex>n){
			return ;
		}
		 result[resultIndex] = preOrder[preIndex];		
	   int index = search(inOrder,preOrder[preIndex], n);
		
		 if (index != 0)
		makeBTree(inOrder,preOrder,preIndex+1,inIndex, n, result, resultIndex+1);
		
		 if (index != n-1)
		 makeBTree(inOrder,preOrder,preIndex+index+1,inIndex+index+1, n, result, resultIndex+1);
		 
		
		
	}
	
	
	int search(int arr[], int x, int n)
	{
	    for (int i = 0; i < n; i++)
	      if (arr[i] == x)
	         return i;
	    return -1;
	}
	

}	
