import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n == 1) return sticker[0];
        
        int[] dp = new int[n];
        int answer1 = 0;
        int answer2 = 0;
        
        dp[0] = sticker[0];
        dp[1] = Math.max(dp[0], sticker[1]);
        for (int i=2; i<n-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        answer1 = dp[dp.length-2];
        
        dp[0] = 0;
        dp[1] = sticker[1];
        for (int i=2; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        answer2 = dp[dp.length-1];
        
        return Math.max(answer1, answer2);
    }
}