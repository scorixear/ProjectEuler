package problem17;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class NumberLetter {
  public static void main(String[] args) {
    int sum = 0;
    for(int i = 1;i<=1000;i++){
      String number = numberToWord(i);
      System.out.println(number);
      int count = numberWordCount(number);
      sum += count;
    }
    System.out.println(sum);
  }

  private static int numberWordCount(String n){
    return n.replaceAll(" ","").replaceAll("-","").length();
  }

  private static String numberToWord(int n){
    String s = "";
    String hundred = singleLetterNumber(n/100,false);
    s+=hundred;
    if(!hundred.equals("")){
      s+="hundred";
    }
    if(n%100 <20&&n%100>9){
      String ten = singleLetterNumber(n%100,true);
      if(ten.equals("")){
        return s;
      }
      if(n>100){
        s +="and";
      }
      s+=ten;
    }else if( n%100<10){
       String one = singleLetterNumber(n%10,false);
       if(one.equals("")){
         return s;
       }
       if(n>100){
         s+="and";
       }
       s+=one;
    }else{

      String ten = singleLetterNumber(((n%100)-(n%10))/10,true);
      String one = singleLetterNumber(n%10, false);
      if(ten.equals("")&&one.equals("")) {
        return s;
      }
      if(n>100){
        s+="and";
      }
      //System.out.println(" got here: "+ten+" = "+(n%100-n%10)/10 +" "+one+" = "+n%10);
      s+=ten+one;
    }
    return s;
  }

  private static String singleLetterNumber(int n, boolean isTen){
    if(isTen){
      switch(n){
        case 10:
          return "ten";
        case 11:
          return "eleven";
        case 12:
          return "twelve";
        case 13:
          return "thirdteen";
        case 14:
          return "fourteen";
        case 15:
          return "fifteen";
        case 16:
          return "sixteen";
        case 17:
          return "seventeen";
        case 18:
          return "eighteen";
        case 19:
          return "nineteen";
        case 2:
          return "twenty";
        case 3:
          return "thirty";
        case 4:
          return "fourty";
        case 5:
          return "fifty";
        case 6:
          return "sixty";
        case 7:
          return "seventy";
        case 8:
          return "eighty";
        case 9:
          return "ninety";
        default:
          return "";
      }
    }else{
      switch(n) {
        case 1:
          return "one";
        case 2:
          return "two";
        case 3:
          return "three";
        case 4:
          return "four";
        case 5:
          return "five";
        case 6:
          return "six";
        case 7:
          return "seven";
        case 8:
          return "eight";
        case 9:
          return "nine";
        default:
          return "";
      }
    }
  }
}
