package problem54;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Card implements Comparable<Card>{
  public int value;
  public int color;

  Card(String input){
    String v = input.substring(0,1).replaceAll("T","10").replaceAll("J", "11").replaceAll("Q","12").replaceAll("K","13").replaceAll("A","14");
    value = Integer.parseInt(v);
    color = input.toCharArray()[1];
  }

  @Override
  public int compareTo(Card o) {
    return Integer.compare(value, o.value);
  }
}
