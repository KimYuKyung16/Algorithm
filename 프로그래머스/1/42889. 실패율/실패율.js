function solution(N, stages) {
    let answer = [];
    let counts = new Array(N+2).fill(0);
    let totals = new Array(N+2).fill(0);
    
    for (s of stages) {
        for (let i=1; i<=s; i++) {
            counts[i]++;
        }
        totals[s]++;
    }
    
    for (let i=1; i<=N; i++) {
        answer.push([i, totals[i] / counts[i]]);
    }
    
    answer.sort((a,b) => {
        if (a[1] === b[1]) {
            return a[0] - b[0];
        } else {
            return b[1] - a[1];
        }
    })
    
    return answer.map((x) => x[0]);
}