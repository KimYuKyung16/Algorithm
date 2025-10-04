function solution(numbers, hand) {
    let answer = '';
    const keypad = {
        '1':[0,0],
        '2':[0,1],
        '3':[0,2],
        '4':[1,0],
        '5':[1,1],
        '6':[1,2],
        '7':[2,0],
        '8':[2,1],
        '9':[2,2],
        '*':[3,0],
        '0':[3,1],
        '#':[3,2]
    }
    
    let left = '*';
    let right = '#';
    for (num of numbers) {
        if (num === 1 || num === 4 || num === 7) {
            answer += 'L';
            left = num;
        } else if (num === 3 || num === 6 || num === 9) {
            answer += 'R';
            right = num;
        } else {
            let lc = Math.abs(keypad[left][0] - keypad[num][0]) + Math.abs(keypad[left][1] - keypad[num][1]);
            let rc = Math.abs(keypad[right][0] - keypad[num][0]) + Math.abs(keypad[right][1] - keypad[num][1]);
            
            if (lc > rc) {
                answer += 'R';
                right = num;
            } else if (rc > lc) {
                answer += 'L';
                left = num;
            } else {
                if (hand === 'right') {
                    answer += 'R';
                    right = num;
                } else {
                    answer += 'L';
                    left = num;
                }
            }
        }
    }
    
    return answer;
}
