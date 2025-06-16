function solution(n, s) {
    const answer = [];
    
    let v = Math.floor(s/n);
    let remain = s%n;
   
    if (v === 0) return [-1];
    
    for (let i=0; i<remain; i++) {
        answer.push(v+1);
    }
    for (let i=0; i<n-remain; i++) {
        answer.push(v);
    }
    
    return answer.sort((a,b) => a-b);
}