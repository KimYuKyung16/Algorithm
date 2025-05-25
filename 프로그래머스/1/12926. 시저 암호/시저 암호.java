class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
                continue;
            }
            if ((s.charAt(i) >= 97 && s.charAt(i) <= 122) && n+s.charAt(i) > 122) {
                sb.append((char)(n+s.charAt(i) - 26)); 
            } else if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) && n+s.charAt(i) > 90) {
                sb.append((char)(n+s.charAt(i) - 26)); 
            } else {
                sb.append((char)(n+s.charAt(i))); 
            }
        }
        return sb.toString();
    }
}