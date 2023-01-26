package main.java;
import java.util.*;

public class Hand extends Cards {
	
	/*private static int arrayLength = 5;*/
	private static final Map<String, Integer> handRank = new HashMap<String, Integer> (){{
		put("Royal Flush", 10);
		put("Straight Flush", 9);
		put("Four of a Kind", 8);
		put("Full House", 7);
		put("Flush", 6);
		put("Straight", 5);
		put("Three of a Kind", 4);
		put("Two Pair Flush", 3);
		put("One Pair", 2);
		put("High Card", 1);
	}};

	private HashMap<Integer, Integer> cardMap = new HashMap<>();
	private TreeSet<Integer> cardValueSet ;
	private TreeSet<String> cardSuitsSet ;
	private int highestCardValue;
	private int handRankValue;

	
	
	public Hand(String[] cards) {
		super(cards);
		setCardMap();
		setCardValuesAndSuitsSet();
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

		System.out.println(cardValueSet);
		System.out.println(cardSuitsSet);
		/*for (Integer i : cardValueSet){
			System.out.println("card value set");
			System.out.println(i);
		}

		for (String i : cardSuitsSet){
			System.out.println("card suit set");
			System.out.println(i);
		}*/
	}
	
	public void setHandRank(String handName){
		handRankValue = handRank.get(handName);

	}
	
	public boolean hasThreeOccurences(){

		for (Integer cardValue : cardValueSet){
			int numOfOccurences = cardMap.get(cardValue);
			/*System.out.println("Current card value: " + cardValue);*/
			if ( numOfOccurences == 3){
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
		Integer sizeCardValueSet = cardValueSet.size();

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
		Integer sizeCardValueSet = cardValueSet.size();

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
		Integer numberOfSuits = cardSuitsSet.size();
		Integer sizeCardValueSet = cardValueSet.size();

		if ( sizeCardValueSet == 3 && numberOfSuits >= 3 && hasThreeOccurences()){
			setHighestCardValue(3);
			setHandRank("Three of a Kind");
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
			setHandRank("Straight");
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
			setHandRank("Flush");
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
			setHandRank("Full House");
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
			setHandRank("Four of a Kind");
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
			setHandRank("Straight Flush");
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean isRoyalFlush() {

		Integer firstCard = cardValueSet.first();
		Integer numberOfSuits = cardSuitsSet.size();

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
