import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws Exception {
    Map<String, Integer> nameMap = new HashMap<>();

    int length = 0;
    String line;
    while ((line = br.readLine()) != null) {
      nameMap.put(line, nameMap.getOrDefault(line, 0) + 1);
      length++;
    }

    String[] keys = nameMap.keySet().toArray(new String[0]);
    Arrays.sort(keys, (a,b) -> a.compareTo(b));

    StringBuilder sb = new StringBuilder();

    for (String key : keys) {
      sb.append(key).append(" ");
      sb.append(String.format("%.4f", (double)nameMap.get(key) / (double) length * 100));
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
