import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n+1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            int start = e[0];
            int end = e[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        
        return bfs(1, n);
    }
    
    public int bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        queue.add(start);
        int last_count = 0;
        
        int count = 1;
        while(!queue.isEmpty()) {
            last_count = count;
            int tmpCount = count;
            count = 0;
            for (int i=0; i<tmpCount; i++) {
                int current = queue.poll();
                for (int v : graph[current]) {
                    if (visited[v]) continue;
                    visited[v] = true;
                    queue.add(v);
                    count++;
                }
            }
        }
        
        return last_count;
    }
}