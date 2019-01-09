package problem45;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Hexagonal {
  public static void main(String[] args) {
    int count = 0;
    long i = 2;
    while(count <2){
      if(isTriangular(i)&&isPentagonal(i)&&isHexagonal(i)){
        count++;
        System.out.println(i);
      }
      i++;
    }
  }

  private static boolean isHexagonal(long x){
    double n = (1L+Math.sqrt(1L+8L*x))/4L;
    return (long) n == n;
  }

  private static boolean isPentagonal(long x){
    double n = (1L+Math.sqrt(1L+24L*x))/6L;
    return (long)n==n;
  }

  private static boolean isTriangular(long x){
    double n = -0.5 + Math.sqrt(0.25+2L*x);
    return (long)n == n;
  }

}
