package problem31;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class CoinCount {

  static int[][] count;
  static int[] possibilities = new int[]{1,2,5,10,20,50,100,200};
  public static void main(String[] args) {
      int betrag = 200;

    count = new int[possibilities[possibilities.length-1]][possibilities.length];
    for(int i = 0;i<count.length;i++){
      for(int j = 0;j<count[i].length;j++){
        count[i][j] = -1;
      }
    }
    System.out.println(countCoin(betrag));

  }
  static int countCoin (int g, int i){ // Methode
    if(g<0){
      return 0;
    }
    if(g==0){
      return 1;
    }
    if(i==0){
      if(g%possibilities[0]==0){
        return 1;
      }
      return 0;
    }
    if(count[(g-1)%200][i]!=-1){
      return count[(g-1)%200][i];
    }
     int e  = countCoin(g,i-1)+ countCoin(g-possibilities[i],i);
    count[(g-1)%200][i] = e;
    return e;
  }

  static int countCoin(int betrag){
    for(int i = 1;i<=betrag;i++){
      for(int j = 0;j<possibilities.length;j++){
        if(j == possibilities.length-1&&i == betrag){
          return countCoin(i,j);
        }
        countCoin(i,j);
      }
    }
    return 0;
  }

}
