package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> newnode = new QueueNode<E>(e);
		if (size == 0) {
			last = newnode;
			newnode.next = last;
		} else {
			newnode.next = last.next;
			last.next = newnode;
			last = newnode;
		}
		size++;
		return true;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */

	public E peek() {
		if (size == 0) {
			return null;
		}
		return last.next.element;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (size == 0) {
			return null;
		}
		QueueNode<E> temp = last.next;
		last.next = last.next.next;
		size--;
		return temp.element;
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {

		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private int index;

		private QueueIterator() {
			pos = last;
			index = 0;
		}

		@Override
		public boolean hasNext() {
			if (size != 0 && index < size) {
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			if (hasNext()) {
				pos = pos.next;
				index++;
				return pos.element;
			}
			throw new NoSuchElementException();
		}
	}

	public void append(FifoQueue<E> q) {
		if (this == q) {
			throw new IllegalArgumentException();
		}

		if (q.size() == 0) {
			return;
		} else if (this.size == 0) {
			this.last = q.last;
			this.last.next = q.last.next;
			this.size = q.size;
			q.size = 0;
			q = null;

			return;
		}
		QueueNode<E> temp = last.next;
		this.last.next = q.last.next;
		q.last.next = temp;
		this.last = q.last;
		this.size = this.size + q.size;
		q.size = 0;
		q = null;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}