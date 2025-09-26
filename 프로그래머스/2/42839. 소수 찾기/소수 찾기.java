import java.util.*;

class Solution {
    static char[] nums;
    static int len;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        nums = numbers.toCharArray();
        len = nums.length;
        
        dfs(0, "", new boolean[len]);
        
        for (int n : set) {
            if (isPrime(n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) return false; 
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public void dfs(int index, String str, boolean[] visited) {
        if (!str.equals("")) {
            set.add(Integer.parseInt(str));
        }
        
        for (int i=0; i<len; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(index+1, str + nums[i], visited);
            visited[i] = false;
        }
        
    }
}