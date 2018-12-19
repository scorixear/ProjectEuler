package problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Palindromcnt {
  public static void main(String[] args) {
    ArrayList<Integer[]> list = new ArrayList<>();
   for(int i = 100;i<1000;i++){
     for(int j = 100;j<1000;j++){
       if(checkPalindrom(i*j)){
         System.out.println(i*j);
         list.add(new Integer[]{i,j,i*j});
       }
     }
   }
   list.sort(Comparator.comparing(o -> o[2]));
   list.forEach(array-> System.out.println(Arrays.toString(array)));
  }

  private static boolean checkPalindrom(int num){
    String number = num+"";

    for(int i = 0;i<number.length()/2;i++){
      if(number.charAt(i)!=number.charAt(number.length()-1-i)){
        return false;
      }
    }
    return true;
  }



}
