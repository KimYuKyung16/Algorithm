import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
    
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Map<String, Integer> pocketmonName = new HashMap<>();
    Map<Integer, String> pocketmonId = new HashMap<>();
    for (int i=0; i<N; i++) {
      String name = br.readLine();
      pocketmonName.put(name, i+1);
      pocketmonId.put(i+1, name);
    }

    StringBuilder sb = new StringBuilder();
    for (int i=0; i<M; i++) {
      String input = br.readLine();
      char first = input.charAt(0);
      if ((first >= 'A' && first <= 'Z') || (first >= 'a' && first <= 'z')) {
        sb.append(pocketmonName.get(input)).append("\n");
      } else {
        sb.append(pocketmonId.get(Integer.parseInt(input))).append("\n");
      }
    }

    System.out.println(sb);
  }
}
