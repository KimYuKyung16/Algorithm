import java.util.*;
class Solution {
    static int[] numlist;
    static int answer = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    public int solution(int[] nums) {
        numlist = nums;
        dfs(0, 0, 0);
        sosu();
        return answer;
    }
    
    public void dfs(int depth, int start, int sum) {
        if (depth == 3) {
            list.add(sum);
            return;
        }
        for(int i=start; i<numlist.length; i++) {
            dfs(depth+1, i+1, sum+numlist[i]);
        }
    }
    
    public void sosu() {
        int max = Collections.max(list);
        boolean[] visited = new boolean[max+1];
        for (int i=2; i<=Math.sqrt(max); i++) {
            for (int j=i*2; j<=max; j+=i) {
                visited[j] = true;
            }
        }
        for (int num : list) {
            if (!visited[num]) {
                answer++;
            }
        }
    }
}