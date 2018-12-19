package problem6;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class DiffSquares {
  public static void main(String[] args) {
    long sum1=0;
    long sum2=0;
    for(int i = 1;i<=100;i++){
      sum1 +=i*i;
      sum2 +=i;
    }
    sum2*=sum2;
    System.out.println(sum2-sum1);
  }


}
