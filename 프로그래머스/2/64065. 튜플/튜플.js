function solution(s) {
    const answer = [];
    let arr = s.split(/[{}]/);
    arr = arr.filter((x) => x !== '' && x !== ',')
    
    let narr = [];
    for (a of arr) {
        narr.push(a.split(","))
    }
    
    narr.sort((a,b) => a.length - b.length)
    
    answer.push(Number(narr[0][0]));
    for (let i=1; i<narr.length; i++) {
        narr[i].sort((a,b) => b-a);
        narr[i-1].sort((a,b) => b-a);
        
        for (let j=0; j<narr.length; j++) {
            if (narr[i][j] !== narr[i-1][j]) {
                answer.push(Number(narr[i][j]))
                break;
            }
        }
    }
    
    return answer;
}