/**
 * 
 */
package com.codefoundry.hackerrank.tree;

/**
 * @author vipul
 *
 */
public class LockerDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
		 
		 int[][] city = new int[cityLength][cityWidth]; 
		 
		 for(int i = 0; i < cityLength; i++){
			 
			 for(int j = 0; j < cityWidth; j++){
				 city[i][j] = -1; 
			 }
		 }
		 
		 for(int i = 0; i < cityLength; i++){		 
			 
			 for(int j = 0; j < cityWidth; j++){
				 
				 int sum = Integer.MAX_VALUE;
				 
				 int x  = i;
				 int y  = j;			 
				
				 for(int k = 0; k < lockerYCoordinates.length; k++){
					 
					 int x1  = (lockerXCoordinates[k]-1);
					 int y1  = (lockerYCoordinates[k]-1);
					 
					 int xDiff = Math.abs(x1 - x);
					 int yDiff = Math.abs(y1 - y);	
					 
					 int dist = xDiff + yDiff;
					 
					 if(sum > dist){
						 sum = dist; 
					 }
				 }					 
				 city[i][j] = sum;
			 }			 
			 
		 }

		 return city;
	}
	

}
