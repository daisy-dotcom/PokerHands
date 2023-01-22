import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*import java.util.Arrays;
import java.util.Collections;*/
public class Cards {
	
	private static int arrayLength = 5;
	private Hand playerOne;
	private Hand playerTwo;
	private String cards;
	private String[] cardArray = new String[10];
	
	public Cards() {
		getCards();
		/*this.cards = cards;*/
		createCardArray(cards);
		dealCards();
		
	}

	public void getCards(){
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = "";

		try {
			inputLine = input.readLine();
			cards = inputLine;
			System.out.println(inputLine);
		} 
		catch (IOException e) {
			System.out.print("Input Error!");
			e.printStackTrace();
		}

	}
	
	public void createCardArray(String cards) {
		this.cardArray = cards.split(" ");	
		System.out.println(Arrays.asList(cardArray));

	}
	
	public void dealCards() {
		String[] cardsToDeal = new String[5] ;
		
		for (int i = 0; i < arrayLength; i++) {
			cardsToDeal[i] = cardArray[i];	
		}
		System.out.println(Arrays.asList(cardsToDeal));
		
		playerOne = new Hand(cardsToDeal);
		
		for (int i = 5; i < (arrayLength*2); i++) {
			cardsToDeal[i-arrayLength] = cardArray[i];
		}
		
		System.out.println(Arrays.asList(cardsToDeal));
		playerTwo = new Hand(cardsToDeal);
		
	}
	
	
}
	
