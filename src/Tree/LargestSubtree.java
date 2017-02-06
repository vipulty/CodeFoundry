package Tree;

public class LargestSubtree

{
	
	

	int largestSubtreeUtil(Node root, Value1 value) {

		if (root == null) {
			System.out.println("Called-> data = null " + " , str = " + value.getStr() + " ,  size = " + value.getMaxSize());
			return 0;
		}
		
		System.out.println("Called-> data = " + root.data + " , str = " + value.getStr() + " ,  size = " + value.getMaxSize());

			

		// String to store structure of left and
		// right subtrees
		String left = "", right = "";

		Value1 newValue1 = new Value1(value.getMaxSize(), left, value.getMaxNode());

		// traverse left subtree and finds its size
		int ls = largestSubtreeUtil(root.left, newValue1);
		left = newValue1.getStr();
		System.out.println("left = " + left);
		
		newValue1 = new Value1(value.getMaxSize(), right, value.getMaxNode());

		// traverse right subtree and finds its size
		int rs = largestSubtreeUtil(root.right, newValue1);
		right = newValue1.getStr();
		
		System.out.println("right = " + right);

		// if left and right subtrees are similar
		// update maximum subtree if needed (Note that
		// left subtree may have a bigger value than
		// right and vice versa)
		

		if (left.compareTo(right) == 0) {
			
			int size = ls + rs + 1;
			System.out.println("size = " + size);
			
			if (size > value.getMaxSize()) {
				value.setMaxSize(size);
				value.setMaxNode(root);
			}
			value.setMaxSize(size);
		} else {
			System.out.println("left and right are not same");	
		}
		
		// append left subtree data
		String s = value.getStr() + ("|") + (left) + ("|");

		// append current node data
		s = s + value.getStr() + ("|") + (root.data) + ("|");

		// append right subtree data
		s = s + value.getStr() + ("|") + (right) + ("|");
		
		System.out.println("s = " + s);
		
		value.setStr(s);

		return value.getMaxSize();
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {

		LargestSubtree lbt = new LargestSubtree();

		/*
		 * Let us construct the following Tree 50 / \ 10 60 / \ / \ 5 20 70 70 /
		 * \ / \ 65 80 65 80
		 */
		Node root = new Node(50);
		root.left = new Node(10);
		root.right = new Node(60);
		root.left.left = new Node(5);
		root.left.right = new Node(20);
		root.right.left = new Node(70);
		root.right.left.left = new Node(65);
		root.right.left.right = new Node(80);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);

		int maxSize = 0;
		String str = "";
		Node maxNode = null;

		Value1 value = new Value1(maxSize, str, maxNode);
		maxSize = lbt.largestSubtreeUtil(root, value);

		 System.out.println("Largest Subtree is rooted at node " +
				 value.getMaxNode().data + " and its size is " + maxSize);
	}

}


class Value1 {

	Node maxNode = null; // for size of largest BST
	int maxSize = 0; // for size of largest BST
	String str = "";
	public Value1(int maxSize, String str, Node maxNode) {		
		this.maxSize = maxSize;
		this.str = str;
		this.maxNode = maxNode;
	}
	public int getMaxSize() {
		return maxSize;
	}
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Node getMaxNode() {
		return maxNode;
	}
	public void setMaxNode(Node maxNode) {
		this.maxNode = maxNode;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

}
