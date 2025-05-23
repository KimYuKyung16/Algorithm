import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        String str = sb.reverse().toString();
        
        for (int i=0; i<str.length(); i++) {
            answer[i] = str.charAt(i) - '0';
        }
        
        return answer;
    }
}