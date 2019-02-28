package problem53;

import java.math.BigInteger;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Combinatorics {

  public static void main(String[] args) {
    int count = 0;
    for(BigInteger n = BigInteger.ONE;n.compareTo(BigInteger.valueOf(100))<=0;n=n.add(BigInteger.ONE)){
      for(BigInteger r = n;r.compareTo(BigInteger.ZERO)>=0;r=r.subtract(BigInteger.ONE)){
        BigInteger facn = fac(n,r);
        BigInteger facnr = fac(n.subtract(r),BigInteger.ZERO);
        if(facn.divide(facnr).compareTo(BigInteger.valueOf(1000000))>0)
          count++;
      }
    }
    System.out.println(count);
  }

  private static BigInteger fac(BigInteger n, BigInteger limit) {
    if(n.compareTo(BigInteger.ONE)<=0)return BigInteger.ONE;
    if(n.equals(limit)){
      return BigInteger.ONE;
    }
    return n.multiply(fac(n.subtract(BigInteger.ONE), limit));
  }

}
