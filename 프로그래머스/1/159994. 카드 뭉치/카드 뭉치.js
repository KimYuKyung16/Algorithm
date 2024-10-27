function solution(cards1, cards2, goal) {
    let index1 = 0;
    let index2 = 0;
    let goal_index = 0;
    
    for (let word of goal) {
        if (cards1[index1] === word) {
            index1++;
            goal_index++;
        } else if (cards2[index2] === word) {
            index2++;
            goal_index++;
        } else {
         return "No";   
        }
    }
    
    return "Yes";
}