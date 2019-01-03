package problem33;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class DigitalCancelling {
  public static void main(String[] args) {
    for(int a = 11;a<100;a++){
      for(int b = a+1;b<100;b++){
        if(a%10 == 0 || b%10 == 0) continue;
        //System.out.println(a+ "/"+b);
        double aa = a/10;
        double ab = a%10;

        double ba = b/10;
        double bb = b%10;
        if(aa==ba&&a/(double)b==ab/bb){
          System.out.println(a+"/"+b+" = "+(a/(double)b));
        }else if(aa==bb&&a/(double)b ==ab/ba){
          System.out.println(a+"/"+b+" = "+(a/(double)b));
        }else if(ab == ba&&a/(double)b==aa/bb){
          System.out.println(a+"/"+b+" = "+(a/(double)b));
        }else if(ab == bb&&a/(double)b==aa/ba){
          System.out.println(a+"/"+b+" = "+(a/(double)b));
        }
      }
    }

  }
}
