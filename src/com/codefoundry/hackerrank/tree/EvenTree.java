package com.codefoundry.hackerrank.tree;

import java.util.Scanner;

public class EvenTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		
		int numOfVertices = in.nextInt();
		int numOfEdges = in.nextInt();
		
		
		int[][] tree = new int[numOfVertices][numOfVertices];
		
		for(int i=0 ;i< numOfVertices; i++ ){
			for(int j=0 ;j< numOfVertices; j++ ){
				tree[i][j]=0;
			}
		}
		
		
		for(int i=0 ;i< numOfVertices; i++ ){
			String edge = in.nextLine();
			String[] edgesChar = edge.split(" ");	
		}		
		
	}

}
