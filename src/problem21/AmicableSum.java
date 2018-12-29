package problem21;

import java.util.Arrays;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class AmicableSum {
  public static void main(String[] args) {
    int[] amicableIntegers = new int[9999];
    for(int i = 1;i<10000;i++){
      amicableIntegers[i-1]=i;
    }

    int totalsum = 0;
    for(int i=0;i<amicableIntegers.length;i++){
      int tempami = amicableIntegers[i];
      int sum = calculateAmiSum(tempami);
      if(sum>9999||tempami==sum||calculateAmiSum(sum)!=tempami){
        amicableIntegers[i] = -1;
      }else{
        totalsum+=tempami;
      }
    }
    System.out.println(totalsum);
    System.out.println(calculateAmiSum(220));
    System.out.println(calculateAmiSum(284));
    System.out.println(Arrays.toString(amicableIntegers));
  }
  private static int calculateAmiSum(int n){
    int sum = 0;
    for(int i = 1;i<=n/2;i++){
      if(n%i==0)
        sum+=i;
    }
    return sum;
  }

}
