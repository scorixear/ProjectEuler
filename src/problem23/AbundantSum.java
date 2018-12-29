package problem23;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class AbundantSum {
  public static void main(String[] args) {
    ArrayList<Integer> abudantNums = new ArrayList<>();
    for(int i = 1;i<28123;i++){
      if(isAbudant(i)){
        abudantNums.add(i);
      }
    }
    int sum=0;
    for(int i = 1;i<28123;i++){
      Integer[] sumInts =findSum(abudantNums,i);
      if(sumInts==null){
        sum+=i;
      }else{
        System.out.println(Arrays.toString(sumInts)+" "+i);
      }
    }
    System.out.println(sum);

  }

  private static Integer[] findSum(ArrayList<Integer> abudantNums, int n) {
    for(int i = 1;i<n;i++){
      if(abudantNums.contains(i)&&abudantNums.contains(n-i)){
        return new Integer[]{i,n-1};
      }
    }
    return null;
  }

  private static boolean isAbudant(int n) {
    int sum=0;
    for(int i = 1;i<=n/2;i++){
      if(n%i==0){
        sum+=i;
      }
    }
    return sum>n;
  }

}
