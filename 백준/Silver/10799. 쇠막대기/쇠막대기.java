import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    char[] list = br.readLine().toCharArray();
    int answer = 0;
    
    int closeCount = 0;
    Stack<Character> stack = new Stack<>();
    for (int i=0; i<list.length; i++) {
      if (list[i] == '(') {
        stack.push(list[i]);
      } else {
        if (list[i-1] == ')') {
          stack.pop();
          closeCount++;
        } else { // 레이저
          stack.pop();
          answer += (stack.size() + closeCount);
          closeCount = 0;
        }
      }
    }

    System.out.println(answer + closeCount);
  }
}
