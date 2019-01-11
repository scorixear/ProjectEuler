package problem49;

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PrimePerms {

  public static void main(String[] args) {
    ArrayList<Integer> primes = allPrimes(1487, 10000);
    for(int i = 0;i<primes.size();i++){
      for(int j = i+1;j<primes.size();j++){
        int k = primes.get(j) +(primes.get(j)-primes.get(i));
        if(k<10000 && isPrime(k)){
          if(isPerm(primes.get(i), primes.get(j))&&isPerm(primes.get(i), k)){
            System.out.println(primes.get(i)+""+primes.get(j)+""+k);
          }
        }
      }
    }


  }

  private static boolean isPerm(Integer integer, Integer other) {
    boolean contains = true;
    ArrayList<Character> list = new ArrayList<>();
    for(char o:other.toString().toCharArray()){
      list.add(o);
    }
    for(char c: integer.toString().toCharArray()){


      if(!list.contains(c)){
        contains=false;
        break;
      }else{
        list.remove(Character.valueOf(c));
      }
    }
    return contains;
  }

  private static ArrayList<Integer> allPrimes(int i, int limit) {
    ArrayList<Integer> primes = new ArrayList<>();
    for(;i<limit;i++){
      if(isPrime(i)){
        primes.add(i);
      }
    }
    return primes;

  }

  private static boolean isPrime(int n) {
    if(n <=1)return false;
    for(int i = 2;i<=n/2;i++){
      if(n%i == 0){
        return false;
      }
    }
    return true;
  }
/*
  public static void main(String[] args) {
    for(int i = 1000;i<10000;i++){
      TreeSet<Integer> pool = new TreeSet<>();
      for(char c:(i+"").toCharArray())
        pool.add(Integer.parseInt(c+""));

      ArrayList<Integer[]> perms = new ArrayList<>();
      calculatePermutation(new Integer[4],0,pool,perms);
      TreeSet<Integer> foundPerms = new TreeSet<>();
      for(Integer[] perm: perms){
        String s = "";
        for(int n:perm){
          s +=n;
        }
        int sn = Integer.parseInt(s);
        if(isPrime(sn)){
          foundPerms.add(sn);
        }
      }
      if(foundPerms.size()>=3){
        foundPerms = checkSteps(foundPerms);
        if(foundPerms.size() == 3){
          System.out.println(foundPerms);
        }

      }

    }
  }

  private static TreeSet<Integer> checkSteps(TreeSet<Integer> foundPerms) {
    ArrayList<Integer> p = new ArrayList<>(foundPerms);
    for(int i = 0;i<p.size()-2;i++){
      int start = i;
      int start2 = findNext(p,start,3330);
      int start3 = findNext(p,start2,3330);
      if(start3 != -1){
        TreeSet<Integer> returnSet = new TreeSet<>();
        returnSet.add(p.get(start));returnSet.add(p.get(start2));returnSet.add(p.get(start3));
        return returnSet;
      }
    }
    return new TreeSet<>();
  }

  private static int findNext(ArrayList<Integer> p, int start, int i) {
    if (start == -1) {
      return -1;
    }
    int n = p.get(start)+i;
    if(p.contains(n)){
      return p.indexOf(n);
    }
    return -1;
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
  }*/
}
