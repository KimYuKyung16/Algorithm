import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int answer = 0;

    Map<String, Integer> map = new HashMap<>();

    for (int i=0; i<N; i++) {
      String word = br.readLine();
      map.put(word, 1);
    }

    for (int i=0; i<M; i++) {
      String word = br.readLine();
      if (map.get(word) != null) {
        answer++;
      }
    }

    System.out.println(answer);
  }
}
