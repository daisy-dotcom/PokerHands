package project;
import java.util.*;

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
		put("3", 3 );
		put("2", 2);
	}};
	protected ArrayList<Integer> cardValues = new ArrayList<Integer>();
	protected ArrayList<String> cardSuits = new ArrayList<String>();
	
	public Cards(String[] cards) {
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

	public void setValuesAndSuits(String[] cards) {
		for (int i = 0; i < cards.length; i++) {
			String[] splitCard = cards[i].split("(?=\\D)");
			
			cardValues.add(getCardValue(splitCard[0]));
			cardSuits.add(splitCard[1]);
			/*setCardMap(cardValues[i]);*/
		}	

		/*System.out.println(cardValues);
		System.out.println(cardSuits);*/

	}
	
}
	
