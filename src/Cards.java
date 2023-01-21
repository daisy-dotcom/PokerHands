import java.util.*;
/*import java.util.Arrays;
import java.util.Collections;*/
public class Cards {
	
	private static int arrayLength = 5;
	private Hand playerOne;
	private Hand playerTwo;
	private String cards;
	private String[] cardArray = new String[10];
	
	public Cards(String cards) {
		this.cards = cards;
		createCardArray(cards);
		dealCards();
		
	}
	
	public void createCardArray(String cards) {
		this.cardArray = cards.split(" ");	
	}
	
	public void dealCards() {
		String[] cardsToDeal = new String[5] ;
		
		for (int i = 0; i < arrayLength; i++) {
			cardsToDeal[i] = cardArray[i];	
		}
		
		playerOne = new Hand(cardsToDeal);
		
		for (int i = 5; i < arrayLength; i++) {
			cardsToDeal[i-arrayLength] = cardArray[i];
		}
		
		playerTwo = new Hand(cardsToDeal);
		
	}
	
	
}
	
