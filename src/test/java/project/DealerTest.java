package project;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Dealer class by 
 * checking that the hand of greater value
 * wins.
 * 
 * @author Daisy Oira
 */
public class DealerTest {
    @Test
    void testHighCardAgainstOnePair() {
        Dealer dealer = new Dealer("AS AC QH TD 8S 6H TD 9D AS JH");
        assertEquals("Player One Wins", dealer.getWinner());

    }

    @Test
    void testOnePairAgainstTwoPair() {
        Dealer dealer = new Dealer("AH AS KC KH 9S AS AC QH TD 8S");
        assertEquals("Player One Wins", dealer.getWinner());

    }

    @Test
    void testTwoPairAgainstThreeOfAKind() {
        Dealer dealer = new Dealer("2S 2D 2C QD 10H AH AS KC KH 9S");
        assertEquals("Player One Wins", dealer.getWinner());

    }

    @Test
    void testStraightAgainstThreeOfAKind(){
        Dealer dealer = new Dealer("5H 6D 7D 8C 9S 2S 2D 2C QD 10H");
        assertEquals("Player One Wins", dealer.getWinner());

    }

    @Test
    void testFlushAgainstStraight(){
        Dealer dealer = new Dealer("AH JH 9H 6H 3H 5H 6D 7D 8C 9S");
        assertEquals("Player One Wins", dealer.getWinner());
    }

    @Test
    void testFullHouseAgainstFlush(){
        Dealer dealer = new Dealer("QS QD QH JC JD AH JH 9H 6H 3H");
        assertEquals("Player One Wins", dealer.getWinner());
    }

    @Test
    void testFourOfAKindAgainstFullHouse(){
        Dealer dealer = new Dealer("AH AD AC AS 9S QS QD QH JC JD");
        assertEquals("Player One Wins", dealer.getWinner());
    }

    @Test
    void testStraightFlushAgainstFourOfAKind(){
        Dealer dealer = new Dealer("9D 8D 7D 6D 5D AH AD AC AS 9S");
        assertEquals("Player One Wins", dealer.getWinner());
    }

    @Test
    void testRoyalFlushAgainstStraightFlush(){
        Dealer dealer = new Dealer("TS JS QS KS AS 9D 8D 7D 6D 5D");
        assertEquals("Player One Wins", dealer.getWinner());
    }

    @Test
    void testSameHandDifferentHighCard(){
        Dealer dealer = new Dealer("2H 2D 4C 4D 4S 3C 3D 3S 9S 9D");
        assertEquals("Player One Wins", dealer.getWinner()); 
    }


    

    
}
