import java.util.*;

public class Hand{
	
	private static int arrayLength = 5;
	private static Map<String, Integer> cardsAndValues = new HashMap<String, Integer>() {{
		put("A", 13);
		put("K", 12);
		put("Q", 11);
		put("J", 11 );
		put("10",10);
		put("9", 9);
		put("8", 8);
		put("7", 7);
		put("6", 6);
		put("5", 5);
		put("4", 4);
		put("3", 3 );
		put("2", 2);
	}};
	private int cardValues []= new int [arrayLength];
	private String cardSuits []= new String [arrayLength];
	
	
	public Hand(String[] cards) {
		setCardValues(cards);
		setCardSuits(cards);	
	}
	
	public int getCardValue(String cardNumber) {
		Integer value = cardsAndValues.get(cardNumber);
		
		if (value == null) {
			return -1;
		}
		else {
			return value;
		
		}
	}
	
	public void setCardValues(String[] cards) {
		for (int i = 0; i < arrayLength; i++) {
			String[] splitValue = cards[i].split("\\D");
			
			for (String value: splitValue) {
				cardValues[i] = Integer.parseInt(value);
			}
		}
		
	}
	
	public void setCardSuits(String[] cards) {
		for (int i = 0; i < arrayLength; i++) {
			String[] splitSuit = Arrays.stream(cards[i].split("\\d"))
					.filter(s -> !s.isEmpty()).toArray(String[]::new);
			
			for (String suit: splitSuit) {
				cardSuits[i] = suit;
			}
			
		}
		
	}
	
	public boolean isHighCard() {
		
	}
	
	public boolean isOnePair() {
		
	}
	
	public boolean isTwoPair() {
		
	}
	
	public boolean isThreeOfAKind() {
		
	}
	
	public boolean isStraight() {
		
	}
	
	public boolean isFlush() {
		
	}
	public boolean isFullHouse() {
		
	}
	
	public boolean isFourOfAKind() {
		
	}
	
	public boolean isStraightFlush() {
		
	}
	
	public boolean isRoyalFlush() {
	
	}
		
		
}
