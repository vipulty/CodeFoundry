package com.codefoundry.geeksforgeeks.tree;



public class SumNodesTree {
	
	class Count{
	    int size = 0;
	    
	    @Override
		public String toString() {
			return "size=" + size;
		}
	}

	
	Node root;

	public SumNodesTree() {
		root = null;
	}

	class Node {

		int data;
		@Override
		public String toString() {
			return "data=" + data;
		}

		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}
	

	public static void main(String[] args) {
		
		SumNodesTree tree = new SumNodesTree();
		tree.root = tree.new Node(46);
		
		tree.root.left = tree.new Node(10);
		tree.root.left.left = tree.new Node(4);		
		tree.root.left.right = tree.new Node(6);
		
		tree.root.right = tree.new Node(13);
		tree.root.right.left = tree.new Node(11);
		tree.root.right.right = tree.new Node(2);
		
		boolean result = tree.isSumTree(tree.root, tree.new Count());
		System.out.println(result);
	}
	

	
	private boolean isSumTree(Node root, Count count){
		
		 if(root == null){
	            return true;
	    }
		
		if(root.left == null && root.right == null){	
			count.size = root.data;
			return true;
		}
		
		Count leftCount = new Count();
		Count rightCount = new Count();
		
		boolean leftResult = isSumTree(root.left, leftCount);
		boolean rightResult = isSumTree(root.right, rightCount);
		
		if(!leftResult || !rightResult){
			return false; 	
		}
		
		count.size = root.data +  leftCount.size + rightCount.size;
		
		if(root.data == leftCount.size + rightCount.size){		
			return true;
		}		
		return false; 		
	}
}
