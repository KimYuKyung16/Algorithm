class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] completes = new boolean[n+1];
        for (int i=0; i<section.length; i++) {
            if (completes[section[i]]) continue;
            for (int j=section[i]; j<section[i] + m; j++) {
                if (j > n) break; 
                completes[j] = true;
            }
            answer++;
        }
        return answer;
    }
}