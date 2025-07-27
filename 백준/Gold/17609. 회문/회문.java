import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();

    for (int i=0; i<T; i++) {
      String str = br.readLine();
      int answer = 0;

      int p1 = 0;
      int p2 = str.length() - 1;
      while(p1 <= p2) {
        if (str.charAt(p1) == str.charAt(p2)) {
          p1++;
          p2--;
        } else {
          if (check(str, p1+1, p2) || check(str, p1, p2-1)) {
            answer = 1;
          } else {
            answer = 2;
          }
          break;
        }
      }
      
      result.append(answer).append("\n");
    }

    System.out.println(result);
  }

  public static boolean check(String str, int left, int right) {
    while(left <= right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
