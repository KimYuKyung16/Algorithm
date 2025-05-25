class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                index = 0;
            } else {
                if (index%2 == 0) sb.append(Character.toUpperCase(s.charAt(i)));
                else sb.append(Character.toLowerCase(s.charAt(i)));
                index++;
            }
        }
        return sb.toString();
    }
}