class Solution {
    public int solution(int n) {     
        boolean[] visited = new boolean[n+1];
        for (int i=2; i<=Math.sqrt(n); i++) {
            for (int j=i; j<=n; j+=i) {
                if (i == j) continue;
                visited[j] = true;
            }
        }
        int answer = 0;
        for (int i=2; i<visited.length; i++) {
            if (!visited[i]) answer++;
        }
        return answer;
    }
}