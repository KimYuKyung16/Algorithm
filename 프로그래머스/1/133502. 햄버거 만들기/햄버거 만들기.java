import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> stack = new ArrayList<>();
        for (int ing : ingredient) {
            stack.add(ing);
            if (stack.size() >= 4) {
                int n = stack.size();
                if (stack.get(n-4) == 1 &&
                    stack.get(n-3) == 2 &&
                    stack.get(n-2) == 3 &&
                    stack.get(n-1) == 1) {
                    for (int i = 0; i < 4; i++) {
                        stack.remove(stack.size() - 1);
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}