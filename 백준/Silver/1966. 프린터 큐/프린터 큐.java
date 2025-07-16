import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i=0; i<T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      Queue<int[]> queue = new LinkedList<>();
      ArrayList<Integer> priorities = new ArrayList<>();

      st = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++) {
        int priority = Integer.parseInt(st.nextToken());
        priorities.add(priority);
        queue.add(new int[] {j, priority});
      }
    
      int pIndex = 0;
      priorities.sort((a,b) -> b-a);

      int index = 0;
      while(true) {
        int[] current = queue.poll();

        if (current[1] == priorities.get(pIndex)) {
          pIndex++;
          index++;

          if (current[0] == M) {
            sb.append(index).append('\n');
            break;
          }
        } else {
          queue.add(current);
        }
      }
    }

    System.out.println(sb);
  }
}
