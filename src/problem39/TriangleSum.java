package problem39;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class TriangleSum {
  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<>();


    for(int a = 1; a<1000;a++){
      for(int b = a;b<1000;b++){
        double c = Math.sqrt(a*a + b*b);
        if(c == (int)c){
          if(a+b+(int)c<=1000)
            list.add(a+b+(int)c);
        }
      }
    }
    HashMap<Integer, Integer> sums = new HashMap<>();
    list.forEach(x->{
      if(sums.containsKey(x)){
        sums.put(x,sums.get(x)+1);
      }else{
        sums.put(x,1);
      }
    });
    System.out.println(sums);
    int max = 0;
    int maxk = 0;
    for(int k:sums.keySet()){
      if(sums.get(k)>max){
        max = sums.get(k);
        maxk = k;
      }
    }
    System.out.println(max+" "+maxk);
  }

}
