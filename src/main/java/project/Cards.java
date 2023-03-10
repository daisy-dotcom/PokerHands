package project;
import java.util.*;
import java.util.stream.*;

/**
 * This class stores the cards suit and
 * values by mapping them to a corresponding 
 * integer.
 * 
 * @author Daisy Oira
 */
public class Cards {
	
	private static final Map<String, Integer> suitsAndValues = new HashMap<String, Integer>() {{
		put("A", 14);
		put("K", 13);
		put("Q", 12);
		put("J", 11 );
		put("T", 10);
		put("9", 9);
		put("8", 8);
		put("7", 7);
		put("6", 6);
		put("5", 5);
		put("4", 4);
		put("3", 3);
		put("2", 2);
	}};
	protected ArrayList<Integer> cardValues = new ArrayList<Integer>();
	protected ArrayList<String> cardSuits = new ArrayList<String>();
	
	public Cards(ArrayList<String> cards) {
		setValuesAndSuits(cards);	
	}

	public int getCardValue(String cardNumber) {
		Integer value = suitsAndValues.get(cardNumber);
		
		if (value == null) {
			return -1;
		}
		else {
			return value;
		
		}
	}

	public ArrayList<Integer> getValuesArray(){
		return cardValues;
	}

	public ArrayList<String> getSuitsArray(){
		return cardSuits;
	}

	public void setValuesAndSuits(ArrayList<String> cards) {
		
		cards.forEach(element -> {
		cardValues.add(getCardValue(element.substring(0,1)));
		cardSuits.add(element.substring(1,2));
		});
		
	}
	
}
	
