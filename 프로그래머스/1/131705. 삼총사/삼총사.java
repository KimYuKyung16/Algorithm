import java.util.*;
class Solution {
    int[] numbers;
    int answer = 0;
    public int solution(int[] number) {
        numbers = number;
        dfs(0, 0, new int[3]);
        return answer;
    }
    public void dfs(int depth, int current, int[] list) {
        if (depth == 3) {
            int sum = 0;
            for (int index : list) {
                sum += numbers[index];
            }
            if (sum == 0) answer++;
            return;
        }
        for (int i=current; i<numbers.length; i++) {
            list[depth] = i;
            dfs(depth+1, i+1, list);
        }
    };
}