package problem29;

import java.math.BigInteger;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class DistinctPowers {
  public static void main(String[] args) {
    TreeSet<BigInteger> set = new TreeSet<>();
    for(long a = 2;a<=100;a++){
      for(long b = 2;b<=100;b++){
        set.add(BigInteger.valueOf(a).pow((int)b));
      }
    }
    System.out.println(set.size());
    System.out.println(set);
  }

}
