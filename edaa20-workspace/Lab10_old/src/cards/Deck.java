package cards;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private Random random;

	/** Skapar en blandad kortlek med 52 kort. */
	public Deck() {
		cards = new ArrayList<Card>();
		random = new Random(51);
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards.add(new Card(suit, rank));
			}
		}
	}

	/** Drar det översta kortet i kortleken. */
	public Card getCard() {
		return cards.remove(random.nextInt(cards.size()));
	}

	/** Undersöker om det finns fler kort i kortleken. */
	public boolean moreCards() {
		return !cards.isEmpty();
	}

}
