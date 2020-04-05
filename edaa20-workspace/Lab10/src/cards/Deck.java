package cards;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cardsdeck;
	private Random rand;

	/** Skapar en blandad kortlek med 52 kort. */
	public Deck() {

		rand = new Random();
		cardsdeck = new ArrayList<Card>();
		for (int i = 0; i <= 3; i++) {
			for (int j = 1; j <= 13; j++) {
				Card card = new Card(i, j);
				cardsdeck.add(card);
			}
		}
	}

	/** Drar det översta kortet i kortleken. */
	public Card getCard() {

		int getArandomCard = rand.nextInt(cardsdeck.size());
		return cardsdeck.remove(getArandomCard);
	}

	/** Undersöker om det finns fler kort i kortleken. */
	public boolean moreCards() {
		return !cardsdeck.isEmpty();
	}

}
