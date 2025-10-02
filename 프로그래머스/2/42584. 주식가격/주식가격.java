import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { prices[0], 0 });
        for (int i=1; i<n; i++) {
            while(!stack.isEmpty()) {
                int[] top = stack.peek();
                if (top[0] <= prices[i]) break;
                answer[top[1]] = i - top[1];
                stack.pop();  
            }     
            stack.push(new int[] { prices[i], i });
        }
        
        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            answer[top[1]] = n - 1 - top[1];
        }
        
        return answer;
    }
}
