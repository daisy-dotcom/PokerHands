package project; 

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * This class tests the Hands Class by
 * checking that each hand is assigned
 * the correct value.
 * 
 * @author Daisy Oira
 */
public class HandTest {

    @Test
    public void testIsRoyalFlush() {
        ArrayList<String> cards = new ArrayList<>(
            Arrays.asList("TS","JS","QS","KS","AS"));
        Hand hand = new Hand(cards);
        assertEquals(10, hand.getHandRankValue());
    }

    @Test
    public void testIsStraightFlush() {
        ArrayList<String> cards = new ArrayList<>(
            Arrays.asList("9D","8D", "7D","6D","5D"));
        Hand hand = new Hand(cards);
        assertEquals(9, hand.getHandRankValue());
    }

    @Test
    public void testIsFourOfAKind() {
        ArrayList<String> cards = new ArrayList<>(
            Arrays.asList("AH","AD","AC","AS","9S"));
        Hand hand = new Hand(cards);
        assertEquals(8, hand.getHandRankValue());
    }

    @Test
    public void testIsFullHouse() {
        ArrayList<String> cards = new ArrayList<>(
            Arrays.asList("QS","QD","QH","JC","JD"));
        Hand hand = new Hand(cards);
        assertEquals(7, hand.getHandRankValue());
    }

    @Test
    public void testIsFlush() {
        ArrayList<String> cards = new ArrayList<>(
            Arrays.asList("AH","JH", "9H","6H","3H"));
        Hand hand = new Hand(cards);
        assertEquals(6, hand.getHandRankValue());
    }

    @Test
    public void testIsStraight() {
        ArrayList<String> cards = new ArrayList<>(Arrays.asList("5H","6D", "7D","8C","9S"));
        Hand hand = new Hand(cards);
        assertEquals(5, hand.getHandRankValue());
    }


    @Test
    public void testIsThreeOfAKind() {
        ArrayList<String> cards = new ArrayList<>(
            Arrays.asList("2S","2D", "2C","QD","10H"));
        Hand hand = new Hand(cards);
        assertEquals(4, hand.getHandRankValue());
    }

    @Test
    public void testIsTwoPair() {
        ArrayList<String> cards = new ArrayList<>(
            Arrays.asList("AH","AS","KC","KH","9S"));
        Hand hand = new Hand(cards);
        assertEquals(3, hand.getHandRankValue());
    }

    @Test
    public void testIsOnePair() {
        ArrayList<String> cards = new ArrayList<>(
            Arrays.asList("AS","AC","QH","TD","8S"));
        Hand hand = new Hand(cards);
        assertEquals(2, hand.getHandRankValue());
    }

    @Test
    public void testIsHighCard() {
        ArrayList<String> cards = new ArrayList<>(
            Arrays.asList("6H","TD", "9D","AS","JH"));
        Hand hand = new Hand(cards);
        assertEquals(1, hand.getHandRankValue());

    }
}
