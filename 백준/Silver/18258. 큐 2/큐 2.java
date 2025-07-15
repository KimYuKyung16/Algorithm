import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    Queue<Integer> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "push":
          int num = Integer.parseInt(st.nextToken());
          queue.add(num);
          break;
        case "pop":
          sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
          break;
        case "size":
          sb.append(queue.size()).append('\n');
          break;
        case "empty":
          sb.append(queue.isEmpty() ? 1 : 0).append('\n');
          break;
        case "front":
          sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
          break;
        case "back":
          sb.append(queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).peekLast()).append('\n');
          break;
      }
    }
    System.out.print(sb);
  }
}
