package problem58;

import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class SpiralPrimes {
  public static void main(String[] args) {
    boolean[] primes = new boolean[Integer.MAX_VALUE>>1];
    for(int i = 0;i<primes.length;i++){
      primes[i]=true;
    }
    eratosthenesSieb(primes);
    int start = 1;
    int primecount = 0;
    int fullcount = 1;
    int sidecount = 1;
    int step = 2;
    while(true){

      for(int i = 0;i<4;i++){
        start =start+step;
        if(primes[start])
          primecount++;
        fullcount++;
      }
      sidecount+=2;
      double ratio = ((double)primecount)/fullcount;

      if(start%1000L <10){
        System.out.println(start);
        System.out.println(ratio);
        System.out.println(sidecount);
      }
      if(ratio <0.1 ){
        System.out.println(sidecount);
        break;
      }
      step+=2;
    }
  }
  private static void eratosthenesSieb(boolean[] array){
    array[0]=false;array[1]=false;
    int index = 2;
    while(index<array.length){
      int start = index;
      for(int i = start*2;i<array.length;i+=start){
        array[i]=false;
      }
      for(int i = index+1;;i++){
        if(i>=array.length)
          return;
        if(array[i]){
          index = i;
          break;
        }
      }
      if(index%10000==1)
        System.out.println("Eras: "+index);
    }

  }
}
