class Solution {
    public int solution(int n) {
        String reverse = new StringBuilder(Integer.toString(n,3)).reverse().toString();
        return Integer.parseInt(reverse, 3);
    }
}