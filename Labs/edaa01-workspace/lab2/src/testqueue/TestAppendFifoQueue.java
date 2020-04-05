package testqueue;

import static org.junit.Assert.*;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue_singlelinkedlist.FifoQueue;

public class TestAppendFifoQueue {

	private FifoQueue<Integer> q1;
	private FifoQueue<Integer> q2;
	private FifoQueue<String> q3;
	private FifoQueue<String> q4;

	@Before
	public void setUp() throws Exception {
		q1 = new FifoQueue<Integer>();
		q2 = new FifoQueue<Integer>();
		q3 = new FifoQueue<String>();
		q4 = new FifoQueue<String>();
	}

	@After
	/* this to clean Up after every test */
	public void tearDown() throws Exception {
	}

	@Test
	public void testAppend_twoEmptyQueues() {
		q1.append(q2);
		assertTrue("Wrong size of queue", q1.size() == 0);
		assertTrue("Wrong size of the second queue", q2.size() == 0);
	}

	// Add an EmptyFifoQueue to NonEmpty FifoQueue
	@Test
	public void testAppend_EmptyQueueWithNonEmptyQueue() {

		for (int i = 1; i < 6; i++) {
			q1.offer(i);
		}

		q1.append(q2);
		assertTrue("Wrong size of queue", q1.size() == 5);
		assertTrue("Wrong size of the second queue", q2.size() == 0);
		for (int i = 1; i < 6; i++) {
			assertTrue("Wrong first Queue's element is existing", q1.poll() == i);
		}

	}

	// add a NonEmpty FifoQueue to an Empty FifoQueue
	@Test
	public void testAppend_nonEmptyQueueWithEmptyQueue() {
		for (int i = 1; i < 6; i++) {
			q2.offer(i);
		}

		q1.append(q2);
		assertTrue("Wrong size of queue", q1.size() == 5);
		assertTrue("Wrong size of the second queue", q2.size() == 0);
		for (int i = 1; i < 6; i++) {
			assertTrue("Wrong first Queue's element is existing", q1.poll() == i);
		}
	}

	// merge two NonEmpty FifoQueue
	@Test
	public void testAppend_nonEmptyQueueWithNonEmptyQueue() {

		for (int i = 0; i < 6; i++) {
			q1.offer(i + 1);
		}

		for (int i = 0; i < 5; i++) {
			q2.offer(i + 1);
		}
		q1.append(q2);
		Iterator<Integer> itr1 = q1.iterator();
		assertTrue("Wrong size of the first queue", q1.size() == 11);
		assertTrue("Wrong size of the second queue", q2.size() == 0);

		for (Integer i : q1) {
			assertEquals("the element number is not", i, itr1.next());
		}
//		for(int i=1;i<5;i++) {
//			q3.offer("MyVal"+Integer.toString(i));
//		}

		q3.offer("Dani");
		q3.offer("Dan");
		q3.offer("Emmma");
		q3.offer("Elma");
		q3.offer("Dana");

		q4.offer("Talya");
		q4.offer("Lana");
		q4.offer("Marcos");

		Iterator<String> itr3 = q3.iterator();
		Iterator<String> itr4 = q4.iterator();
		String[] q3beforeArray = new String[5];
		for (int i = 0; i < 5; i++) {
			q3beforeArray[i] = itr3.next();
		}
		String[] q4beforeArray = new String[3];
		for (int i = 0; i < 3; i++) {
			q4beforeArray[i] = itr4.next();
		}

		q3.append(q4);

		Iterator<String> itr = q3.iterator();
		assertTrue("Wrong size of the first queue", q3.size() == 8);
		assertTrue("Wrong size of the second queue", q4.size() == 0);

		for (String i : q3beforeArray) {
			assertEquals("the element number is not", i, itr.next());
		}
		for (String i : q4beforeArray) {
			assertEquals("the element number is not", i, itr.next());
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAppend_aQueueWithItself() {
		q1.append(q1);

	}
}
