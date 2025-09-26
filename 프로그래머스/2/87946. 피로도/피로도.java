class Solution {
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        
        dfs(0, k, dungeons, new boolean[dungeons.length]);
        
        return answer;
    }
    
    public void dfs(int index, int current, int[][] dungeons, boolean[] visited) {
        answer = Math.max(answer, index);
            
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i]) continue;
            if (current < dungeons[i][0]) continue;
            visited[i] = true;
            dfs(index+1, current-dungeons[i][1], dungeons, visited);
            visited[i] = false;
        }
    }   
}