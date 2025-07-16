import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    Deque<int[]> deque = new ArrayDeque<>();
    for (int i=0; i<N; i++) {
      deque.add(new int[] {Integer.parseInt(st.nextToken()), i+1});
    }

    StringBuilder sb = new StringBuilder();
    int[] next = deque.pollFirst();
    sb.append(next[1]).append(" ");
    while(!deque.isEmpty()) {
      if (next[0] > 0) {
        for (int i=0; i<next[0]-1; i++) {
          deque.addLast(deque.pollFirst());
        }
        int[] current = deque.pollFirst();
        sb.append(current[1]).append(" ");
        next = current;
      } else {
        for (int i=0; i<Math.abs(next[0])-1; i++) {
          deque.addFirst(deque.pollLast());
        }
        int[] current = deque.pollLast();
        sb.append(current[1]).append(" ");
        next = current;
      }
    }

    System.out.println(sb.toString().trim());
  }
}
