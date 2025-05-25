class Solution {
    public int solution(String s) {
        String[] word = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i=0; i<word.length; i++) {
            s = s.replaceAll(word[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}