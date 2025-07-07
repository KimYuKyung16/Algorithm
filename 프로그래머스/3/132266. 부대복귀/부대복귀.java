import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n+1];
        
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<roads.length; i++) {
            int v1 = roads[i][0];
            int v2 = roads[i][1];
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
         
        int[] visited = bfs(destination, n);
        
        for (int i=0; i<sources.length; i++) {
            if (visited[sources[i]] == 0) {
                answer[i] = -1;
            } else if (sources[i] == destination) {
                answer[i] = 0;
            } else {
                answer[i] = visited[sources[i]];
            }
        }
        
        return answer;
    }
    
    public int[] bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n+1];
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int v : graph[current]) {
                if (visited[v] != 0) continue;
                visited[v] = visited[current]+1;
                queue.add(v);
            }
        }

        return visited;
    }
}