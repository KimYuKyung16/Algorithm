// 1. t개가 나올만큼 전체 값을 다 구해놓음.
// 2. p번씩 띄면서 값을 구함.
function solution(n, t, m, p) {
    let str = '';
    
    let num = 0;
    while(str.length <= (m*t)) {
        str += num.toString(n);
        num++;
    }
    
    let answer = '';
    let index = p-1;
    while(answer.length < t) {
        answer += str[index];
        index += m;
    }

    return answer.toUpperCase();
}