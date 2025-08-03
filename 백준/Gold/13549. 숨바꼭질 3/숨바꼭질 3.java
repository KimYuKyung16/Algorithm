import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, K;
  static int answer;
  static int[] calc = {2,-1,1};
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 수빈이 위치
    K = Integer.parseInt(st.nextToken()); // 동생 위치
    visited = new boolean[100001];

    bfs();
  }

  public static void bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {N, 0});

    while(!queue.isEmpty()) {
      int[] current = queue.poll();

      if (current[0] == K) {
        System.out.println(current[1]);
        break;
      }

      for (int i=0; i<3; i++) {
        if (i == 0) {
          int calcNum = current[0] * calc[i];
          if (calcNum >= 100001 || visited[calcNum]) continue;
          visited[calcNum] = true;
          queue.add(new int[] {calcNum, current[1]});
        } else {
          int calcNum = current[0] + calc[i];
          if (calcNum >= 100001 || calcNum < 0 || visited[calcNum]) continue;
          visited[calcNum] = true;
          queue.add(new int[] {calcNum, current[1]+1});
        }
      }
    }
  }
}
