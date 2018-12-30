package problem28;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Spiral {
  public static void main(String[] args) {
    int sum = 0;
    int step = 2;
    for(int i = 1;i<=1002001;){
      for(int s = 0;s<4;s++){
        if(i>1002001){
          break;
        }
        sum += i;
        i+=step;
      }
      step+=2;
    }
    System.out.println(sum);
  }

}
