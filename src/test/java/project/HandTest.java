package project; 

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


/*import project.Hand;*/

public class HandTest {

    @Test
    public void testIsRoyalFlush() {
        String[] cards = {"TS","JS","QS","KS","AS"};
        Hand hand = new Hand(cards);
        assertEquals(10, hand.getHandRankValue());
    }

    @Test
    public void testIsStraightFlush() {
        String[] cards = {"9D","8D", "7D","6D","5D"};
        Hand hand = new Hand(cards);
        assertEquals(9, hand.getHandRankValue());
    }

    @Test
    public void testIsFourOfAKind() {
        String[] cards = {"AH","AD","AC","AS","9S"};
        Hand hand = new Hand(cards);
        assertEquals(8, hand.getHandRankValue());
    }

    @Test
    public void testIsFullHouse() {
        String[] cards = {"QS","QD","QH","JC","JD"};
        Hand hand = new Hand(cards);
        assertEquals(7, hand.getHandRankValue());
    }

    @Test
    public void testIsFlush() {
        String[] cards = {"AH","JH", "9H","6H","3H"};
        Hand hand = new Hand(cards);
        assertEquals(6, hand.getHandRankValue());
    }

    @Test
    public void testIsStraight() {
        String[] cards = {"5H","6D", "7D","8C","9S"};
        Hand hand = new Hand(cards);
        assertEquals(5, hand.getHandRankValue());
    }


    @Test
    public void testIsThreeOfAKind() {
        String[] cards = {"2S","2D", "2C","QD","10H"};
        Hand hand = new Hand(cards);
        assertEquals(4, hand.getHandRankValue());
    }

    @Test
    public void testIsTwoPair() {
        String[] cards = {"AH","AS","KC","KH","9S"};
        Hand hand = new Hand(cards);
        assertEquals(3, hand.getHandRankValue());
    }

    @Test
    public void testIsOnePair() {
        String[] cards = {"AS","AC","QH","TD","8S"};
        Hand hand = new Hand(cards);
        assertEquals(2, hand.getHandRankValue());
    }

    @Test
    public void testIsHighCard() {
        String[] cards = {"6H","TD", "9D","AS","JH"};
        Hand hand = new Hand(cards);
        assertEquals(1, hand.getHandRankValue());

    }
}
