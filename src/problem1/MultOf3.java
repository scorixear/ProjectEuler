package problem1;

/**
 * @author Paul Keller
 * @version 1.0
 * @date 19.12.2018
 */
public class MultOf3 {
  public static void main(String[] args) {
    int sum = 0;
    for(int i = 0;i<1000;i++){
      if(i%3==0 || i%5==0){
        sum+=i;
      }
    }
    System.out.println(sum);
  }
}
