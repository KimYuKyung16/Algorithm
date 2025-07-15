import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());

    Deque<Integer> deque = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch(command) {
        case "push_front":
        deque.addFirst(Integer.parseInt(st.nextToken()));
        break;
        case "push_back":
        deque.addLast(Integer.parseInt(st.nextToken()));
        break;
        case "pop_front":
        sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
        break;
        case "pop_back":
        sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
        break;
        case "size":
        sb.append(deque.size()).append("\n");
        break;
        case "empty":
        sb.append(deque.isEmpty() ? 1 : 0).append("\n");
        break;
        case "front":
        sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
        break;
        case "back":
        sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
        break;
      }
    }
  
    System.out.println(sb);
  }
  
}
