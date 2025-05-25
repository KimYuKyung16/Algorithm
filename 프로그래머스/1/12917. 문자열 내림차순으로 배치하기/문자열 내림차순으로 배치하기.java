import java.util.*;
class Solution {
    public String solution(String s) {
        char[] list = s.toCharArray();
        Arrays.sort(list);
        return new StringBuilder(new String(list)).reverse().toString();
    }
}