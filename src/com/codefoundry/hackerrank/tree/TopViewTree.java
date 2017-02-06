package com.codefoundry.hackerrank.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



import java.util.Set;
import java.util.TreeMap;

public class TopViewTree {
	
	Node root;

	public TopViewTree() {
		root = null;
	}
	
	
	 class Node {

		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}


	public static void main(String[] args) {
		TopViewTree tree = new TopViewTree();
		tree.root = tree.new Node(3);
		
		tree.root.left = tree.new Node(5);
		tree.root.left.left = tree.new Node(1);
		tree.root.left.left.right = tree.new Node(9);
		tree.root.left.right = tree.new Node(4);
		
		tree.root.right = tree.new Node(2);
		tree.root.right.left = tree.new Node(6);
		tree.root.right.right = tree.new Node(7);
		tree.root.right.right.left = tree.new Node(8);
		
		Map<Integer, List<Node>> levels = new TreeMap<Integer, List<Node>>();
		
		tree.printTopView(tree.root,0, levels);
		
		for(Entry<Integer, List<Node>> s : levels.entrySet()){
			System.out.print(s.getValue().get(0).data + " ");
			//System.out.println("Level = " + s.getKey());
			
			//for(Node n : s.getValue()){
               // System.out.print(n.data + " ");
           // }
           // System.out.println();
		}
	}
	
	
	void printTopView(Node root, int level, Map<Integer, List<Node>> levels){
		
		if(root == null){
		  return;	
		}
		
		if(levels.get(level) == null){
			List<Node> nodes = new LinkedList<Node>();	
			nodes.add(root);
			levels.put(level,nodes);
		} else {
			List<Node> nodes = levels.get(level);
			nodes.add(root);
			levels.put(level,nodes);
		}
		
		printTopView(root.left,level-1, levels);
		printTopView(root.right,level+1, levels);
		
	}

}
