package problem47;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class DistinctPrimes {
  public static void main(String[] args) {
    for(int i = 1;;i+=1){
      System.out.println(i);
      int second = i+1;
      int third = i+2;
      int fourth = i+3;
      ArrayList<Integer> factors = new ArrayList<>();

      factors.addAll(findFactors(i));
      factors.addAll(findFactors(second));
      factors.addAll(findFactors(third));
      factors.addAll(findFactors(fourth));
      if(factors.size()==16){
        System.out.println(i+" it is");
        break;
      }
    }
  }

  private static TreeSet<Integer> findFactors(int n) {
    TreeSet<Integer> factors = new TreeSet<>();
    while(n%2 == 0){
      factors.add(2);
      n/=2;
    }
    for(int i = 3;i<= Math.sqrt(n);i+=2) {
      while (n % i == 0) {
        factors.add(i);
        n /= i;
      }
    }
    if (n > 2) {
      factors.add(n);
    }
    return factors;
  }
}