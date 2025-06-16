function solution(n, stations, w) {
    let answer = 0;
    let prev = 0;
    
    for (let station of stations) {
        let left = station - w - 1;
        let right = station + w;
        
        if (prev <= left) {
            answer += Math.ceil((left-prev)/(w*2+1));
        }
        
        prev = right;
    }
    
    if (prev < n) {
        answer += Math.ceil((n-prev)/(w*2+1));
    }
    
    return answer;
}