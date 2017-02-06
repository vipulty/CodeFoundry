package Tree;

// Recursive Java program for level order traversal of Binary Tree

class LevelOrderTreeTraversal {
	// Root of the Binary Tree
	Node root;

	public LevelOrderTreeTraversal() {
		root = null;
	}

	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);
		
		//System.out.println("height = " + h);
		
		int i;
		//for (i = 1; i <= h; i++)
			printGivenLevel(root, 3);
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node root, int level) {
		
		System.out.println("data = " + root.data + " level = " + level);
		
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
		}	
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			System.out.println("left returned... " + root.left.data + " level = " + (level-1));
			printGivenLevel(root.right, level - 1);
			System.out.println("right returned... " + root.left.data + " level = " + (level-1));
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		LevelOrderTreeTraversal tree = new LevelOrderTreeTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}

}
