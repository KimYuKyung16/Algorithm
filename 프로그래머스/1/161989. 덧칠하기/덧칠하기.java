class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] completes = new boolean[n+1];
        for (int i=0; i<section.length; i++) {
            int current = section[i];
            if (completes[current]) continue;
            for (int j=current; j<current + m; j++) {
                if (j > n) {
                    answer++;
                    return answer;
                }
                completes[j] = true;
            }
            answer++;
        }
        return answer;
    }
}