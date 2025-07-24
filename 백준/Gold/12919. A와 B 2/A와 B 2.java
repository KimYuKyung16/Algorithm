import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static String S;
  static int answer = 0;
  
  public static void main(String[] args) throws Exception {
    S = br.readLine();
    StringBuilder T = new StringBuilder(br.readLine());
    dfs(T);
    System.out.println(answer);
  }

  public static void dfs(StringBuilder sb) {
    if (answer == 1 || sb.length() == 0) return;
    if (sb.toString().equals(S)) {
      answer = 1;
      return;
    }

    if (sb.charAt(sb.length()-1) == 'A') {
      StringBuilder nsb = new StringBuilder(sb);
      nsb.deleteCharAt(nsb.length()-1);
      dfs(nsb);
    } 

    sb.reverse();
    if (sb.charAt(sb.length()-1) == 'B') {
      StringBuilder nsb = new StringBuilder(sb);
      nsb.deleteCharAt(nsb.length()-1);
      dfs(nsb);
    }
  }
}
