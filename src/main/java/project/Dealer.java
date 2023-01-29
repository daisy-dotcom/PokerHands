package project;
import java.io.BufferedReader;
import java.io.FileReader;
/*import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;*/

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
        /*createCardArray();
        dealCards();
        findWinner();*/
    }

	public Dealer(String cards){
		this.cards = cards;
		createCardArray();
		dealCards();
		findWinner();
	}

    public void getCards(){
		/*BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String cards = "";
		System.getProperty("user.dir") + */

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

		/*try {
			inputLine = input.readLine();
			this.cards = inputLine;
			System.out.println(inputLine);
		} 
		catch (IOException e) {
			System.out.print("Input Error!");
			e.printStackTrace();
		}*/

	}

    public void createCardArray() {
		this.cardArray = cards.split(" ");	
		/*System.out.println(Arrays.asList(cardArray));*/

	}

    public void dealCards() {
		String[] cardsToDeal = new String[5] ;
		
		for (int i = 0; i < handSize; i++) {
			cardsToDeal[i] = cardArray[i];	
		}
		/*System.out.println(Arrays.asList(cardsToDeal));*/
		
		playerOne = new Hand(cardsToDeal);
		
		for (int i = 5; i < (handSize*2); i++) {
			cardsToDeal[i-handSize] = cardArray[i];
		}
		
		/*System.out.println(Arrays.asList(cardsToDeal));*/
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
				/*System.out.println("Player One Wins");*/
			}
			else{
				setWinner("Player Two Wins");	
				/*System.out.println("Player Two Wins");*/
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
