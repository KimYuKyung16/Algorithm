import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    String list = "AFC";
    for (int i=0; i<T; i++) {
      char[] str = br.readLine().toCharArray();
      String answer = "Infected!";

      int index = 0;
      for (int j=0; j<str.length; j++) {
        if (j == 0) {
          if (str[j] >= 'A' && str[j] <= 'F') {
            continue;
          }
          else {
            answer = "Good";
            break;
          }
        } else {
          if (str[j] != str[j-1]) { // 이전과 다른 경우
            if (j == str.length-1) {
              if (str[j] < 'A' || str[j] > 'F') {
                answer = "Good";
                break;
              }
            }
            if (j == 1 && str[j] == 'A') continue;
            index++;
          }
          if (index >= list.length() || str[j] != list.charAt(index)) { // 현재 있어야 하는 값이 아닌 경우
            answer = "Good";
            break;
          }
        }
      }

      sb.append(answer).append("\n");
    }

    System.out.println(sb);
  }
}
