import java.io.*;
import java.util.*;
public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    char[] str1 = br.readLine().toCharArray();
    char[] str2 = br.readLine().toCharArray();
    int[][] dp = new int[str1.length+1][str2.length+1];
    for (int i=1; i<=str1.length; i++) {
      for (int j=1; j<=str2.length; j++) {
        if (str1[i-1] == str2[j-1]) {
          // dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j-1]) + 1;
          dp[i][j] = dp[i-1][j-1] + 1;
        } else {
          // dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j-1]);
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    System.out.println(dp[str1.length][str2.length]);
  }
}
