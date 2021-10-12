package blackJackmodule;
import java.util.*;

public class blackJackMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String command = null;
		String player = null;
		String update = null;
		System.out.println("Welcome to BlackJack \n\n");

		System.out.print("Enter player name: ");
		player = scan.next();

		System.out.print("Type Hit to start the game: ");
		command = scan.next();

		deck d1 = new deck();
		Cards c1 = new Cards();
		Player p1 = new Player(player, d1, c1);
		BlackJack bj = new BlackJack(p1);
		p1.getDeck().createDeck();

		for(int i=0; i<2; i++) {
			bj.addPlayer(p1);
			while(command.equals("Hit")) {

				System.out.println("Card drawn: "+ p1.getCards().getCard());
				p1.getCards().getValue(p1.getCards().getCard());
				p1.getCards().addCard(p1.getCards().getCard());


				if(p1.getCards().getScore() ==21) {
					System.out.println(p1.getName() +" got a blackJack!");
					update = "BlackJack";
					break;
				}
				
				else if(p1.getCards().getScore()>21) {
					System.out.println(p1.getName() +" got bust!");
					update = "Bust";
					p1.getCards().setScore();
					System.out.println("Score is: " +p1.getCards().getScore() +"\n");
					break;
				}
				
				System.out.println("Score is: " +p1.getCards().getScore() +"\n");

				System.out.println("Hit or Stand: ");
				command = scan.next();

				if(!command.equals("Hit")) {
					System.out.println("Score is: " +p1.getCards().getScore());
					System.out.println("Used cards: "+Arrays.toString(c1.getUsedCards()) +"\n");
					p1.updateString(update);
					
				}
				System.out.println();

			}
			if(i==0) {
				System.out.println("Dealer playing");
				d1 = new deck();
				c1 = new Cards();
				p1 = new Player("dealer", d1, c1);
				player = "Dealer";		

				p1.getDeck().createDeck();

				System.out.print("Type Hit to start the game: ");
				command = scan.next();
			}
			
		}
		
		
		
		if(bj.getPlayer()[0].getCards().getScore()>bj.getPlayer()[1].getCards().getScore()) {
			
			if(bj.getPlayer()[0].getUpdate() == "BlackJack") {
				System.out.println("Player " +bj.getPlayer()[0].getName() +" has won because they got a BlackJack!");
			}
			else {
				System.out.println("Player " +bj.getPlayer()[0].getName() +" has won with a score of " +bj.getPlayer()[0].getCards().getScore());
			}
		}
		else if(bj.getPlayer()[0].getCards().getScore()<bj.getPlayer()[1].getCards().getScore()) {
			
			if(bj.getPlayer()[1].getUpdate() == "BlackJack") {
				System.out.println("Dealer has won because they got a BlackJack!");
			}
			else {
				System.out.println("Dealer has won with a score of " +bj.getPlayer()[1].getCards().getScore());
			}
		}
		else {
			System.out.println("Both individuals had same score of "+bj.getPlayer()[0].getCards().getScore() +". Tied round");
		}
			
		
		
		scan.close();
	}

}
