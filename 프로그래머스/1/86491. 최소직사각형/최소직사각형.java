class Solution {
    public int solution(int[][] sizes) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i=0; i<sizes.length; i++) {
            max = Math.max(max, Math.max(sizes[i][0], sizes[i][1]));
            min = Math.max(min, Math.min(sizes[i][0], sizes[i][1]));
        }
        return max*min;
    }
}