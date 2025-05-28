import java.util.*;
class Solution {
    public int solution(String dartResult) {
        char[] results = dartResult.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<results.length; i++) {
            if (results[i] == 'S') {
                int num = stack.pop();
                stack.push((int)Math.pow(num, 1));
            } else if (results[i] == 'D') {
                int num = stack.pop();
                stack.push((int)Math.pow(num, 2));
            } else if (results[i] == 'T') {
                int num = stack.pop();
                stack.push((int)Math.pow(num, 3));
            } else if (results[i] == '*') {
                if (stack.size() > 1) {
                    int first = stack.pop() * 2;
                    int second = stack.pop() * 2;
                    stack.push(second);
                    stack.push(first);
                } else {
                    int first = stack.pop() * 2;
                    stack.push(first);
                }
            } else if (results[i] == '#') {
                stack.push(stack.pop() * -1);
            } else {
                if (i > 0 && Character.isDigit(results[i-1])) {
                    stack.pop();
                    stack.push(10);
                } else {
                    stack.push(results[i] - '0');  
                }
            }
        }
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }
}