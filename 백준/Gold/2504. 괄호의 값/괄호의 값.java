import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] str = br.readLine().toCharArray();

    Stack<Character> stack = new Stack<>();
    int temp = 1;
    int result = 0;

    for (int i = 0; i < str.length; i++) {
      char c = str[i];

      if (c == '(') {
        stack.push(c);
        temp *= 2;
      } else if (c == '[') {
        stack.push(c);
        temp *= 3;
      } else if (c == ')') {
        if (stack.isEmpty() || stack.peek() != '(') {
          System.out.println(0);
          return;
        }
        if (str[i - 1] == '(') result += temp;
        stack.pop();
        temp /= 2;
      } else if (c == ']') {
        if (stack.isEmpty() || stack.peek() != '[') {
          System.out.println(0);
          return;
        }
        if (str[i - 1] == '[') result += temp;
        stack.pop();
        temp /= 3;
      }
    }

    if (!stack.isEmpty()) {
      System.out.println(0);
    } else {
      System.out.println(result);
    }
  }
}
