function solution(A, B) {
    let answer = 0;
    A.sort((a,b) => b-a);
    B.sort((a,b) => b-a);
    
    let indexB = 0;
    for (let i=0; i<A.length; i++) {
        if (B[indexB] > A[i]) {
            answer++;
            indexB++;
        }
    }
    return answer;
}