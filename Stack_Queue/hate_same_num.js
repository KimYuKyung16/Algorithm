function solution(arr)
{
    var answer = [];
    
    const len = arr.length;
    
    answer.push(arr.pop());

    for (var i=0; i<len-1; i++) {
        let pop_value = arr.pop(); // 제일 끝 값 삭제
             
        if (pop_value === answer[answer.length-1]) continue; // 같은 값이 연속으로 있다면
        else answer.push(pop_value); // 같은 값이 아니라면
    }
    
    return answer.reverse();
}

/*
shift()의 경우는 배열에서 맨 앞에 있는 값을 빼기 때문에
배열에서 요소 하나를 삭제할 때마다 배열값 전체가 이동한다 ---> 따라서 비효율적
shift() 대신 pop()을 쓰는 것이 더 효율적!
*/

/*
정확성  테스트
테스트 1 〉	통과 (0.05ms, 30MB)
테스트 2 〉	통과 (0.08ms, 29.9MB)
테스트 3 〉	통과 (0.10ms, 30MB)
테스트 4 〉	통과 (0.07ms, 30MB)
테스트 5 〉	통과 (0.09ms, 30.1MB)
테스트 6 〉	통과 (0.07ms, 29.8MB)
테스트 7 〉	통과 (0.08ms, 30.1MB)
테스트 8 〉	통과 (0.08ms, 30MB)
테스트 9 〉	통과 (0.07ms, 30MB)
테스트 10 〉	통과 (0.07ms, 30MB)
테스트 11 〉	통과 (0.07ms, 30MB)
테스트 12 〉	통과 (0.10ms, 29.9MB)
테스트 13 〉	통과 (0.07ms, 29.9MB)
테스트 14 〉	통과 (0.07ms, 30MB)
테스트 15 〉	통과 (0.06ms, 30.1MB)
테스트 16 〉	통과 (0.07ms, 30MB)
테스트 17 〉	통과 (0.05ms, 30MB)
효율성  테스트
테스트 1 〉	통과 (44.83ms, 82.2MB)
테스트 2 〉	통과 (46.32ms, 82.1MB)
테스트 3 〉	통과 (45.87ms, 82.3MB)
테스트 4 〉	통과 (45.72ms, 82.3MB)
채점 결과
정확성: 71.9
효율성: 28.1
합계: 100.0 / 100.0
*/