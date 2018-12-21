package problem10;

import java.util.ArrayList;
import java.util.stream.Collector;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PrimeSum {
  public static void main(String[] args) {
    ArrayList<Integer> primes = new ArrayList<>();
    primes.add(2);
    for(int i =3;i<2000000;i++){
      boolean f = false;
      for(int p:primes){
        if(i%p==0){
          f=true;
          break;
        }
      }
      if(!f){
        System.out.println(i);
        primes.add(i);
      }
    }

    long sum = primes.stream().mapToLong(a->a).sum();
    System.out.println(sum);
  }

}
