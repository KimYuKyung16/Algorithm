import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    Set<String> set = new TreeSet<>((a,b) -> {
      if (a.length() == b.length()) {
        return a.compareTo(b);
      } else {
        return Integer.compare(a.length(), b.length());
      }
    });

    for (int i=0; i<N; i++) {
      set.add(br.readLine());
    }

    StringBuilder sb = new StringBuilder();
    for (String s : set) {
      sb.append(s).append("\n");
    }

    System.out.println(sb);
  }
}
