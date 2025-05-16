import java.io.*;
import java.util.*;
public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws Exception{
    char[] S = br.readLine().toCharArray();
    char[] T = br.readLine().toCharArray();
    Deque<Character> list = new ArrayDeque<>();
    for (char c : T) {
      list.add(c);
    }

    boolean reverse = false; // true는 거꾸로, false는 그대로
    while(list.size() > S.length) {
      if (reverse) {
        char current = list.peekFirst();
        if (current == 'A') {
          list.removeFirst();
        } else {
          list.removeFirst();
          reverse = !reverse;
        }
      } else {
        char current = list.peekLast();
        if (current == 'A') {
          list.removeLast();
        } else if (current == 'B'){
          list.removeLast();
          reverse = !reverse;
        }
      }
    }

    int index = 0;
    if (reverse) {
      for (char c : list) {
        if (c != S[S.length - 1 - index]) {
          System.out.println(0);
          return;
        }
        index++;
      }
    } else {
      for (char c : list) {
        if (c != S[index]) {
          System.out.println(0);
          return;
        }
        index++;
      }
    }
    System.out.println(1);
    return;
  }
}
