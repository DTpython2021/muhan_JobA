package muhan_test_02;

import java.util.List;
import java.util.ArrayList;

public class Deck implements DeckInterface {

	private List<Card> cards = new ArrayList<Card>();

	private int size;

	public Deck(String[] ranks, String[] suits, int[] values) {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				cards.add(new Card(ranks[j], suits[i], values[j]));
				size++;
			}
		}

		shuffle();
	}

	public int size() {
		return size;
	}

	public void shuffle() {
		int rand;
		Card tmp;
		

		for (int i = size - 1; i >= 0; i--) {
			rand = (int) (Math.floor(Math.random() * (size - 1)));
			tmp = cards.get(i);
			cards.set(i, cards.get(rand));
			cards.set(rand, tmp);
		}
	}

	public Card deal() {
		if (size == 0)
			return null;
		else
			size--;
		return cards.get(size);

	}

	@Override
	public String toString() {
		String rtn = "size = " + size + "\n";
		for (int i = 0; i < size; i++) {
			rtn += cards.get(i) + "\n";

		}

		rtn = rtn + "\n";
		return rtn;
	}
}
