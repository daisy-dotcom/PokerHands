package project;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This class deals cards to two players,
 * determimes a winner and calculates the
 * number of times player one wins.
 * 
 * @author Daisy Oira
 */
public class Dealer {

    private static final int handSize = 5;
	private static int playerOneWins = 0;
    private String[] cardArray = new String[handSize*2];
    private Hand playerOne;
	private Hand playerTwo;
	private String cards;
	private String winner;

    public Dealer(){
        getCards();
    }

	public Dealer(String cards){
		this.cards = cards;
		createCardArray();
		dealCards();
		findWinner();
	}

    public void getCards(){
		try {
			FileReader file = new FileReader("./src/main/java/project/public/p054_poker.txt");
			BufferedReader buffer = new BufferedReader(file);
			
			String cards = null;
			
			while((cards = buffer.readLine()) != null) {
				this.cards = cards;
				createCardArray();
				dealCards();
				findWinner();				
			}
			
			if (buffer != null) {
				buffer.close();
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

    public void createCardArray() {
		this.cardArray = cards.split(" ");	
	}

    public void dealCards() {
		ArrayList<String> cardsToDeal = new ArrayList<>();
		
		for (int i = 0; i < handSize; i++) {
			cardsToDeal.add(cardArray[i]);	
		}
		
		playerOne = new Hand(cardsToDeal);
		cardsToDeal.clear();
		
		for (int i = 5; i < (handSize*2); i++) {
			cardsToDeal.add(cardArray[i]);
		}

		playerTwo = new Hand(cardsToDeal);
		
	}

	public void setWinner(String winner){
		this.winner = winner;
	}

	public String getWinner(){
		return winner;
	}

	public int getPlayerOneWins(){
		return playerOneWins;
	}

    public void findWinner(){
		int playerOneRank = playerOne.getHandRankValue();
		int playerTwoRank = playerTwo.getHandRankValue();

		int playerOneHighCard = playerOne.getHighestCardValue();
		int playerTwoHighCard = playerTwo.getHighestCardValue();

		if (playerOneRank == playerTwoRank){
			if(playerOneHighCard > playerTwoHighCard){
				setWinner("Player One Wins");
				playerOneWins++;
			}
			else{
				setWinner("Player Two Wins");	
			}
		}

		else if (playerOneRank > playerTwoRank){
			setWinner("Player One Wins");
			playerOneWins++;
			/*System.out.println("Player One Wins");*/
		}

		else{
			setWinner("Player Two Wins");
			/*System.out.println("Player Two Wins");*/
		}

	}
    
}
