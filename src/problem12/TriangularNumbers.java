package problem12;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class TriangularNumbers {
  public static void main(String[] args) {
    for(int i = 5;;i++){
      int sum = (i*(i+1))/2;
      int cnt=0;
      for(int j = 1;j<=sum;j++){
        if(sum%j==0){
          cnt++;
        }
      }
      System.out.println(i+" "+sum+" "+cnt);
      if(cnt >=500){
        System.out.println(i);
        System.out.println(sum);
        System.out.println(cnt);
        break;
      }
    }
  }

}
