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
    for(int i = primes.size()-1;i>=0;i--){

        System.out.println(i);
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
    int maxcount = 0;
    for(int i = 0;i<primes.size();i++){
      for(int j = i;j<primes.size();j++){
        int sum = 0;
        for(int min = i;min<=j;min++){
          sum+=primes.get(min);
        }
        if(sum == n){
          if(j-i+1 >maxcount)maxcount=j-i+1;
        }
      }
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
