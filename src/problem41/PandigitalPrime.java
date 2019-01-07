package problem41;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PandigitalPrime {
  public static void main(String[] args) {
    for(int i = 1;i<987654322;i++){

      if(isPendigital(i,(i+"").length())&&isPrime(i)){
        System.out.println(i);
      }
    }
  }

  private static boolean isPendigital(int n, int length) {
    String s = n+"";
    return s.matches("^(?:([1-"+length+"])(?!.*\\1)){"+length+"}$");
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
