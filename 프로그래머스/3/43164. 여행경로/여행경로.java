import java.util.*;

class Solution {
    static boolean[] visited;
    static PriorityQueue<List<String>> pq = new PriorityQueue<>((a,b) -> {
        for (int i=0; i<a.size(); i++) {
            int cmp = a.get(i).compareTo(b.get(i));
            if (cmp != 0) return cmp;
        }
        return 0;
    });
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        for (int i=0; i<tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                List<String> path = new ArrayList<>();
                path.add("ICN");
                path.add(tickets[i][1]);
                visited[i] = true;
                dfs(tickets, path);
                visited[i] = false;
            }
        }
        
        List<String> answer = pq.poll();
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String[][] tickets, List<String> path) {
        if (path.size() == tickets.length + 1) {
            pq.add(new ArrayList<>(path));
            return;
        }
        
        for (int i=0; i<tickets.length; i++) {
            if (!visited[i] && path.get(path.size()-1).equals(tickets[i][0])) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets, path);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }      
    }
}