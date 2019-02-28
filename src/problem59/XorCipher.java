package problem59;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class XorCipher {
  public static void main(String[] args) throws IOException {
    File f = new File("C:/Users/pk/IdeaProjects/pkeller1/ProjectEuler/src/problem59/cipher.txt");
    BufferedReader br = new BufferedReader(new FileReader(f));
    String s = br.lines().collect(Collectors.joining());
    br.close();
    File output = new File("C:/Users/pk/IdeaProjects/pkeller1/ProjectEuler/src/problem59/encoded.txt");
    BufferedWriter bw = new BufferedWriter(new FileWriter(output));
    int[] code =  Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
    int a=getFrequenzyKey(code,0,3,32);
    int b = getFrequenzyKey(code,1,3,32);
    int c = getFrequenzyKey(code,2,3,32);
    int[] encoded = encode(code,new int[]{a,b,c});
    StringBuilder build = new StringBuilder();
    for(int i= 0;i<encoded.length;i+=3)
      build.append(new String(new byte[]{(byte)encoded[i],(byte)encoded[i+1],(byte)encoded[i+2]}, StandardCharsets.US_ASCII));
    bw.write(build.toString());
    bw.close();
    System.out.println("a: "+a+"; b: "+b+"; c: "+c);
    System.out.println(Arrays.stream(encoded).sum());

  }

  private static int getFrequenzyKey(int[] text, int start, int step, int ascciChar) {
    HashMap<Integer,Integer> vals = new HashMap<>();
    for(int i = start;i<text.length;i+=step){
      if(vals.containsKey(text[i]))
        vals.replace(text[i],vals.get(text[i])+1);
      else
        vals.put(text[i], 1);
    }
    int max = 0;
    int maxkey= 0;
    for(Integer key:vals.keySet()){
      if(vals.get(key)>max){
        max = vals.get(key);
        maxkey=key;
      }
    }
    return maxkey^ascciChar;
  }

  private static int[] encode(int[] cipher, int[] keys){
    int[] encoded = new int[cipher.length];
    for(int i = 0;i<cipher.length;i++) {
      encoded[i]=cipher[i]^keys[i% keys.length];
    }
    return encoded;
  }
}
