package test;

import cards.Hand;
import cards.Deck;

import java.awt.Color;

import cards.CardWindow;

public class HandGame {

	public static void main(String[] args) {
		int cardsSum, nbrHandCards = 3;
		boolean ace14 = false;

		Hand hand = new Hand();
		Deck deck = new Deck();
		CardWindow w = new CardWindow(4, 13, "Hand Game");
		for (int i = 0; i < nbrHandCards; i++)
			hand.insert(deck.getCard());
		hand.display(w);
		cardsSum = hand.rankSum(ace14);
		w.moveTo(350, 200);
		w.writeText("your cards sum is : " + Integer.toString(cardsSum));
		w.moveTo(385, 180);
		if (cardsSum <= 21) {
			w.setLineColor(Color.green);
			w.writeText("you won");
		} else {
			w.setLineColor(Color.red);
			w.writeText("you lost");
		}
	}
}
