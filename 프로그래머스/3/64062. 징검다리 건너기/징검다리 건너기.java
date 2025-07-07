class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i<stones.length; i++) {
            min = Math.min(min, stones[i]);
            max = Math.max(max, stones[i]);
        }
        
        while(min <= max) {
            int mid = (min + max) / 2;
            if (canCross(stones, mid, k)) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean canCross(int[] stones, int m, int k) {
        int count = 0;
        for (int stone : stones) {
            if (stone - m < 0) {
                count++;
                if (count >= k) return false;
            } else {
                count = 0;
            }
        }
        return true;
    }
}