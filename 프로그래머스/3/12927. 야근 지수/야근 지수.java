import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for (int work : works) {
            pq.add(work);
        }
        
        for (int i=0; i<n; i++) {
            int max = pq.poll();
            if (max == 0) return 0;
            pq.add(max-1);
        }
        
        while(!pq.isEmpty() && pq.peek() != 0) {
            int current = pq.poll();
            answer += (current * current);
        }
        
        return answer;
    }
}