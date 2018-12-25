/**
 * @author Paul Keller
 * @version 1.0
 */
public class TobiRätsel {
  public static void main(String[] args) {
    findWort(new char[]{'n','a','s','e','d'},0,new char[]{});
  }


  public static void findWort(char[] pool, int index, char[] used){
    if(index>4){
      System.out.println(used);
      return;
    }
    for(char c: pool){
      boolean contains =false;
      for(char a: used){
        if(a==c){
          contains=true;
          break;
        }
      }
      if(!contains){
        char[] newused = new char[used.length+1];
        for(int i = 0;i<used.length;i++){
          newused[i]=used[i];
        }
        newused[used.length]=c;
        findWort(pool,index+1, newused);
      }
    }

  }

}
