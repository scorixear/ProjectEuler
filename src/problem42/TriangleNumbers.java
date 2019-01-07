package problem42;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class TriangleNumbers {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("C:/Users/pk/IdeaProjects/Project Euler/src/problem42/words.txt"), StandardCharsets.UTF_8);
    TreeSet<String> words = new TreeSet<>();
    for (String line : lines) {
      String[] names = line.replaceAll("\"","").split(",");
      words.addAll(Arrays.asList(names));
    }
    int count = 0;
    for(String word: words){
      int sum = 0;
      for(char c : word.toCharArray()){
        sum += c-64;
      }
      double n = Math.sqrt(0.25+2*sum)-1/2.0;
      if(n==(int)n){
        count++;
      }
    }
    System.out.println(count);

  }

}
