package com.codefoundry.practise.general;

public class TescoLiteraryCompetition {

	

	public TescoLiteraryCompetition() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		TescoLiteraryCompetition t = new TescoLiteraryCompetition();
		
		int maxBen = t.Books1(3, 7, new int[] {2,6,9}, new int[] {3,5,3}, 0, 0);
		System.out.println(maxBen);

	}

	int Books1(int numOfBooks, int totalTime, int points[], int times[], int start, int maxPoints) {
	
		if (start >= numOfBooks || totalTime <= 0) {
			return maxPoints;
		}

		int resultInclude = 0;
		int excludeInclude = 0;
		
		int sum1 = 0;

		if (times[start] <= totalTime) {
			resultInclude = Books1(numOfBooks, (totalTime - times[start]) , points, times, (start + 1), (maxPoints + points[start]));			
		}
		
		excludeInclude = Books1(numOfBooks, totalTime , points, times, (start + 1), maxPoints);	
		
	
		return Math.max(excludeInclude, resultInclude);
	}
}
