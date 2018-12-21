package problem15;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class LatticePaths {
  static int[][] paths;
  public static void main(String[] args) {
    paths = new int[21][21];
    for(int i = 0;i<21;i++){
      for(int j = 0;j<21;j++){
        paths[i][j]=-1;
      }
    }
    System.out.println(calculatePaths(0,3, 3));
  }

  private static int calculatePaths(int x, int y, int n) {
    if(x==n&&y==0){
      return 1;
    }
    if(y < 0 || x > n||y>n||x<0){
      return 0;
    }
    if(paths[x][y]!=-1){
      return paths[x][y];
    }
    int sum = calculatePaths(x+1,y,n)+calculatePaths(x,y-1,n);
    paths[x][y]=sum;
    return sum;
  }

}
