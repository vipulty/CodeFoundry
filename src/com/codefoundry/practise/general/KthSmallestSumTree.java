package com.codefoundry.practise.general;

import com.codefoundry.practise.general.TreeNode;



/**
 * http://cslibrary.stanford.edu/109/TreeListRecursion.html Test cases Null tree
 * 
 */


class SumResult {
	int count = 0;
}

public class KthSmallestSumTree {

	static TreeNode root;
	

	public static void main(String args[]) {
		KthSmallestSumTree btc = new KthSmallestSumTree();

		btc.root = new TreeNode(8);
		
		btc.root.left = new TreeNode(4);
		btc.root.left.left = new TreeNode(2);
		btc.root.left.right = new TreeNode(6);	
		
		
		btc.root.left.left.left = new TreeNode(1);
		btc.root.left.left.right = new TreeNode(3);		
		
		btc.root.left.right.left = new TreeNode(5);
		btc.root.left.right.right = new TreeNode(7);

		SumResult sumResult = new SumResult();
		int result = btc.KthSmallestSumTree(root, 5 , sumResult);

		System.out.println(result);
		
	}
	
	
	private int KthSmallestSumTree(TreeNode root, int k, SumResult sumResult) {
		
		if(root == null){
			return 0;
		}
		
		int sumLeft =  KthSmallestSumTree(root.left,k, sumResult);	
		
		sumResult.count = sumResult.count + 1;		
		
		if(sumResult.count == k){	
			sumLeft = sumLeft + root.data;
			return sumLeft;
		} else if (sumResult.count < k) {
			sumLeft = sumLeft + root.data;
		} else {
			return sumLeft;
		}
		
		int sumRight =  KthSmallestSumTree(root.right,k, sumResult);
		
		return sumLeft + sumRight;	
		
	}
	
}	

	