package main.java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dealer {

    private static final int handSize = 5;
    private String[] cardArray = new String[handSize*2];
    private Hand playerOne;
	private Hand playerTwo;
	private String cards;

    public Dealer(){
        getCards();
        createCardArray();
        dealCards();
        findWinner();
    }

    public void getCards(){
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = "";

		try {
			inputLine = input.readLine();
			this.cards = inputLine;
			System.out.println(inputLine);
		} 
		catch (IOException e) {
			System.out.print("Input Error!");
			e.printStackTrace();
		}

	}

    public void createCardArray() {
		this.cardArray = cards.split(" ");	
		System.out.println(Arrays.asList(cardArray));

	}

    public void dealCards() {
		String[] cardsToDeal = new String[5] ;
		
		for (int i = 0; i < handSize; i++) {
			cardsToDeal[i] = cardArray[i];	
		}
		System.out.println(Arrays.asList(cardsToDeal));
		
		playerOne = new Hand(cardsToDeal);
		
		for (int i = 5; i < (handSize*2); i++) {
			cardsToDeal[i-handSize] = cardArray[i];
		}
		
		System.out.println(Arrays.asList(cardsToDeal));
		playerTwo = new Hand(cardsToDeal);
		
	}

    public void findWinner(){
		int playerOneRank = playerOne.getHandRankValue();
		int playerTwoRank = playerTwo.getHandRankValue();

		int playerOneHighCard = playerOne.getHighestCardValue();
		int playerTwoHighCard = playerTwo.getHighestCardValue();

		if (playerOneRank == playerTwoRank){
			if(playerOneHighCard > playerTwoHighCard){
				System.out.println("Player One Wins");
			}
			else{
				System.out.println("Player Two Wins");	
			}
		}

		else if ( playerOneRank > playerTwoRank){
			System.out.println("Player One Wins");
		}

		else{
			System.out.println("Player Two Wins");
		}

	}
    
}
