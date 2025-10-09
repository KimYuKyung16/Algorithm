// 1. k진수로 변경
// 2. 0으로 split
// 3. 각 값 소수 판단
function solution(n, k) {
    let answer = 0;
    const num = n.toString(k);
    const nums = num.split('0');
    
    const map = {};
    for (n of nums) {
        if (n.length === 0) continue;
        if (map[n] ?? false) {
            answer++;
            continue;
        }
        
        if (isPrime(Number(n))) {
            map[n] = true;
            answer++;
        }
    }
    
    return answer;
}

function isPrime(num) {
    if (num === 1) return false;
    for (let i=2; i<=Math.sqrt(num); i++) {
        if (num%i === 0) return false;
    }    
    return true;
}