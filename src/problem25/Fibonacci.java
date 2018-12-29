package problem25;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Fibonacci {

  private static ArrayList<BigInteger> fib;

  public static void main(String[] args) {
    fib = new ArrayList<>();
    fib.add(BigInteger.ONE);
    fib.add(BigInteger.ONE);
    int i = 2;
    while (true) {
      BigInteger nextFib = fib.get(i-1).add(fib.get(i-2));
      fib.add(nextFib);
      if(nextFib.toString().length()>=1000){
        break;
      }
      i++;
    }
    System.out.println(fib.get(fib.size()-1)+" "+i);
  }

}
