import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    char[] list = br.readLine().toCharArray();

    int[] nums = new int[N];
    for (int i=0; i<N; i++) {
      nums[i] = Integer.parseInt(br.readLine());
    }

    Stack<Double> stack = new Stack<>();
    for (char c : list) {
      if (c == '*') {
        double second = stack.pop();
        double first = stack.pop();
        stack.push(first * second);
      } else if (c == '+') {
        double second = stack.pop();
        double first = stack.pop();
        stack.push(first + second);
      } else if (c == '-') {
        double second = stack.pop();
        double first = stack.pop();
        stack.push(first - second);
      } else if (c == '/') {
        double second = stack.pop();
        double first = stack.pop();
        stack.push(first / second);
      } else {
        stack.push((double) (nums[c - 'A']));
      }
    }

    System.out.println(String.format("%.2f", stack.pop()));
  }
}
