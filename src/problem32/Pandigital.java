package problem32;

import java.util.ArrayList;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Pandigital {
  public static void main(String[] args) {
    ArrayList<Long> products = new ArrayList<>();
    long sum = 0;
    for(long a = 1;a<10000;a++){
      for(long b = 1;b<10000;b++){
        long product = a*b;

        if(isPendigital(a,b,product)&& !products.contains(product)){
          products.add(product);
          sum+=product;
          System.out.println(a+" * "+b+" = "+product);
        }
      }
    }
    System.out.println(sum);
  }

  private static boolean isPendigital(long a, long b, long c) {
    String s = a+""+b+""+c;
    return s.matches("^(?:([1-9])(?!.*\\1)){9}$");
  }

}
