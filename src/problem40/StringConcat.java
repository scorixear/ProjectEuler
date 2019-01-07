package problem40;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class StringConcat {
  public static void main(String[] args) {
    int nth = 0;
    int sum = 1;
    for(int i = 1;i<1000000;i++){
      String si = i+"";
      nth += si.length();

      if(nth-si.length() < 1&&nth >=1){
        int n = nth-1+1;
        String s = si.substring(si.length()-n,si.length()-n+1);
        sum *= Integer.parseInt(s);
        System.out.println(s);
      }else if(nth-si.length() < 10&&nth >10){
        int n = nth-10+1;
        String s = si.substring(si.length()-n,si.length()-n+1);
        sum *= Integer.parseInt(s);
        System.out.println(s);
      }else if(nth-si.length() < 100&&nth >100){
        int n = nth-100+1;
        String s = si.substring(si.length()-n,si.length()-n+1);
        sum *= Integer.parseInt(s);
        System.out.println(s);
      }else if(nth-si.length() < 1000&&nth >1000){
        int n = nth-1000+1;
        String s = si.substring(si.length()-n,si.length()-n+1);
        sum *= Integer.parseInt(s);
        System.out.println(s);
      }else if(nth-si.length() < 10000&&nth >10000){
        int n = nth-10000+1;
        String s = si.substring(si.length()-n,si.length()-n+1);
        sum *= Integer.parseInt(s);
        System.out.println(s);
      }else if(nth-si.length() < 100000&&nth >100000){
        int n = nth-100000+1;
        String s = si.substring(si.length()-n,si.length()-n+1);
        sum *= Integer.parseInt(s);
        System.out.println(s);
      }else if(nth-si.length() < 1000000&&nth >1000000){
        int n = nth-1000000+1;
        String s = si.substring(si.length()-n,si.length()-n+1);
        sum *= Integer.parseInt(s);
        System.out.println(s);
      }
    }
    System.out.println(sum);
  }

}
