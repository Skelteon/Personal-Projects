import java.util.Stack;


public class Deck {	
	private Stack<Card> my_deck;
	
	public Deck(boolean empty) {
		my_deck = new Stack<Card>();

		if (!empty) {
			addCards();
		}
	}

	private void addCards() {
		for (Suit s: Suit.values()) {
			for (Rank r: Rank.values()) {
				my_deck.add(new Card(s, r));
			}
		}
	}
}
