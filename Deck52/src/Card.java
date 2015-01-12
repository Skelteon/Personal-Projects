
public class Card {
	private Suit my_suit;
	
	private Rank my_rank;
	
	public Card(Suit suit, Rank rank) {
		my_suit = suit;
		my_rank = rank;
	}
	
	public Suit getSuit() {
		return my_suit;
	}
	
	public Rank getRank() {
		return my_rank;
	}
}
