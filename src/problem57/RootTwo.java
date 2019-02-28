package problem57;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class RootTwo {
  public static void main(String[] args) {
    int count = 0;
    for (int i = 1;i<=1000;i++){
      BigInteger[] frac = getFraction(i);
      System.out.println(Arrays.toString(frac));
      if((frac[0].toString()).length()>(frac[1].toString()).length()){
        count++;
      }
    }
    System.out.println(count);
  }

  private static BigInteger[] getFraction(int i){
    return recursivGetFrac(i, new BigInteger[]{BigInteger.valueOf(3),BigInteger.valueOf(2)});
  }

  private static BigInteger[] recursivGetFrac(int i, BigInteger[] lastfrac) {
    if(i==1){
      return lastfrac;
    }
    BigInteger[] newfrac = new BigInteger[2];
    newfrac[0] = lastfrac[1].add(lastfrac[1]).add(lastfrac[0]);
    newfrac[1]= lastfrac[0].add(lastfrac[1]);
    return recursivGetFrac(i-1,newfrac);
  }
}
