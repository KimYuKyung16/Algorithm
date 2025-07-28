import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
    
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] answer = new int[N];

    int[][] tops = new int[N][2];
    st = new StringTokenizer(br.readLine());
    for (int i=N-1; i>=0; i--) {
      tops[i] = new int[] {Integer.parseInt(st.nextToken()), N-i-1};
    }

    Stack<int[]> stack = new Stack<>();
    for (int[] top : tops) {
      if (stack.isEmpty()) {
        stack.push(top);
      } else {
        // 레이저 신호 수신 받을 수 있는 경우
        while(!stack.isEmpty() && stack.peek()[0] <= top[0]) {
          int[] current = stack.pop();
          int index = current[1];

          answer[index] = top[1] + 1;
        }

        stack.push(top);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int n : answer) {
      sb.append(n).append(" ");
    }

    System.out.println(sb);
  }
}
