class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for (int i=0; i<times.length; i++) {
            max = Math.max(max, times[i]);
            min = Math.min(min, times[i]);
        }
        
        long maxVal = max * (n / times.length);
        long minVal = min * (n / times.length);
        while(minVal <= maxVal) {
            long mid = (maxVal + minVal) / 2;
            if (isAvailable(mid, n, times)) {
                answer = mid;
                maxVal = mid - 1;
            } else {
                minVal = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean isAvailable(long t, int n, int[] times) {
        long count = 0;
        for (int i=0; i<times.length; i++) {
            count += (t / times[i]);
        }
        return count >= n;
    }
}