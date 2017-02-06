package com.codefoundry.geeksforgeeks.tree;

public class FindAllNodesAtDistanceK {

	Node root;

	public FindAllNodesAtDistanceK() {
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
		FindAllNodesAtDistanceK tree = new FindAllNodesAtDistanceK();

		tree.root = tree.new Node(10);

		tree.root.left = tree.new Node(3);
		tree.root.left.left = tree.new Node(-1);
		tree.root.left.right = tree.new Node(8);
		tree.root.left.left.left = tree.new Node(-6);
		tree.root.left.left.left.left = tree.new Node(-11);

		tree.root.right = tree.new Node(18);
		tree.root.right.left = tree.new Node(11);
		tree.root.right.right = tree.new Node(26);
		tree.root.right.left.right = tree.new Node(13);
		tree.root.right.right.right = tree.new Node(27);

		tree.printNodes(tree.root, 11, 2);
	}

	private void findInChild(Node root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
		}
		findInChild(root.left, k - 1);
		findInChild(root.right, k - 1);
	}

	public int printNodes(Node root, int dest, int k) {
		if (root == null) {
			return -1;
		}

		if (root.data == dest) {
			findInChild(root, k);
			return k - 1;
		}

		int found = printNodes(root.left, dest, k);
		if (found != -1) {
			if (found == 0) {
				System.out.println(root.data);
			} else {
				findInChild(root.right, found - 1);
			}
			return found - 1;
		}

		found = printNodes(root.right, dest, k);
		if (found != -1) {
			if (found == 0) {
				System.out.println(root.data);
			} else {
				findInChild(root.left, found - 1);
			}
			return found - 1;
		}
		return -1;
	}

}
