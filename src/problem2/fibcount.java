package problem2;
/**
 * @author Paul Keller
 * @version 1.0
 */
public class fibcount {
  static long[] fib;
  static long sum;
  public static void main(String[] args) {
    fib = new long[3];
    fib[0]=1;
    fib[1]=1;
    long l;
    for(int i = 2;;i++){
      l  = fib(i);
      System.out.println(l);
      if(l>4000000)
      {
        if(l %2 == 0){
          sum-=l;
        }
        break;
      }
    }
    System.out.println(sum+" "+l);
  }

  public static long fib(int count){
    if(count<=2) return 1;

    long fibterm = fib[(count-1)%2]+fib[(count-2)%2];
    if(fibterm%2==0) sum+=fibterm;
    fib[count%2]=fibterm;
    return fibterm;


  }
}
