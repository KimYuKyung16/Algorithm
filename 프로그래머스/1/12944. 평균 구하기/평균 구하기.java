class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for (int v : arr) {
            sum += v;
        }
        return (double) sum / arr.length;
    }
}