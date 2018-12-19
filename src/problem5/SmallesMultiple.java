package problem5;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class SmallesMultiple {
  public static void main(String[] args) {
    for(long i = 20;;i++){
      boolean b = true;
      for(int j = 2;j<=20;j++){
        if(i%j!=0){
          b=false;
          break;
        }
      }
      if(b) {
        System.out.println(i);
        break;
      }
    }
  }

}
