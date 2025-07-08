import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->  a[1] - b[1]);
        
        int sum = 0;
        int count = 0;
        int time = 0;
        int index = 0;
        while(count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= time) {
                pq.add(jobs[index++]);
            }
            // 작업하기
            if (!pq.isEmpty()) {  
                int[] disk = pq.poll();
                time = time + disk[1];
                sum += time - disk[0];
                count++;
            } else {
                time++;
            }
        }
        
        return (int) (sum / jobs.length);
    }
}
