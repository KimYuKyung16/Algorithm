import java.util.*;

class Solution {
    static Map<String, String> graph = new HashMap<>();
    static Map<String, Integer> amounts = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        
        // 1. 그래프 생성
        for (int i=0; i<referral.length; i++) {
            if (referral[i].equals("-")) continue;
            graph.put(enroll[i], referral[i]);
        }
        
        // 2. 계산
        for (int i=0; i<seller.length; i++) {
            dfs(seller[i], amount[i] * 100);
        }
        
        for (int i=0; i<enroll.length; i++) {
            answer[i] = amounts.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    public void dfs(String seller, int amount) {
        if (amount == 0) return;
        
        String parent = graph.get(seller);
        int remain = (int) (amount * 0.1);
        
        if (remain < 1) remain = 0;
  
        amounts.put(seller, amounts.getOrDefault(seller, 0) + amount - remain);
   
        dfs(parent, remain);
    }
}