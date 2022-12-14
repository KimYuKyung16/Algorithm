function solution(s){
  var answer = true;
  let count = 0;
  s = [...s]; 
  const len = s.length;
  
  if (s[s.length-1] == '(' || s[0] == ')' || s.length%2 != 0) return false;
  
  for (var i=0; i<len-1; i++) {
      if (s.pop() == ')') { 
          count ++;
      } else {
          count --;
          if (count < 0) { // 음수가 나올 경우에는 ')'보다 '('가 더 많다는 뜻이므로 틀린 괄호
              return false;
              break;
          }
      }
  }  
  return answer;
}

/*
pop()을 하면 배열의 length가 계속 변하기 때문에 length를 미리 변수값으로 설정해놓고 사용하기
이렇게 사용하는 것이 계속 .length를 안써도 되기 때문에 효율적으로도 더 좋다.
*/

/*
정확성  테스트
테스트 1 〉	통과 (0.08ms, 30.1MB)
테스트 2 〉	통과 (0.08ms, 30MB)
테스트 3 〉	통과 (0.18ms, 29.9MB)
테스트 4 〉	통과 (0.07ms, 30.1MB)
테스트 5 〉	통과 (0.09ms, 30.1MB)
테스트 6 〉	통과 (0.08ms, 30.1MB)
테스트 7 〉	통과 (0.07ms, 30.2MB)
테스트 8 〉	통과 (0.06ms, 29.9MB)
테스트 9 〉	통과 (0.08ms, 30.2MB)
테스트 10 〉	통과 (0.09ms, 30.2MB)
테스트 11 〉	통과 (0.08ms, 30MB)
테스트 12 〉	통과 (0.09ms, 30.2MB)
테스트 13 〉	통과 (0.11ms, 29.8MB)
테스트 14 〉	통과 (0.09ms, 30.3MB)
테스트 15 〉	통과 (0.07ms, 30.1MB)
테스트 16 〉	통과 (0.10ms, 30.1MB)
테스트 17 〉	통과 (0.14ms, 30.1MB)
테스트 18 〉	통과 (0.07ms, 30.4MB)
효율성  테스트
테스트 1 〉	통과 (6.15ms, 33.6MB)
테스트 2 〉	통과 (4.49ms, 33.5MB)
채점 결과
정확성: 69.5
효율성: 30.5
합계: 100.0 / 100.0
*/