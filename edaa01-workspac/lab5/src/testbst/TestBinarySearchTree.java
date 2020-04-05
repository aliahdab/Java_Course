package testbst;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import bst.BinarySearchTree;

class TestBinarySearchTree {
	BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
	BinarySearchTree<String> tree2 = new BinarySearchTree<String>();
	BinarySearchTree<String> tree3 = new BinarySearchTree<String>();

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	

	@Test
	void testAdd() {
		String x = "Sara";
		for (int i = 0; i < 50; i++) {
			tree2.add(x);
			x = x + i;}
		assertTrue("Addition times are not correct ",tree2.size()==50);
		tree2.add("Sara");
		assertTrue(" error when you add same item ",tree2.size()==50);
	}
	
	@Test
	void testHeight() {
		assertFalse("Wrong height in an empty Tree", tree1.height() != 0);
		tree1.add(40);
		tree1.add(30);
		tree1.add(50);
		tree1.add(55);
		tree1.add(32);
		tree1.add(57);
		tree1.add(34);
		tree1.add(33);
		assertTrue("Wrong height of Tree", tree1.height() == 5);
		tree1.add(40);
		assertFalse("Wrong height after add dublicate value ", tree1.height() != 5);
	}

	@Test
	void testsize() {
		assertTrue("Wrong size in an empty Tree", tree2.size() == 0);
		String x = "wiliam";
		for (int i = 0; i < 50; i++) {
			tree2.add(x);
			x = x + i;
		}
		assertTrue("Wrong tree size", tree2.size() == 50);
		x = "wiliam";
		for (int i = 0; i < 5; i++) {
			tree2.add(x);
			x = x + i;
		}
		assertFalse("Wrong tree size after add same items", tree2.size() == 55);

	}

}
