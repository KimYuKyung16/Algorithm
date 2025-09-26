import java.util.*;

class Solution {
    static ArrayList<Integer>[] tree;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        tree = new ArrayList[n+1];
        
        for (int i=0; i<=n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int l = wire[0];
            int r = wire[1];
            
            tree[l].add(r);
            tree[r].add(l);
        }
        
        for (int[] wire : wires) {
            int l = wire[0];
            int r = wire[1];
            
            answer = Math.min(answer, Math.abs(bfs(n, l, r) - bfs(n, r, l)));
        }
        
        return answer;
    }
    
    public int bfs(int n, int start, int other) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        queue.add(start);
        int count = 1;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int num : tree[current]) {
                if (num == other) continue; 
                if (visited[num]) continue;
                visited[num] = true;
                queue.add(num);
                count++;
            }
        }
        
        return count;
    }
}