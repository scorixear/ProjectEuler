package problem3;

import java.util.ArrayList;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PrimeFactors {
  static ArrayList<Long> primes;
  public static void main(String[] args) {
    long n = 600851475143L;
    primes = new ArrayList<>();
    ArrayList<Long> factors = new ArrayList<>();
    long prime = 2;
    while(n>1){
      while(n%prime==0){
        n=n/prime;
        factors.add(prime);
      }
      prime = findNextPrime(prime);
    }
    System.out.println(factors);
  }

  static long findNextPrime(long start){
    primes.add(start);
    while(true){
      start++;
      boolean f = false;
      for(long p:primes){
        if(start%p==0){
          f=true;
          break;
        }
      }
      if(!f){
        return start;
      }
    }
  }


}
