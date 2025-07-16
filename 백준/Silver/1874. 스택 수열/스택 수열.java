import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
  public static void main(String[] args) throws Exception {
    int n = Integer.parseInt(br.readLine());

    int[] nums = new int[n];
    for (int i=0; i<n; i++) {
      nums[i] = Integer.parseInt(br.readLine());
    }

    StringBuilder sb = new StringBuilder();

    int index = 0;
    int currentNum = 1;
    Stack<Integer> stack = new Stack<>();
    while(true) {
      if (currentNum == (n+1) && stack.isEmpty()) break;
      if (!stack.isEmpty() && index < n && stack.peek() == nums[index]) {
        stack.pop();
        sb.append("-").append("\n");
        index++;
      } else {
        if (currentNum > n) {
          sb.setLength(0);
          sb.append("NO");
          break;
        }
        stack.push(currentNum);
        sb.append("+").append("\n");
        currentNum++;
      }
    }

    System.out.println(sb);
  }
}
