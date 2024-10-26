// n: 벽 길이
// m: 롤러의 길이
// section: 다시 칠해야하는 구역

function solution(n, m, section) {
    let answer = 0;
    let painted = new Array(n+1).fill(0);
    
    for (s of section) {
        if (painted[s]) continue;
        for (let i=s; i<s+m; i++) {
            painted[i] = 1;
        }
        answer++;
    }
    
    return answer;
}