package problem52;

import java.util.ArrayList;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class PermutedMultiple {

  public static void main(String[] args) {
    for(int i= 2;;i++){
      if(isPerm(i,2*i)&&isPerm(i,3*i)&&isPerm(i,4*i)&&isPerm(i,5*i)&&isPerm(i,6*i)){
        System.out.println(i);
        break;
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
}
