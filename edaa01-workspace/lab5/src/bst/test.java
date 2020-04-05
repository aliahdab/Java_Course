package bst;

public class test {

	public static void main(String[] args) {
		BinarySearchTree<String> fm = new BinarySearchTree<String>();
		fm.add("dog");
		fm.add("cat");
		fm.add("canine");
		fm.add("wolf");
		fm.add("wolf");
		BSTVisualizer bst = new BSTVisualizer("Test", 400, 400);
		bst.drawTree(fm);
	}
}
