package problem14;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Collatz {

  static HashMap<BigInteger, BigInteger> save = new HashMap<>();

  public static void main(String[] args) {
    BigInteger maxcnt = BigInteger.ZERO;
    int longestChain=1;
    for(int i = 1;i<=1000000;i++){
      BigInteger cnt = collatz(i);
      System.out.println("i: "+i+" "+cnt);
      if(cnt.compareTo(maxcnt)>0){
        maxcnt=cnt;
        longestChain=i;
      }
    }
    System.out.println(maxcnt+" "+longestChain);

  }
  private static BigInteger collatz(int n){
    BigInteger cnt = BigInteger.ZERO;
    for(BigInteger i = BigInteger.valueOf(n);i.compareTo(BigInteger.ONE)!=0;){
      if(n==113383)
        System.out.println("Collatz: "+i);
      if(save.containsKey(i)){
        return cnt.add(save.get(i));
      }
      else if(i.mod(BigInteger.TWO).compareTo(BigInteger.ZERO)==0){
        i=i.divide(BigInteger.TWO);
      }else{
        i=i.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
      }
      cnt=cnt.add(BigInteger.ONE);
    }
    return cnt;

  }

}
