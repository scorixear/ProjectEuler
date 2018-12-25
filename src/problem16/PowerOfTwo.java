package problem16;

import java.math.BigInteger;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PowerOfTwo {
  public static void main(String[] args) {
    BigInteger num = BigInteger.ONE;
    for(int i = 1;i<=1000;i++){
      num=num.multiply(BigInteger.TWO);
    }
    String s = num.toString();
    long count = 0;
    for(char c:s.toCharArray()){
      count = count + Long.valueOf(c+"");
    }
    System.out.println(count);
  }

}
