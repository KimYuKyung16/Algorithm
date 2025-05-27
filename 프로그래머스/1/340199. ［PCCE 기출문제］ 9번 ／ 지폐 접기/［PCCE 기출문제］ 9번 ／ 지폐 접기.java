class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int wmax = Math.max(wallet[0], wallet[1]);
        int wmin = Math.min(wallet[0], wallet[1]);
        int max = Math.max(bill[0], bill[1]);
        int min = Math.min(bill[0], bill[1]);
        while(true) {
            if (max <= wmax && min <= wmin) return answer;
            max = max/2;
            if (max < min) {
                int temp = max;
                max = min;
                min = temp;
            } 
            answer++;
        }
    }
}