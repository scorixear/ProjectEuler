package problem26;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class RecuringPatterns {
  public static void main(String[] args) {
    int max = 0;
    int num = 0;
    for(int i = 1;i<1000;i++){
      BigDecimal d = BigDecimal.ONE.divide(BigDecimal.valueOf(i), 10000,RoundingMode.CEILING);
      System.out.println(i);
      //System.out.println(d.toString());
      int length = analyseD(d);

      if(max<length){
        max = length;
        num = i;
      }
    }
    System.out.println(max+" "+num);
  }

  private static int analyseD(BigDecimal d) {
    String dString = d.toString().substring(2,d.toString().length()-1);
    Pattern p = Pattern.compile(".*(.+)(\\1)+$");
    Matcher m = p.matcher(dString);
    m.matches();
    try {
      String group = m.group(1);
      System.out.println(group);
      return group.length();
    }catch(IllegalStateException e){
      return 0;
    }



  }

}
