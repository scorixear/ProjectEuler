package problem48;

import java.math.BigInteger;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Selfpowers {
  public static void main(String[] args) {
    BigInteger sum = BigInteger.ZERO;
    for(int i = 1;i<=1000;i++){
      System.out.println(i);
      sum = sum.add(BigInteger.valueOf(i).pow(i));
    }
    System.out.println("it is "+sum);
    //and now for real
    long n = 0;
    for(long i = 1;i<1000;i++){
      long s = i;
      for(long k =1;k<i;k++){
        s=(s*i)%10000000000L;
      }
      n= (n+s)%10000000000L;
    }
    System.out.println(n);
  }
}
