import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a,b) -> {
            if (a[1] == b[1]) {
                return Double.compare(a[0], b[0]);
            } else {
                return Double.compare(b[1], a[1]);
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<stages.length; i++) {
            map.put(stages[i], map.getOrDefault(stages[i], 0) + 1);
        }

        for (int i=1; i<=N; i++) {
            int c = map.getOrDefault(i, 0);
            int psum = 0;
            for (int j=i; j<=N+1; j++) {
                psum += map.getOrDefault(j, 0);
            }
            pq.add(new double[] {(double)i, psum == 0 ? 0 : (double)c/psum});
        }
        
        int[] answer = new int[N];
        int len = pq.size();
        for (int i=0; i<len; i++) {
            answer[i] = (int)(pq.poll()[0]);
        }
        return answer;
    }
}