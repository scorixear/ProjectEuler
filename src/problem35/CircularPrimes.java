package problem35;

import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class CircularPrimes {
  private static TreeSet<Integer> primes;
  public static void main(String[] args) {
    primes=new TreeSet<>();
    int count=0;
    for(int i = 2;i<1000000;i++){
      if(isPrime(i)){
        String s = i+"";
        boolean isCircularPrimes = true;
        for(int r = 0;r<(i+"").length()-1;r++){
          s=s.substring(s.length()-1)+s.substring(0,s.length()-1);
          if(!isPrime(Integer.parseInt(s))){
            isCircularPrimes=false;
            break;
          }
        }
        if(isCircularPrimes) {
          System.out.println(i);
          count++;
        }
      }
    }
    System.out.println(count);
  }

  private static boolean isPrime(int i) {
    if(primes.contains(i)){
      return true;
    }
    else if(isRealPrime(i)){
      primes.add(i);
      return true;
    }
    return false;
  }

  private static boolean isRealPrime(int n) {
    if(n <=1)return false;
    for(int i = 2;i<=n/2;i++){
      if(n%i == 0){
        return false;
      }
    }
    return true;
  }
}
