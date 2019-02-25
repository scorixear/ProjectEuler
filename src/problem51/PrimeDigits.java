package problem51;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PrimeDigits {

  public static void main(String[] args) {
    TreeSet<Integer> primes = new TreeSet<>();
    for(int i = 10000000; i<100000000;i++){
      for(int n = 0;n<10;n++) {
      }
    }
    System.out.println(primes.first());
  }


  private static int replaceDigit(int n, int index, int number){
    String s = n+"";
    return Integer.parseInt(s.subSequence(0,index)+""+number+s.subSequence(index+1,s.length()));
  }

  private static boolean isPrime(int n) {
    if(n <=1)return false;
    for(int i = 2;i<Math.sqrt(n);i++){
      if(n%i == 0){
        return false;
      }
    }
    return true;
  }

}
