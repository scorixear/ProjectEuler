package problem46;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Goldbach {

  public static void main(String[] args) {
    boolean found = false;
    for(int comp = 3;;comp+=2){

      if(!isPrime(comp)){
        int p = 2;
        while(p<comp&&!found){
          int i = 1;
          while(2*i*i+p <= comp){
            if(2*i*i+p == comp){
              found = true;
              break;
            }
            i++;
          }
          p = findNextPrime(p);
        }
        if(!found){
          System.out.println(comp);
          return;
        }
      }

      found = false;
    }
  }

  private static int findNextPrime(int p) {
    for(int i =  p+1;;i++){
      if(isPrime(i)){
        return i;
      }
    }
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
