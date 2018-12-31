package problem30;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class FithPower {
  public static void main(String[] args) {
    int count = 0;
    long bigsum = 0;
    for(int i = 2;i<350000;i++){
      long sum = 0;
      for(char c: (i+"").toCharArray()){
        sum += Math.pow(Long.parseLong(c+""),5);
      }
      if(sum==i){
        System.out.println(i);
        bigsum+=i;
        count++;
      }
    }
    System.out.println(count +" Numbers");
    System.out.println(bigsum);
  }

}
