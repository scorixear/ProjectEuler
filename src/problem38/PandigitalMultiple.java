package problem38;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PandigitalMultiple {

  public static void main(String[] args) {
    long max = 0;
    for(int a = 1;a<10000;a++){
      String concated = "";
      for(int n = 1;concated.length()<9;n++){
       concated+=a*n;
        if(isPandigital(concated)){
          if(max<Long.parseLong(concated))max=Long.parseLong(concated);
          System.out.println(a+" * ["+n+"]");
          break;
        }
      }
    }
    System.out.println(max);
  }



  private static boolean isPandigital(String s) {
    return s.matches("^(?:([1-9])(?!.*\\1)){9}$");
  }
}
