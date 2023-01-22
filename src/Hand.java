import java.util.*;

public class Hand{
	
	private static int arrayLength = 5;
	private static Map<String, Integer> cardsAndValues = new HashMap<String, Integer>() {{
		put("A", 13);
		put("K", 12);
		put("Q", 11);
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
	private Integer[] cardValues = new Integer[arrayLength];
	private String[] cardSuits = new String [arrayLength];
	private HashMap<Integer, Integer> cardMap = new HashMap<>();
	private TreeSet<Integer> cardValueSet ;
	private TreeSet<String> cardSuitsSet ;
	private int highestCardValue;

	
	
	public Hand(String[] cards) {
		setCardValuesAndSuits(cards);
		setCardValuesAndSuitsSet();
		currentHand();
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
	
	public void setCardValuesAndSuits(String[] cards) {
		for (int i = 0; i < arrayLength; i++) {
			String[] splitCard = cards[i].split("(?=\\D)");
			
			cardValues[i] = cardsAndValues.get(splitCard[0]);
			cardSuits[i] = splitCard[1];

			setCardMap(cardValues[i]);

			/*System.out.println(cardValues[i]);
			System.out.println(cardSuits[i]);*/

		}	

		/*for (Map.Entry<Integer,Integer
		> entry : cardMap.entrySet()){
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    	}*/
	}

	public void setCardMap(Integer i){
		Integer initialValue = cardMap.get(i);

		if (initialValue == null){
			cardMap.put(i, 1);
		}
		else{
			cardMap.put(i , initialValue+1);
		}

	}

	public void setHighestCardValue(int i){

		for (Integer cardValue : cardValueSet){
			int highestCardValue = cardMap.get(cardValue);
			/*System.out.println("Current card value: " + String.parseToString(cardValue) + );*/
			if ( highestCardValue == i){
				this.highestCardValue = highestCardValue;
			}
		}

	}
	public void setCardValuesAndSuitsSet(){
		cardValueSet = new TreeSet<>(Arrays.asList(cardValues));
		cardSuitsSet = new TreeSet<>(Arrays.asList(cardSuits));

		/*System.out.println(cardValueSet);
		System.out.println(cardSuitsSet);
		for (Integer i : cardValueSet){
			System.out.println(i);
		}

		for (String i : cardSuitsSet){
			System.out.println(i);
		}*/
	}
	
	
	
	public void isHighCard() {
		setHighestCardValue(1);
	}
	
	
	public boolean isOnePair() {
		Integer sizeCardValueSet = cardValueSet.size();

		if ( sizeCardValueSet == 4){
			setHighestCardValue(2);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	public boolean isTwoPair() {
		Integer sizeCardValueSet = cardValueSet.size();

		if ( sizeCardValueSet == 3){
			setHighestCardValue(2);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isThreeOfAKind() {
		Integer numberOfSuits = cardSuitsSet.size();
		Integer sizeCardValueSet = cardValueSet.size();

		if ( sizeCardValueSet == 3 && numberOfSuits >= 3){
			setHighestCardValue(3);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isStraight() {
		Integer firstCard = cardValueSet.first();
		Integer lastCard = cardValueSet.last();
		Integer cardValueDifference = lastCard - firstCard;
		Integer numberOfSuits = cardSuitsSet.size();
		Integer sizeCardValueSet = cardValueSet.size();

		if ( sizeCardValueSet == 5 && cardValueDifference ==  sizeCardValueSet-1 && numberOfSuits > 1){
			setHighestCardValue(1);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	public boolean isFlush() {
		Integer numberOfSuits = cardSuitsSet.size();

		if (numberOfSuits == 1){
			setHighestCardValue(1);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isFullHouse() {
		Integer sizeCardValueSet = cardValueSet.size();

		if ( sizeCardValueSet == 2 ){
			setHighestCardValue(3);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isFourOfAKind() {
		Integer numberOfSuits = cardSuitsSet.size();
		Integer sizeCardValueSet = cardValueSet.size();

		if ( sizeCardValueSet == 2 && numberOfSuits == 4){
			setHighestCardValue(4);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isStraightFlush() {
		Integer firstCard = cardValueSet.first();
		Integer lastCard = cardValueSet.last();
		Integer cardValueDifference = lastCard - firstCard;
		Integer numberOfSuits = cardSuitsSet.size();
		Integer sizeCardValueSet = cardValueSet.size();

		if ( sizeCardValueSet == 5 && cardValueDifference ==  sizeCardValueSet -1 && numberOfSuits == 1){
			setHighestCardValue(1);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isRoyalFlush() {

		Integer firstCard = cardValueSet.iterator().next();
		Integer numberOfSuits = cardSuitsSet.size();

		if ( firstCard == 10 && numberOfSuits ==1){
			return true;
		}
		else{
			return false;
		}
	
	}

	public void currentHand(){
		if (isRoyalFlush()){
			System.out.println("Royal Flush");
		}
		else if (isStraightFlush()){
			System.out.println("Straight Flush");
		}
		else if (isFourOfAKind()){
			System.out.println("Four of a Kind");
		}
		else if (isFullHouse()){
			System.out.println("Full House");
		}
		else if (isFlush()){
			System.out.println("Flush");
		}
		else if (isStraight()){
			System.out.println("Straight");
		}
		else if (isThreeOfAKind()){
			System.out.println("Three of A Kind");
		}
		else if (isTwoPair()){
			System.out.println("Two Pair");
		}
		else if (isOnePair()){
			System.out.println("One Pair");
		}
		else{
			System.out.println("High Card");
		}

		System.out.println(highestCardValue);
	}
	
		
}
