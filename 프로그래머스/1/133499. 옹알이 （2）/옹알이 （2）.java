class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] blist = {"aya", "ye", "woo", "ma"};
        for (String b : babbling) {
            for (int i=0; i<blist.length; i++) {
                b = b.replaceAll(blist[i], ""+i);
            }
            boolean flag = true;
            for (int i=0; i<b.length(); i++) {
                if (!Character.isDigit(b.charAt(i))) {
                    flag = false;
                    break;
                }
                if (i != b.length()-1 && b.charAt(i) == b.charAt(i+1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}