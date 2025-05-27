class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true) {
            if (Math.max(bill[0], bill[1]) <= Math.max(wallet[0], wallet[1]) && Math.min(bill[0], bill[1]) <= Math.min(wallet[0], wallet[1])) return answer;
            if (Math.max(bill[0], bill[1]) == bill[0]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
    }
}