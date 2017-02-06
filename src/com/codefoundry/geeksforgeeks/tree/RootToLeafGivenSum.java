package com.codefoundry.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.List;

public class RootToLeafGivenSum {

	class Count {
		int size = 0;

		@Override
		public String toString() {
			return "size=" + size;
		}
	}

	Node root;

	public RootToLeafGivenSum() {
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

		RootToLeafGivenSum tree = new RootToLeafGivenSum();
		tree.root = tree.new Node(10);

		tree.root.left = tree.new Node(5);
		tree.root.left.left = tree.new Node(4);
		tree.root.left.right = tree.new Node(6);
		tree.root.left.left.left = tree.new Node(3);

		tree.root.right = tree.new Node(19);
		tree.root.right.left = tree.new Node(15);
		tree.root.right.right = tree.new Node(20);

		List<Node> path = new LinkedList<Node>();

		boolean result = tree.printPath(tree.root, 22, path);
		System.out.println(result);

		if (result) {
			for (Node node : path) {
				System.out.print(node.data + " ");
			}

		} else {
			System.out.println("No path for sum " + 22);
		}
	}

	public boolean printPath(Node root, int sum, List<Node> path) {
		
		if (root == null) {
			return false;
		}
		
		if(root.data > sum){
			return false;
		}

		if (root.left == null && root.right == null) {

			if (root.data == sum) {
				path.add(root);
				return true;
			}
			return false;
		}

		boolean isLeftPath = printPath(root.left, sum - root.data, path);
		boolean isRightPath = printPath(root.right, sum - root.data, path);

		if(isLeftPath || isRightPath){
			path.add(root);
			return true;
		}
		return false;
	}

}
