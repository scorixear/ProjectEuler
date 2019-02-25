package problem54;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Paul Keller
 * @version 1.0
 */
public class Poker {
  public static void main(String[] args) throws FileNotFoundException {


    FileReader read = new FileReader("C:/Users/pk/IdeaProjects/Project Euler/src/problem54/poker.txt");
    BufferedReader br = new BufferedReader(read);
    AtomicInteger count = new AtomicInteger();
    AtomicInteger lines = new AtomicInteger();
    lines.getAndIncrement();
    br.lines().forEach(x -> {
      Poker p = new Poker(x);
      int e = p.check();
      if (e==0) {
        count.getAndIncrement();
        System.out.println(lines.getAndIncrement()+" : Player One");
      }else if(e==1){
        System.out.println(lines.getAndIncrement()+" : Player Two");
      }else{
        System.out.println(lines.getAndIncrement()+" : Draw");
      }
    });
    System.out.println(count);
  }


  Card[] A;
  Card[] B;

  Poker(String hands) {
    A = new Card[5];
    B = new Card[5];
    String[] cards = hands.split(" ");
    for (int i = 0; i < cards.length; i++) {
      if (i > 4) {
        B[i - 5] = new Card(cards[i]);
      } else {
        A[i] = new Card(cards[i]);
      }
    }
  }

  public int check() {
    int[] a = checkCard(A);
    int[] b = checkCard(B);
    for (int i = 0; i < a.length; i++) {
      if (a[i] > b[i]) {
        return 0;
      } else if (b[i] > a[i]) {
        return 1;
      } else if (a[i] == b[i] && a[i] != -1) {
        return checkBigger(A, B);
      }
    }
    return 2;
  }

  private int[] checkCard(Card[] a) {
    int rf = checkRoyalFlush(a);
    int sf = checkStraightFlush(a);
    int fk = checkFourKind(a);
    int fh = checkFullHouse(a);
    int f = checkFlush(a);
    int s = checkStraight(a);
    int tk = checkThreeKind(a);
    int tp = checkTwoPairs(a);
    int op = checkOnePair(a);
    int b = findBiggest(a).value;
    return new int[]{rf, sf, fk, fh, f, s, tk, tp, op, b};
  }


  int checkOnePair(Card[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i].value == a[j].value) {
          return a[i].value;
        }
      }
    }
    return -1;
  }

  int checkTwoPairs(Card[] a) {
    Card pair1 = null;
    Card pair2 = null;
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i].value == a[j].value) {
          if (pair1 == null) {
            pair1 = a[i];
          } else if (!pair1.equals(a[i]) && !pair1.equals(a[j])) {
            pair2 = a[i];
            break;
          }
        }
      }
    }
    if (pair1 == null || pair2 == null) return -1;
    return pair1.value > pair2.value ? pair1.value : pair2.value;
  }

  int checkThreeKind(Card[] a) {
    Map<Integer, Integer> values = new HashMap<>();
    for (Card c : a) {
      if (values.containsKey(c.value))
        values.replace(c.value, values.get(c.value) + 1);
      else
        values.put(c.value, 1);
    }
    int max = -1;
    for (Integer c : values.keySet()) {
      if (values.get(c) >= 3 && max < c)
        max = c;
    }
    return max;
  }

  int checkStraight(Card[] a) {
    ArrayList<Card> set = new ArrayList<>(Arrays.asList(a));
    set.sort(Comparator.naturalOrder());
    int last = -1;
    int i = 0;
    for (Card c:set) {
      if(i == set.size()-1){
        if(c.value==14&&set.get(0).value==2){
          return last;
        }
      }
      if (last != -1 && last + 1 != c.value)
        return -1;
      else
        last = c.value;
      i++;
    }
    return last;
  }

  int checkFlush(Card[] a) {
    int color = a[0].color;
    for (Card c : a) {
      if (c.color != color) {
        return -1;
      }
    }
    return findBiggest(a).value;
  }

  //TODO
  int checkFullHouse(Card[] a) {
    //Three kind
    Map<Integer, Integer> values = new HashMap<>();
    for (Card c : a) {
      if (values.containsKey(c.value))
        values.replace(c.value, values.get(c.value) + 1);
      else
        values.put(c.value, 1);
    }
    int three = -1;
    int pair = -1;
    for (Integer c : values.keySet()) {
      if (values.get(c) == 3)
        three = c;
      else if (values.get(c) == 2) {
        pair = c;
      } else {
        return -1;
      }
    }
    if (three == -1 || pair == -1)
      return -1;
    return three*15 + pair;
  }

  private int checkFourKind(Card[] a) {
    Map<Integer, Integer> values = new HashMap<>();
    for (Card c : a) {
      if (values.containsKey(c.value))
        values.replace(c.value, values.get(c.value) + 1);
      else
        values.put(c.value, 1);
    }
    int max = -1;
    for (Integer c : values.keySet()) {
      if (values.get(c) >= 4 && max < c)
        max = c;
    }
    return max;
  }

  private int checkStraightFlush(Card[] a) {
    int x = checkStraight(a);
    if (x > 0) {
      int y = checkFlush(a);
      if (y > 0) {
        return findBiggest(a).value;
      }
    }
    return -1;
  }

  private int checkRoyalFlush(Card[] a) {
    int suit = a[0].color;
    int t = 1, j = 1, q = 1, k = 1, as = 1;
    for (Card c : a) {
      if (suit == c.color) {
        if (c.value == 10) {
          if (t == 1)
            t--;
          else
            return -1;
        } else if (c.value == 11) {
          if (j == 1)
            j--;
          else
            return -1;
        } else if (c.value == 12) {
          if (q == 1)
            q--;
          else
            return -1;
        } else if (c.value == 13) {
          if (k == 1)
            k--;
          else
            return -1;
        } else if (c.value == 14) {
          if (as == 1)
            as--;
          else
            return -1;
        }
      } else
        return -1;
    }
    return 1;
  }

  private int checkBigger(Card[] a, Card[] b){
    ArrayList<Card> aset = new ArrayList<>(Arrays.asList(a));
    ArrayList<Card> bset = new ArrayList<>(Arrays.asList(b));
    aset.sort(Comparator.reverseOrder());
    bset.sort(Comparator.reverseOrder());

   for(int i = 0;i<aset.size();i++){
     if(aset.get(i).value>bset.get(i).value)
       return 0;
     else if(bset.get(i).value>aset.get(i).value)
       return 1;
   }

    return 2;
  }
  private Card findBiggest(Card[] a) {
    ArrayList<Card> set = new ArrayList<>(Arrays.asList(a));
    set.sort(Comparator.reverseOrder());
    return set.get(0);
  }

}
