package test;

import cards.Card;
import cards.Deck;

public class ManyPatienceGames {
	private static final int NBR_ITERATIONS = 1000000;

	public static void main(String[] args) {
		int counter;
		int hasWon = 0;
		for (int nbr = 0; nbr < NBR_ITERATIONS; nbr++) {
			counter = 3;
			Deck deck = new Deck();
			while (deck.moreCards() && counter == 3) {
				counter = 0;
				for (int i = 1; i <= 3; i++) {
					Card card = deck.getCard();
					if (card.getRank() == i || !deck.moreCards()) {
						break;
					}
					counter++;
				}
			}
			if (!deck.moreCards()) {
				hasWon++;
			}
		}
		double per = (double) hasWon / (double) NBR_ITERATIONS;
		System.out.printf("number of winnings is %d out of %d\nand the percentage of winnings is %f", hasWon,
				NBR_ITERATIONS, per);
	}
}
