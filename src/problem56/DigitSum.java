package problem56;

import java.math.BigInteger;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class DigitSum {
  public static void main(String[] args) {
    int maxsum = 0;
    for(int i = 99;i>=2;i--){
      for(int j = 99;j>0;j--){
        BigInteger a = BigInteger.valueOf(i);
        String s = a.pow(j).toString();
        int sum = 0;
        for(char c: s.toCharArray()){
          sum += Integer.parseInt(c+"");
        }
        if(sum>maxsum)maxsum=sum;

      }
    }
    System.out.println(maxsum);
  }


}
