package blackJackmodule;

public class Player {
	private String name;
	private deck newDeck;
	private Cards newCard;
	private String str;

	public Player(String s, deck d, Cards c) {
		this.name = s;
		this.newDeck = d;
		this.newCard = c;
		this.str = "";
	}
	
	
	public deck getDeck() {
		return this.newDeck;
	}
	
	public Cards getCards() {
		return this.newCard;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUpdate() {
		return this.str;
	}
	
	public void updateString(String s) {
		this.str = s;
	}













}
