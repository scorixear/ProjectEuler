package problem43;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class SubStringPandigital {

  public static void main(String[] args) {
    ArrayList<Integer[]> pans = calculatePermutation(10);
    long sum = 0;
    for(Integer[] perm : pans){
      String s = "";
      for(int x:perm) s+=x;
      int a = Integer.parseInt(s.substring(1,4));
      int b = Integer.parseInt(s.substring(2,5));
      int c = Integer.parseInt(s.substring(3,6));
      int d = Integer.parseInt(s.substring(4,7));
      int e = Integer.parseInt(s.substring(5,8));
      int f = Integer.parseInt(s.substring(6,9));
      int g = Integer.parseInt(s.substring(7));
      if(a%2 == 0 && b%3 == 0 && c%5 == 0 && d % 7 == 0 && e%11 == 0 && f%13 == 0 && g%17 == 0)
        sum+=Long.parseLong(s);
    }
    System.out.println(sum);
  }

  private static ArrayList<Integer[]> calculatePermutation(int n){
    TreeSet<Integer> pool = new TreeSet<>();
    for(int i = 0;i<n;i++){
      pool.add(i);
    }
    ArrayList<Integer[]> permutations = new ArrayList<>();
    calculatePermutation(new Integer[n],0,pool,permutations);
    return permutations;
  }

  private static <T> void calculatePermutation (T[] permutation, int index, TreeSet<T> pool, ArrayList<T[]> perms){
    //if we are over the last place a number can be, than this has to be a permutation, since backtracking hasn't stopped us
    if(index == permutation.length) {
      perms.add(permutation.clone());
    }else{
      //go through all numbers in our current pool
      for (T aPool : pool) {
        //set the element to one of the remaining numbers;
        permutation[index] = aPool;
        //create a new TreeSet which will be used in the next iteration
        TreeSet<T> newPool = new TreeSet<>();
        //add all number from our current pool to the new Pool except our selected number
        for (T i : pool) {
          if (i != permutation[index])
            newPool.add(i);
        }
        calculatePermutation(permutation, index + 1, newPool,perms);


      }
    }
  }

}
