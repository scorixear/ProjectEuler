package problem50;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class ConsecutivePrimes {
  public static void main(String... a) {
    int max = 0;
    int n = 0;
    ArrayList<Integer> primes = allPrimes(1000000);
    for(int i = primes.size()-1;i>=0;i--){

        //System.out.println(i);
        int count = getSums(primes.get(i),primes);
        if(max<count){
          System.out.println(count+" "+primes.get(i));
          max = count;
          n = i;
        }

    }
    System.out.println(primes.get(n)+" "+max);

  }

  private static int getSums(int n, ArrayList<Integer> allPrimes) {
    int index = allPrimes.size()-1;
    while(allPrimes.get(index)>n){
      index--;
    }
    ArrayList<Integer> primes = new ArrayList<>();
    for(int i = 0;i<=index;i++){
      primes.add(allPrimes.get(i));
    }

    int maxcount = 1;
    int mincount = 0;
    int sum = 0;
    while(maxcount<primes.size()){
      while(sum < n){
        if(maxcount>primes.size())
          break;
        sum += primes.get(maxcount-1);
        maxcount++;

      }
      while(sum>n){
        if(mincount>=maxcount)
          break;
        sum-=primes.get(mincount);
        mincount++;
      }
      if(sum==n){
        return maxcount-mincount-1;
      }
    }
    return 0;
  }
  private static ArrayList<Integer> allPrimes(int limit) {
    ArrayList<Integer> primes = new ArrayList<>();
    primes.add(2);
    for(int i = 3 ;i<limit;i++){
      if(isPrime(i, primes)){
        primes.add(i);
      }
    }
    return primes;

  }

  private static boolean isPrime(int n, ArrayList<Integer> primes) {
    if(n <=1)return false;
    for(int i = 0;i<primes.size();i++){
      if(primes.get(i)>Math.sqrt(n))
        break;
      if(n%primes.get(i) == 0){
        return false;
      }
    }
    return true;
  }
}
