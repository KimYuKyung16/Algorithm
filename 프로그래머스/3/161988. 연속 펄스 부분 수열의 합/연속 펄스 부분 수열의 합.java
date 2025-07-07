class Solution {
    public long solution(int[] sequence) {
        long answer = Integer.MIN_VALUE;
        int[] case1 = {1, -1};
        int[] case2 = {-1, 1};
        int[] sequence1 = sequence.clone();
        int[] sequence2 = sequence.clone();
        
        for (int i=0; i<sequence.length; i++) {
            sequence1[i] = sequence1[i] * case1[i%2];
        }
        for (int i=0; i<sequence.length; i++) {
            sequence2[i] = sequence2[i] * case2[i%2];
        }

        long [] dp1 = new long[sequence1.length];
        dp1[0] = sequence1[0];
        for (int i=1; i<sequence1.length; i++) {
            dp1[i] = Math.max(sequence1[i], sequence1[i] + dp1[i-1]);
        }

        long [] dp2 = new long[sequence2.length];
        dp2[0] = sequence2[0];
        for (int i=1; i<sequence2.length; i++) {
            dp2[i] = Math.max(sequence2[i], sequence2[i] + dp2[i-1]);
        }
        
        for (int i=0; i<dp1.length; i++) {
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
        
        return answer;
    }
}