package problem24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Permutations {

  public static void main(String[] args) {
    ArrayList<Integer[]>perms = calculatePermutation(10);
    //perms.forEach(x-> System.out.println(Arrays.toString(x)));
    System.out.println(Arrays.toString(perms.get(999999)));
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
