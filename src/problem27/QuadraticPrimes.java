package problem27;

import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class QuadraticPrimes {
  private static TreeSet<Integer> primes;
  public static void main(String[] args) {
    long time = System.nanoTime();
    primes = new TreeSet<>();
    int max = 0;
    int finala=0,finalb=0;
    for(int a = -999; a<1000;a++){
      for(int b = -1000;b<=1000;b++){
        int n;
        for(n = 0;;n++){
          if(!isPrime(n*n+a*n+b)){
            break;
          }
        }
        if(max<n){
          max = n;
          finala = a;
          finalb = b;
        }
      }
    }
    System.out.println(max+" a:"+finala+" b:"+finalb+" Product:"+finala*finalb);
    System.out.println("Time: "+((System.nanoTime()-time)/ 1e9)+"s");
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
