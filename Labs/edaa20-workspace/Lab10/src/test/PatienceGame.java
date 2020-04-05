package test;

import java.util.ArrayList;
import cards.Card;
import cards.CardWindow;
import cards.Deck;

public class PatienceGame {

	public static void main(String[] args) {
		int counter = 3;
		Deck deck = new Deck();
		ArrayList<Card> list = new ArrayList<Card>();
		while (deck.moreCards() && counter == 3) {
			counter = 0;
			for (int i = 1; i <= 3; i++) {
				Card card = deck.getCard();
				list.add(card);
				if (card.getRank() == i || !deck.moreCards()) {
					break;
				}
				counter++;
			}
		}
		CardWindow w = new CardWindow(4, 13, "Card deck");
		w.displayCards(list);
	}
}
