package problem7;

import java.util.ArrayList;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PrimeCount {
  public static void main(String[] args) {

    ArrayList<Integer> primes = new ArrayList<>();
    primes.add(2);
    for(int i =3;primes.size()<10001;i++){
      boolean f = false;
      for(int p:primes){
        if(i%p==0){
          f=true;
          break;
        }
      }
      if(!f){
        primes.add(i);
      }
    }
    System.out.println(primes.size()+" "+primes.get(primes.size()-1));
  }
}
