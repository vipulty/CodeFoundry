package com.codefoundry.hackerrank.tree;

public class IsBST {
	
	class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


	public static void main(String[] args) {
		IsBST isBST = new IsBST();
		
		Node root = isBST.new Node(3);
	
		root.left = isBST.new Node(5);
		root.right = isBST.new Node(2);
		
		root.left.left = isBST.new Node(1);
		root.left.right = isBST.new Node(4);
		
		root.right.left = isBST.new Node(6);
		
		//System.out.println(x);isBST.new Node(root);

	}
	
	
   boolean checkBST(Node root) {
	return false;
        
    }

}
