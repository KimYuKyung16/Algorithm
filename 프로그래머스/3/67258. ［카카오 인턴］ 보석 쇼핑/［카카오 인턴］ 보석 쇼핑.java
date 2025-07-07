import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> jewSet = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> count = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while(true) {
            if (count.size() == jewSet.size()) {
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                
                if (count.get(gems[left])-1 == 0) {
                    count.remove(gems[left]);
                } else {
                    count.put(gems[left], count.get(gems[left])-1);
                }
                left++; 
            } else {
                if (right >= gems.length) break;
                if (count.get(gems[right]) != null) {
                    count.put(gems[right], count.get(gems[right])+1);
                } else {
                    count.put(gems[right], 1);
                }
                right++;
            }
        }
        
        return answer;
    }
}