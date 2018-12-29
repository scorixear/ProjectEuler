package problem22;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class NameScore {
  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("C:/Users/pk/IdeaProjects/Project Euler/src/problem22/names.txt"), StandardCharsets.UTF_8);
    TreeSet<String> words = new TreeSet<>();
    for (String line : lines) {
      String[] names = line.replaceAll("\"","").split(",");
      words.addAll(Arrays.asList(names));
    }
    int sum = 0;
    int i = 1;
    for (String name : words) {
      name = name.replaceAll("\"","");
      int charsum = 0;
      for (char c : name.toCharArray()) {
        //System.out.println(c+" "+(int)c);
        charsum += c-64;
      }
      System.out.println(name + " " + charsum);
      sum+=charsum*i;
      System.out.println(charsum*i);
      i++;
    }
    System.out.println(sum);
  }

}
