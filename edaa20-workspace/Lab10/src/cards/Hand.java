package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
	private ArrayList<Card> handlist;

	public Hand() {
		handlist = new ArrayList<Card>();
	}

	public void insert(Card c) {
		handlist.add(c);
		Collections.sort(handlist, new Comparator<Card>() {
			public int compare(Card c1, Card c2) {
				return Integer.valueOf(c1.getRank()).compareTo(c2.getRank());
			}
		});
	}

	public Card remove(int pos) {
		return handlist.remove(pos);
	}

	public int nbrCards() {
		return handlist.size();
	}

	public int rankSum(boolean ace14) {
		int sum = 0;
		for (Card cardsum : handlist)
			if (cardsum.getRank() == 1 && ace14)
				sum += cardsum.getRank() + 13;
			else
				sum += cardsum.getRank();
		return sum;
	}

	public void display(CardWindow w) {
		w.displayCards(handlist);
	}
}