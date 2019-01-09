package problem50;

import java.util.ArrayList;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class ConsecutivePrimes {

  public static void main(String... a) {
    int max = 0;
    int n = 0;
    ArrayList<Integer> primes = allPrimes(2,1000000);
    for(int i = 0;i<primes.size();i++){

        //System.out.println(i);
        int count = getSums(primes.get(i));
        if(max<count){
          System.out.println(count+" "+i);
          max = count;
          n = i;
        }

    }
    System.out.println(n+" "+max);

  }

  private static int getSums(int n) {
    ArrayList<Integer> primes = allPrimes(2, n);
    int maxcount = 0;
    int count = 0;
    int sum = 0;
    int min = 0;
    for(int i = primes.size()-1;i>=0;i--){
      sum+=primes.get(i);
      count++;
      if(sum > n){
        sum-=primes.get(min);
        min++;
        count--;
      }
      if(maxcount<count)maxcount = count;
    }
    return maxcount;
  }
  private static ArrayList<Integer> allPrimes(int i, int limit) {
    ArrayList<Integer> primes = new ArrayList<>();
    for(;i<limit;i++){
      if(isPrime(i)){
        primes.add(i);
      }
    }
    return primes;

  }

  private static boolean isPrime(int n) {
    if(n <=1)return false;
    for(int i = 2;i<=n/2;i++){
      if(n%i == 0){
        return false;
      }
    }
    return true;
  }
}
