import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();

    StringBuilder sb = new StringBuilder();

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch(command) {
        case "push":
          int num = Integer.parseInt(st.nextToken());
          stack.push(num);
          break;
        case "pop":
          sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
          break;
        case "size":
          sb.append(stack.size()).append("\n");
          break;
        case "empty":
          sb.append(stack.isEmpty() ? 1 : 0).append("\n");
          break;
        case "top":
          sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
          break;
      }
    }

    System.out.println(sb);
  }
}
