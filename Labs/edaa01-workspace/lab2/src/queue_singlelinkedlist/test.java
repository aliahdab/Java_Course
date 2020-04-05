package queue_singlelinkedlist;

import java.util.Iterator;
import java.util.Queue;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q1 = new FifoQueue<Integer>();
		Queue<Integer> q2 = new FifoQueue<Integer>();
	
		Queue<String> q11 = new FifoQueue<String>();
		Queue<String> q12 = new FifoQueue<String>();
		
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		q1.add(5);
		q1.add(6);
		q2.add(7);
		q2.add(8);
		q2.add(9);
		q2.add(10);
		q2.add(11);

		((FifoQueue<Integer>) q1).append((FifoQueue<Integer>) q2);

		for (Integer i : q1) {
			System.out.println(i);
			
		}
		System.out.println();
		System.out.println();
		
			q11.add("Dani");
			q11.add("Dan");
			q11.add("Emmma");
			q12.add("Lana");
			q12.add("Marcos");
			
			Iterator<String> itr11 = q11.iterator();
			String[] oldQ11 = new String[3] ;
			for(int i=0; i<3;i++) {
			oldQ11[i]=itr11.next();	
			}
			
			Iterator<String> itr12 = q12.iterator();
			Iterator<String> itr9=itr11;
			((FifoQueue<String>) q11).append((FifoQueue<String>) q12);
			
			Iterator<String> itr5 = q11.iterator();

			for(String i:oldQ11) {
				System.out.println(i);
			}
		}

	}


