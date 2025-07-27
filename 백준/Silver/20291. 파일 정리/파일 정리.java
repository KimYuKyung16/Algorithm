import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    Map<String, Integer> count = new HashMap<>();

    for (int i=0; i<N; i++) {
      String ext = br.readLine().split("\\.")[1];
      count.put(ext, count.getOrDefault(ext, 0)+1);
    }

    String[] keys = count.keySet().toArray(new String[0]);
    Arrays.sort(keys);

    StringBuilder sb = new StringBuilder();
    for (String key : keys) {
      sb.append(key + " " + count.get(key)).append("\n");
    }
    System.out.println(sb);
  }
}
