package problem20;

import java.math.BigInteger;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class FactorSum {
  public static void main(String[] args) {
    BigInteger m = BigInteger.valueOf(100);
    for(int d = 99;d>1;d--){
      m=m.multiply(BigInteger.valueOf(d));
    }
    System.out.println(m);
    int sum = 0;
    for(char c:m.toString().toCharArray()){
      sum+=Integer.parseInt(c+"");
    }
    System.out.println(sum);
  }

}
