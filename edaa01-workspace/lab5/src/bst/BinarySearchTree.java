package bst;


public class BinarySearchTree<E extends Comparable<E>> {
	BinaryNode<E> root;
	int size;
	boolean addReturn;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		addReturn = false;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		root = add(root, x);
		return addReturn;
	}

	private BinaryNode<E> add(BinaryNode<E> localRoot, E x) {
		
		if (localRoot == null) {
			addReturn = true;
			return new BinaryNode<>(x);
		} else if (x.compareTo(localRoot.element) == 0) {
			addReturn = false;
			return localRoot;
		} else if (x.compareTo(localRoot.element) < 0) {
			localRoot.left = add(localRoot.left, x);
			return localRoot;
		} else
			localRoot.right = add(localRoot.right, x);
		return localRoot;

	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		if (root != null) {
			return root.getHeight();
		}
		return 0;
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		if (root != null) {
			return root.getSize();
		}
		return 0;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printInorder(root);
	}

	private void printInorder(BinaryNode<E> localRoot) {
		if (localRoot == null) {
			return;
		} else {
			printInorder(localRoot.left);
			System.out.println(localRoot.element);
			printInorder(localRoot.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1 (the
	 * first empty position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		return 0;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in the
	 * array a are assumed to be in ascending order. Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}

		public int getHeight() {
			int leftHeight = 0, rightHeight = 0;
			if (this.left != null) {
				leftHeight = this.left.getHeight();
			}
			if (this.right != null) {
				rightHeight = this.right.getHeight();
			}
			return 1 + Math.max(rightHeight, leftHeight);
		}

		public int getSize() {
			int leftSize = 0, rightSize = 0;
			if (this.left != null) {
				leftSize = this.left.getSize();
			}
			if (this.right != null) {
				rightSize = this.right.getSize();
			}
			return 1 + leftSize + rightSize;
		}

	}

	public static class Book {
		
	}
	
	
	public static void main(String[] args) {
//		BinarySearchTree<Book> books;
//		TreeSet<Book> books2;
//		BSTVisualizer bst1 = new BSTVisualizer("Family", 400, 400);
//		BinarySearchTree<String> fm = new BinarySearchTree<String>();
//		fm.add("Willim I");
//		fm.add("Robert");
//		fm.add("Willim");
//		fm.add("Willim II");
//		fm.add("Stephen");
//		fm.add("Willim III");
//		fm.add("Stephen I");
//		bst1.drawTree(fm);
//		
//		
		BSTVisualizer bst1 = new BSTVisualizer("First Tree", 400, 400);
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
		for (int i = 0; i < 6; i++) {
			tree1.add(i);
		}
		bst1.drawTree(tree1);
		
//		
//		BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>();
//		tree2.add(5);
//		tree2.add(3);
//		tree2.add(1);
//		tree2.add(4);
//		tree2.add(2);
//		BSTVisualizer bst2 = new BSTVisualizer("Second Tree", 400, 400);
//		bst2.drawTree(tree2);
//		
//		BinarySearchTree<Integer> tree3 = new BinarySearchTree<Integer>();
//		tree3.add(5);
//		tree3.add(3);
//		tree3.add(2);
//		tree3.add(1);
//		tree3.add(4);
//		BSTVisualizer bst3 = new BSTVisualizer(" third Tree ", 400, 400);
//		bst3.drawTree(tree3);
//		
		BinarySearchTree<Integer> tree4 = new BinarySearchTree<Integer>();
		tree4.add(3);
		tree4.add(2);
		tree4.add(5);
		tree4.add(4);
		tree4.add(1);
		BSTVisualizer bst4 = new BSTVisualizer(" Fourth Tree ", 400, 400);
		bst4.drawTree(tree4);
//		
//		BinarySearchTree<Integer> tree5 = new BinarySearchTree<Integer>();
//		tree5.add(3);
//		tree5.add(1);
//		tree5.add(5);
//		tree5.add(0);
//		tree5.add(2);
//		tree5.add(4);
//		tree5.add(6);
//		BSTVisualizer bst5 = new BSTVisualizer("Fifth Tree ", 400, 400);
//		bst5.drawTree(tree5);
}
	
}
