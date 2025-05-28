import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] ranks = {6,6,5,4,3,2,1};
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int zeroCount = 0;
        for (int i=0; i<lottos.length; i++) {
            if (lottos[i] == 0) zeroCount++;
            else break;
        }
        int index = zeroCount-1 == -1 ? 0 : zeroCount-1;
        int correct = 0;
        for (int wn : win_nums) {
            while(true) {
                if (index >= lottos.length) break; 
                if (lottos[index] == wn) {
                    correct++;
                    index++;
                } else if (lottos[index] < wn) {
                    index++;
                } else {
                    break;
                }
            }
        }
        return new int[] {ranks[correct + zeroCount], ranks[correct]};
    }
}