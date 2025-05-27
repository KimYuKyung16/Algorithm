import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] persons = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] corrects = new int[3];
        for (int i=0; i<answers.length; i++) {
            for (int j=0; j<3; j++) {
                if (answers[i] == persons[j][i%persons[j].length]) {
                    corrects[j]++;
                }
            }            
        }
        int max = 0;
        for (int correct : corrects) {
            max = Math.max(max, correct);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<3; i++) {
            if (max == corrects[i]) {
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}