package problem55;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Lychrel {
  private static ArrayList<BigInteger> knownNonLychrels = new ArrayList<>();
  public static void main(String[] args) {
    int count = 0;
    for(int i = 1;i<10000;i++){
      if(!checkLychrel(BigInteger.valueOf(i),1))
        count++;
    }
    System.out.println(count);
  }

  private static boolean checkLychrel(BigInteger i, int counter) {

    if(counter>50)
      return false;
    BigInteger x = reverse(i);
    x= x.add(i);
    if(isPalindrom(x)){
      return true;
    }else{

      return checkLychrel(x,counter+1);
    }

  }

  private static boolean isPalindrom(BigInteger x) {
    String s = x.toString();
    for(int i = 0;i<s.length()/2;i++){
      if(s.charAt(i)!=s.charAt(s.length()-1-i))
        return false;
    }
    return true;
  }

  private static BigInteger reverse(BigInteger i) {
    String s = i.toString();
    StringBuilder rev=new StringBuilder();
    for(int j=0;j<s.length();j++){
      rev.append(s.charAt(s.length()-1-j));
    }
    return new BigInteger(rev.toString());
  }

}
