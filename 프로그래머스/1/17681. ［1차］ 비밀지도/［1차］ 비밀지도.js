function solution(n, arr1, arr2) {
    var answer = [];
    
    for (let i=0; i<n; i++) {
        let c = (arr1[i] | arr2[i]).toString(2).padStart(n, '0');
        c = c.replaceAll('1', '#');
        c = c.replaceAll('0', " ");
        answer.push(c);
    }
    
    return answer;
}