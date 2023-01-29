package project;
import java.util.*;

public class Hand extends Cards {

	private static final Map<String, Integer> handRank = new HashMap<String, Integer> (){{
		put("Royal Flush", 10);
		put("Straight Flush", 9);
		put("Four of a Kind", 8);
		put("Full House", 7);
		put("Flush", 6);
		put("Straight", 5);
		put("Three of a Kind", 4);
		put("Two Pair", 3);
		put("One Pair", 2);
		put("High Card", 1);
	}};

	private HashMap<Integer, Integer> cardMap = new HashMap<>();
	private TreeSet<Integer> cardValueSet ;
	private TreeSet<String> cardSuitsSet ;
	private int highestCardValue;
	private int handRankValue;

	/* Comparison Variables */
	private Integer firstCard;
	private Integer lastCard;
	private Integer cardValueDifference;
	private Integer numberOfSuits;
	private Integer sizeCardValueSet;

	public Hand(String[] cards) {
		super(cards);
		setCardMap();
		setCardValuesAndSuitsSet();
		setComparisonVariables();
		currentHand();
	}

	public int getHighestCardValue(){
		return highestCardValue;
	}

	public int getHandRankValue(){
		return handRankValue;
	}

	public void setCardMap(){
		ArrayList<Integer> cardValues = getValuesArray();
		
		for (Integer value : cardValues){
			Integer initialValue = cardMap.get(value);

			if (initialValue == null){
				cardMap.put(value, 1);
			}
			else{
				cardMap.put(value, initialValue+1);
			}

		}

	}

	public void setHighestCardValue(int i){
		
		for (Integer cardValue : cardValueSet){
			int numOfOccurences = cardMap.get(cardValue);
		
			if ( numOfOccurences == i){
				this.highestCardValue = cardValue;
			}
		}

	}

	public void setCardValuesAndSuitsSet(){
		cardValueSet = new TreeSet<>(getValuesArray());
		cardSuitsSet = new TreeSet<>(getSuitsArray());

		/*System.out.println(cardValueSet);
		System.out.println(cardSuitsSet);*/
	}
	
	public void setHandRank(String handName){
		handRankValue = handRank.get(handName);

	}

	public void setComparisonVariables(){
		firstCard = cardValueSet.first();
		lastCard = cardValueSet.last();
		cardValueDifference = lastCard - firstCard;
		numberOfSuits = cardSuitsSet.size();
		sizeCardValueSet = cardValueSet.size();
		
	}
	
	public boolean hasNumOccurences(int num){

		for (Integer cardValue : cardValueSet){
			int numOfOccurences = cardMap.get(cardValue);
			if ( numOfOccurences == num){
				return true;
			}
		}
		return false;

	}
	
	public void isHighCard() {
		setHighestCardValue(1);
		setHandRank("High Card");
	}
	
	public boolean isOnePair() {

		if ( sizeCardValueSet == 4){
			setHighestCardValue(2);
			setHandRank("One Pair");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	public boolean isTwoPair() {

		if ( sizeCardValueSet == 3){
			setHighestCardValue(2);
			setHandRank("Two Pair");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isThreeOfAKind() {

		if ( sizeCardValueSet == 3 && numberOfSuits >= 3 && hasNumOccurences(3)){
			setHighestCardValue(3);
			setHandRank("Three of a Kind");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isStraight() {

		if ( sizeCardValueSet == 5 && cardValueDifference ==  sizeCardValueSet-1 && numberOfSuits > 1){
			setHighestCardValue(1);
			setHandRank("Straight");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	public boolean isFlush() {

		if (numberOfSuits == 1){
			setHighestCardValue(1);
			setHandRank("Flush");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isFullHouse() {

		if ( sizeCardValueSet == 2 ){
			setHighestCardValue(3);
			setHandRank("Full House");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isFourOfAKind() {

		if ( sizeCardValueSet == 2 && numberOfSuits == 4 && hasNumOccurences(4)){
			setHighestCardValue(4);
			setHandRank("Four of a Kind");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isStraightFlush() {

		if ( sizeCardValueSet == 5 && cardValueDifference ==  sizeCardValueSet -1 && numberOfSuits == 1){
			setHighestCardValue(1);
			setHandRank("Straight Flush");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isRoyalFlush() {
		
		if ( firstCard == 10 && numberOfSuits == 1){
			setHighestCardValue(1);
			setHandRank("Royal Flush");
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
			isHighCard();
			System.out.println("High Card");
		}

		System.out.println(highestCardValue);
	}
	
		
}
