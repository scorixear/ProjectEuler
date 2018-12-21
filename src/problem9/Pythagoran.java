package problem9;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Pythagoran {
  public static void main(String[] args) {
    int sum = 0;
    int lasta=3, lastb=4, lastc=5;
    while(sum!=1000){
      int[] abc = findNextPythagoran(lasta, lastb);
      sum=abc[0]+abc[1]+abc[2];
      lasta = abc[0];
      lastb = abc[1];
      lastc = abc[2];
    }
    System.out.println(lasta+"^2 + "+lastb+"^2 = "+lastc+"^2");
    System.out.println(lasta*lastb*lastc);
  }

  private static int[] findNextPythagoran(int lasta, int lastb) {
    int a = lasta, b=lastb;
    while (true) {
      double c;
      if (b > 999) {
        b = 1;
        a++;
      }else{
        b++;
      }
      c = Math.sqrt(b*b+a*a);
      if(c%1 ==0){
        return new int[]{a,b,(int)c};
      }
    }
  }
}
