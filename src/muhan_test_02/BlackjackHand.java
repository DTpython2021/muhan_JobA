package muhan_test_02;

import java.awt.Graphics;
import java.util.List;

public class BlackjackHand extends Hand {
	private static final int BOARD_SIZE = 2;

	public BlackjackHand(Deck deck) {
		super(BOARD_SIZE, deck);
	}

	public boolean won(Hand other) {
		if (bust())
			return false;
		else if (other.bust())
			return true;
		else if (this.score() > other.score())
			return true;
		return false;
	}

	public int score() {
		boolean ace = false;
		int sc = 0;
		for (int i = 0; i < super.size(); i++) {
			if (super.cardAt(i).rank() == "ace") {
				ace = true;
			}
			sc += super.cardAt(i).pointValue();
		}
		if (ace == true && sc > 21) {
			sc = 0;
			for (int i = 0; i < super.size(); i++) {
				if (super.cardAt(i).rank() == "ace") {
					sc += 1;
				} else
					sc += super.cardAt(i).pointValue();
			}
		}
		return sc;
	}

	public boolean twentyOne() {
		if (score() == 21)
			return true;
		return false;
	}

	public boolean bust() {
		if (score() > 21)
			return true;
		return false;
	}

	public void draw(Graphics window, int x, int y, boolean isDealer) {
		if (isDealer) {
			super.cardAt(0).draw(window, x, y, true);
			for (int i = 1; i < super.size(); i++) {
				super.cardAt(i).draw(window, x + i * 100, y, false);
			}
		} else {
			for (int i = 0; i < super.size(); i++) {
				super.cardAt(i).draw(window, x + i * 100, y, false);
			}
		}
	}
}
