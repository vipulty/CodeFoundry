package com.codefoundry.practise.general;

//Java program to print all permutations using
//Heap's algorithm
class HeapAlgo
{
	//Prints the array
	void printArr(int a[], int n)
	{
		for (int i=0; i<n; i++)
		System.out.print(a[i] + " ");
		System.out.println();
	}

	//Generating permutation using Heap Algorithm
	void heapPermutation(int a[], int size, int n)
	{
		//System.out.println("size = " + size + " , n = " + n);
		// if size becomes 1 then prints the obtained
		// permutation
		if (size == 1) {
			printArr(a,n);
		}	

		for (int i=0; i<size; i++)
		{
			//System.out.println("");
			//System.out.println("");
			//System.out.println("i = " + i);
			heapPermutation(a, size-1, n);
			//System.out.println("returned back from ... " + "size = " + (size -1) + " , n = " + n + " , 1 = " + i);

			// if size is odd, swap first and last
			// element
			if (size % 2 == 1)
			{
				int temp = a[0];
				a[0] = a[size-1];
				a[size-1] = temp;
				System.out.println("Odd. Flipping =  " + a[0] + " and " + a[size-1]);
			}

			// If size is even, swap ith and last
			// element
			else
			{
				System.out.println("Even. Flipping =  " + a[i] + " and " + a[size-1]);
				int temp = a[i];
				a[i] = a[size-1];
				a[size-1] = temp;
			}
		}
	}

	// Driver code
	public static void main(String args[])
	{
		
		HeapAlgo obj = new HeapAlgo();
		int a[] = {1,2,3};
		obj.heapPermutation(a, a.length, a.length);
	}
}

//This code has been contributed by Amit Khandelwal.

