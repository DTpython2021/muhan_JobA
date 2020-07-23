package com.muhan.joba;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private List<Card> cards = new ArrayList<Card>();

	private static final boolean I_AM_DEBUGGING = false;

	public Hand(int size, Deck deck) {

		dealMyCards(deck);
	}

	public void newGame(Deck deck) {
		deck.shuffle();
		cards.clear();
		dealMyCards(deck);
	}

	public int size() {
		return cards.size();
	}

	public boolean isEmpty() {
		for (int k = 0; k < cards.size(); k++) {
			if (cards.get(k) != null) {
				return false;
			}
		}
		return true;
	}

	public void deal(Deck deck) {
		cards.add(deck.deal());
	}

	public int deckSize(Deck deck) {
		return deck.size();
	}

	public Card cardAt(int k) {
		return cards.get(k);
	}

	public List<Integer> cardIndexes() {
		List<Integer> selected = new ArrayList<Integer>();
		for (int k = 0; k < cards.size(); k++) {
			if (cards.get(k) != null) {
				selected.add(new Integer(k));
			}
		}
		return selected;
	}

	public String toString() {
		String s = "";
		for (int k = 0; k < cards.size(); k++) {
			s = s + k + ": " + cards.get(k).toString() + "\n";
		}
		return s;
	}

	public abstract boolean won(Hand other);

	public abstract int score();

	public abstract boolean twentyOne();

	public abstract boolean bust();

	public abstract void draw(Graphics window, int x, int y, boolean isDealer);

	private void dealMyCards(Deck deck) {
		for (int k = 0; k < 2; k++) {

			cards.add(deck.deal());
		}
	}
}
