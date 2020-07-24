package muhan_test_02;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {

	private String suit;

	private String rank;

	private int pointValue;
	private Image image;

	public Card(String cardRank, String cardSuit, int cardPointValue) {
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}

	public String suit() {
		return suit;
	}

	public String rank() {
		return rank;
	}

	public int pointValue() {
		return pointValue;
	}

	public void draw(Graphics window, int x, int y, boolean faceDown) {
		try {
			if (faceDown)
				image = ImageIO.read(new File("src/image/back1.JPG"));
			else
				image = ImageIO.read(new File("src/image/" + rank + suit + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		window.drawImage(image, x + 200, y + 70, 90, 120, null);
	}

	public boolean matches(Card otherCard) {
		if (otherCard.suit == suit && otherCard.rank == rank && otherCard.pointValue == pointValue)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}
