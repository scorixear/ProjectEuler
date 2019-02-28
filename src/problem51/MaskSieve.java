package problem51;

import java.util.Arrays;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class MaskSieve {

  public static void main(String[] args) {
    System.out.println(run());
  }

  private static boolean[] listPrimality(int n){
    boolean[] b = new boolean[n];
    for(int i = 0;i<n;i++){
      b[i]=isPrime(i);
    }
    return b;
  }

  private static boolean isPrime(int n) {
    if(n <=1)return false;
    for(int i = 2;i<=Math.sqrt(n);i++){
      if(n%i == 0){
        return false;
      }
    }
    return true;
  }

  public static String run() {
    boolean[] isPrime = listPrimality(1000000);
    for (int i = 0; i < isPrime.length; i++) {
      if (!isPrime[i])
        continue;

      int[] n = toDigits(i);
      for (int mask = 0; mask < (1 << n.length); mask++) {
        int[] digits = doMask(n, mask);
        int count = 0;
        for (int j = 0; j < 10; j++) {
          if (digits[0] != 0 && isPrime[toNumber(digits)])
            count++;
          digits = addMask(digits, mask);
        }

        if (count == 8) {
          digits = doMask(n, mask);
          for (int j = 0; j < 10; j++) {
            if (digits[0] != 0 && isPrime[toNumber(digits)])
              return Integer.toString(toNumber(digits));
            digits = addMask(digits, mask);
          }
        }
      }
    }
    throw new RuntimeException("Not found");
  }


  private static int[] toDigits(int n) {
    String s = n+"";
    int[] result  = new int[s.length()];
    for(int i = 0;i<s.length();i++){
      result[i] = Integer.parseInt(s.toCharArray()[i]+"");
    }
    return result;
    /*int[] buf = new int[10];
    int i = buf.length;
    do {
      i--;
      buf[i] = n % 10;
      n /= 10;
    } while (n != 0);
    return Arrays.copyOfRange(buf, i, buf.length);*/
  }


  private static int[] doMask(int[] digits, int mask) {
    int[] result = new int[digits.length];
    for (int i = 0; i < digits.length; i++)
      result[i] = digits[i] * (~mask >>> i & 1);
    return result;
  }


  private static int[] addMask(int[] digits, int mask) {
    int[] result = new int[digits.length];
    for (int i = 0; i < digits.length; i++)
      result[i] = digits[i] + (mask >>> i & 1);
    return result;
  }


  private static int toNumber(int[] digits) {
    StringBuilder s = new StringBuilder();
    for(int n:digits){
      s.append(n);
    }
    return Integer.parseInt(s.toString());
    //int result = 0;
    //for (int x : digits)
    //  result = result * 10 + x;
    //return result;
  }

}
