package com.codefoundry.practise.general;

import java.io.*;
import java.util.*;

public class CountIslands
{
	public static void main(String[] args)throws IOException
	{
		int[][] a = new int[][] {{1, 1, 0, 0, 0},
								{0, 1, 0, 0, 1},
								{1, 0, 0, 1, 1},
								{0, 0, 0, 0, 0},
								{1, 0, 1, 0, 1}
								};
		System.out.println("Number of Islands is: " +
				countIsland(a));
	} 

	// Returns number of islands in a[][]
	static int countIsland(int a[][])
	{
		int n = a.length;
		int m = a[0].length;
	
		DisjointUnionSets dus = new DisjointUnionSets(n*m);
		
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		/* The following loop checks for its neighbours
		and unites the indexes if both are 1. */
		for (int j=0; j<n; j++)
		{
			for (int k=0; k<m; k++)
			{
				System.out.println(" For a["+j+"]["+k+"]");
				// If cell is 0, nothing to do
				if (a[j][k] == 0) {
					continue;
				}	

				// Check all 8 neighbours and do a union
				// with neighbour's set if neighbour is 
				// also 1
				int x = j + rowNbr[k];
				int y = j + rowNbr[k];
				boolean val = isSafe(x, k + y,  n, m);
				
				if(val){					
					if(a[x][y] == 1){
						System.out.println(" Valid a["+x+"]["+y+"]");
						dus.union(j + rowNbr[k],k + colNbr[k]);	
					}
				}
			}
		}

		// Array to note down frequency of each set
		int[] c = new int[n*m];
		int numberOfIslands = 0;
		for (int j=0; j<n; j++)
		{
			for (int k=0; k<m; k++)
			{
				if (a[j][k]==1)
				{

					int x = dus.find(j*m+k);

					// If frequency of set is 0, 
					// increment numberOfIslands
					if (c[x]==0)
					{
						numberOfIslands++;
						c[x]++;
					}

					else
						c[x]++;
				}
			}
		}
		return numberOfIslands;
	}
	
	private static boolean isSafe(int row, int col, int maxRow, int maxCol) {

		return (row >= 0) && (row < maxRow) && (col >= 0) && (col < maxCol);
	}
}

//Class to represent Disjoint Set Data structure
class DisjointUnionSets
{
	int[] rank, parent;
	int n;

	public DisjointUnionSets(int n)
	{
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}

	void makeSet()
	{
		// Initially, all elements are in their
		// own set.
		for (int i=0; i<n; i++)
			parent[i] = i;
	}

	// Finds the representative of the set that x
	// is an element of
	int find(int x)
	{
		if (parent[x] != x)
		{
			// if x is not the parent of itself,
			// then x is not the representative of
			// its set.
			// so we recursively call Find on its parent
			// and move i's node directly under the
			// representative of this set
			return find(parent[x]);
		}

		return x;
	}

	// Unites the set that includes x and the set
	// that includes y
	void union(int x, int y)
	{
		// Find the representatives (or the root nodes)
		// for x an y
		int xRoot = find(x);
		int yRoot = find(y);

		// Elements are in the same set, no need
		// to unite anything.
		if (xRoot == yRoot)
			return;

		// If x's rank is less than y's rank
		// Then move x under y so that depth of tree
		// remains less
		if (rank[xRoot] < rank[yRoot])
			parent[xRoot] = yRoot;

		// Else if y's rank is less than x's rank
		// Then move y under x so that depth of tree
		// remains less
		else if(rank[yRoot]<rank[xRoot])
			parent[yRoot] = xRoot;

		else // Else if their ranks are the same
		{
			// Then move y under x (doesn't matter
			// which one goes where)
			parent[yRoot] = xRoot;

			// And increment the the result tree's
			// rank by 1
			rank[xRoot] = rank[xRoot] + 1;
		}
	}
}
