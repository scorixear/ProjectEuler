package problem36;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class DoublePalindrom {
  public static void main(String[] args) {
    int sum = 0;
    for(int i = 0;i<1000000;i++){
      if(isPalindrom(i)) sum+=i;
    }
    System.out.println(sum);
  }

  private static boolean isPalindrom(int i) {
    String base10 = Integer.toString(i);
    String base2 = Integer.toString(i,2);
    return checkPalindrom(base10)&&checkPalindrom(base2);
  }

  private static boolean checkPalindrom(String number){
    for(int i = 0;i<number.length()/2;i++){
      if(number.charAt(i)!=number.charAt(number.length()-1-i)){
        return false;
      }
    }
    return true;
  }

}
