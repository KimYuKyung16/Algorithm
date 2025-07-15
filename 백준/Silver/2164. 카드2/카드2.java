import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    
    Deque<Integer> deque = new LinkedList<>();
    for (int i=1; i<=N; i++) {
      deque.add(i);
    }

    while(deque.size() > 1) {
      deque.pollFirst();
      deque.addLast(deque.pollFirst());
    } 

    System.out.println(deque.peek());
  }
}
