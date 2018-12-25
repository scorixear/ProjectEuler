package problem19;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class DoomsdayMethod {
  public static void main(String[] args) {
    int[] doomdays = new int[]{3,28,7,4,9,6,11,8,5,10,7,12};
    int firstday19 = 3;
    int firstday20 = 2;
    int sum = 0;
    for(int j = 1901;j<=2000;j++) {
      for (int m = 1; m <= 12; m++) {

        int a = (j % 100) / 12;
        //System.out.println("a = " + a);
        int b = (j % 100) % 12;
        //System.out.println("b = " + b);
        int c = b / 4;
        //System.out.println("c = " + c);
        int anker;
        if (j < 2000) anker = firstday19;
        else anker = firstday20;
        int ergebnis = (a + b + c) % 7 + anker;
        int doom = ergebnis % 7;
        //System.out.println("doom = " + doom);

        int cnt;
        if (m == 2) {
          if (j % 4 == 0) cnt = 29;
          else cnt = 28;
        } else if (m == 1) {
          if (j % 4 == 0) cnt = 4;
          else cnt = 3;
        } else {
          cnt = doomdays[m - 1];
        }
        //System.out.println(cnt);
        int diff;
        if (cnt > 1) diff = (cnt - 1) % 7;
        else diff = (1 - cnt) % 7;
        int d = (doom - diff) % 7;
        if (d < 0) {
          d += 7;
        }
        String day = "";
        switch (d) {
          case 0:
            day = "Sunday";
            break;
          case 1:
            day = "Monday";
            break;
          case 2:
            day = "Tuesday";
            break;
          case 3:
            day = "Wednesday";
            break;
          case 4:
            day = "Thursday";
            break;
          case 5:
            day = "Friday";
            break;
          case 6:
            day = "Saturday";
            break;
        }
        if(d == 0){
          sum++;
        }
        System.out.println("01."+m+"."+j+": Day = " + day);
      }

    }
    System.out.println(sum);
  }

}
