package problem54;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PokerTest {
  @Nested
  class SinglePair{
    @Test
    public void testSinglePair(){
      Poker p = new Poker("1C 1C 2D 3E 5E 3C 2C 6E 4E 7E");
      assertEquals(1,p.checkOnePair(p.A));
    }
    @Test
    public void testfalseSinglePair(){
      Poker p = new Poker("1C 1C 2D 3E 5E 3C 2C 6E 4E 7E");
      assertEquals(-1, p.checkOnePair(p.B));
    }
  }
  @Nested
  class DoublePair{
    @Test
    public void testDoublePair(){
      Poker p = new Poker("1C 1C 2D 2E 5E 3C 2C 6E 4E 7E");
      assertEquals(2,p.checkTwoPairs(p.A));
    }
    @Test
    public void testfalseDoublePair(){
      Poker p = new Poker("1C 1C 2D 2E 5E 3C 3C 6E 4E 7E");
      assertEquals(-1, p.checkTwoPairs(p.B));
    }
  }
  @Nested
  class ThreeKind{
    @Test
    public void testThreeKind(){
      Poker p = new Poker("1C 1C 1D 2E 5E 3C 2C 6E 4E 7E");
      assertEquals(1,p.checkThreeKind(p.A));
    }
    @Test
    public void testfalseThreeKind(){
      Poker p = new Poker("1C 1C 2D 2E 5E 3C 3C 6E 6E 7E");
      assertEquals(-1, p.checkThreeKind(p.B));
    }
  }

  @Nested
  class Straight{
    @Test
    public void testStraight(){
      Poker p = new Poker("1C 2C 3D 4E 5E 3C 2C 6E 4E 7E");
      assertEquals(5,p.checkStraight(p.A));
    }
    @Test
    public void testfalseStraight(){
      Poker p = new Poker("1C 2C 3D 4E 5E 3C 3C 6E 4E 7E");
      assertEquals(-1, p.checkStraight(p.B));
    }
    @Test
    public void testSpecialStraight(){
      Poker p = new Poker("AA 2C 3C 4C 5C 2C 3A 4C 5C 6C");
      assertFalse(p.check()==0);
      assertEquals(5,p.checkStraight(p.A));
    }
  }

  @Nested
  class Flush{
    @Test
    public void testFlush(){
      Poker p = new Poker("1C 1C 2C 2C 5C 3C 2C 6E 4E 7E");
      assertEquals(5,p.checkFlush(p.A));
    }
    @Test
    public void testfalseFlush(){
      Poker p = new Poker("1C 1C 2D 2E 5E 3C 3C 6E 4E 7E");
      assertEquals(-1, p.checkFlush(p.B));
    }
  }

  @Nested
  class FullHouse{
    @Test
    public void testFullHouse(){
      Poker p = new Poker("1C 1C 2D 2E 2E 3C 2C 6E 4E 7E");
      assertEquals(3,p.checkFullHouse(p.A));
    }
    @Test
    public void testfalseDublePair(){
      Poker p = new Poker("1C 1C 2D 2E 5E 3C 3C 6E 6E JE");
      assertEquals(-1, p.checkFullHouse(p.B));
    }
  }

  @Nested
  class FiveHands {
    @Test
    public void testHandOne(){
      Poker p = new Poker("5H 5C 6S 7S KD 2C 3S 8S 8D TD");
      assertFalse(p.check()==0);
    }
    @Test
    public void testHandTwo(){
      Poker p = new Poker("5D 8C 9S JS AC 2C 5C 7D 8S QH");
      assertTrue(p.check()==0);
    }
    @Test
    public void testHandThree(){
      Poker p = new Poker("2D 9C AS AH AC 3D 6D 7D TD QD");
      assertFalse(p.check()==0);
    }
    @Test
    public void testHandFour(){
      Poker p = new Poker("4D 6S 9H QH QC 3D 6D 7H QD QS");
      assertTrue(p.check()==0);
    }
    @Test
    public void testHandFive(){
      Poker p = new Poker("2H 2D 4C 4D 4S 3C 3D 3S 9S 9D");
      assertTrue(p.check()==0);
    }

    @Test
    public void testSplitpot(){
      Poker p = new Poker("2H 2H 3H 4H 5D 2F 2F 4F 3G 5E");
      assertEquals(2,p.check());
    }

    @Test
    public void testSpecialCase(){
      Poker p = new Poker("6D 7C 5D 5H 3S 5C JC 2H 5S 3D");
      assertEquals(2,p.check());
    }

    @Test
    public void testWrongOne(){
      Poker p = new Poker("6C 4D 7S 7H 5S JC 6S 9H 4H JH");
      assertEquals(1,p.check());
    }

    @Test
    public void testWrongTwo(){
      Poker p = new Poker("6D 7C 5D 5H 3S 5C JC 2H 5S 3D");
      assertEquals(1,p.check());
    }

  }



}
