package problem34;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class DigitFactorial {
  public static void main(String[] args) {
    for(int i = 3;i<=2510160;i++){
      int sum = 0;
      for(char c: (i+"").toCharArray()){
        sum += fac(Integer.parseInt(c+""));
      }
      if(i==sum) System.out.println(i);
    }
  }

  private static int fac(int c) {
    if(c==0)return 1;
    if(c<3) return c;
    return fac(c-1)*c;
  }
}
