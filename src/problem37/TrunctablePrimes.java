package problem37;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class TrunctablePrimes {

  public static void main(String[] args) {
    int sum = 0;
    int count = 0;
    for(int i = 11;count <11;i++){
      String n = i+"";
      boolean isTrunctablePrime = true;
      while(n.length()>0){
        int number = Integer.parseInt(n);
        if(!isPrime(number)){
          isTrunctablePrime=false;
          break;
        }
        n = n.substring(1);
      }
      n = i+"";
      if(isTrunctablePrime){
        while(n.length()>0){
          int number = Integer.parseInt(n);
          if(!isPrime(number)){
            isTrunctablePrime=false;
            break;
          }
          n = n.substring(0,n.length()-1);
        }
        if(isTrunctablePrime){
          count++;
          sum+=i;
          System.out.println(i);
        }
      }
    }
    System.out.println(sum);
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
