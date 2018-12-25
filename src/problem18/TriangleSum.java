package problem18;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class TriangleSum {
  public static void main(String[] args) {
    int[][] nums = new int[][]{
                      {75},
                     {95,64},
                    {17,47,82},
                   {18,35,87,10},
                  {20,4,82,47,65},
                 {19,1,23,75,3,34},
                {88,2,77,73,7,63,67},
               {99,65,4,28,6,16,70,92},
              {41,41,26,56,83,40,80,70,33},
             {41,48,72,33,47,32,37,16,94,29},
            {53,71,44,65,25,43,91,52,97,51,14},
           {70,11,33,28,77,73,17,78,39,68,17,57},
          {91,71,52,38,17,14,91,43,58,50,27,29,48},
         {63,66,4,68,89,53,67,30,73,16,69,87,40,31},
        {4,62,98,27,23,9,70,98,73,93,38,53,60,4,23}};
    int[][] nums2 = new int[][]{
           {3},
          {7,4},
         {2,4,6},
        {8,5,9,3}};
    //brute force
    int maxsum = 0;

    for(int i = 0;i<=16383;i++){
      String s= Integer.toBinaryString(i);
      while(s.length()<14)s="0"+s;
      int x = 0;
      int y = 0;
      int sum = nums[y][x];
      for(char c:s.toCharArray()){
        y++;
        if(c=='1')x++;
        sum+=nums[y][x];
      }
      if(sum>maxsum)maxsum=sum;
    }
    System.out.println(maxsum);

    //greedy
    maxsum = 0;
    int x = 0;
    int y = 0;
    while(true){
      maxsum+=nums[y][x];
      if(nums.length==y+1){
        break;
      }
      y++;
      if(nums[y][x+1]>nums[y][x])x++;
    }
    System.out.println(maxsum);

    //sum to the top
    y = nums.length-2;
    while(y>=0){
      for(x=0;x<nums[y].length;x++) {
        //System.out.println("Before "+nums[y][x]);
        //System.out.println("Compare "+nums[y + 1][x] +" > " + nums[y + 1][x + 1]);
        if (nums[y + 1][x] > nums[y + 1][x + 1]) {

          nums[y][x] += nums[y + 1][x];
        }
        else{
          nums[y][x] += nums[y + 1][x + 1];
        }
        //System.out.println("added "+nums[y][x]);
      }
      y--;
    }
    System.out.println(nums[0][0]);
  }



}
