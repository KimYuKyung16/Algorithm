function solution(progresses, speeds) {
  var answer = [];
  let count = 0;
  
  progresses = progresses.reverse();
  speeds = speeds.reverse();
  
  while(progresses.length != 0){
      if (progresses[progresses.length-1] < 100) {
          progresses = progresses.map((value, index, array) => {return value + speeds[index]})
      } else {
          while(progresses[progresses.length-1] >= 100) {
              progresses.pop();
              speeds.pop();
              count ++;              
          }
          answer.push(count);
          count = 0;
      }
  }   
  return answer;
}

/*
array.map((value, index, array) => {return x})
value는 array에서 하나씩 가져오는 값
index는 해당 값의 인덱스
array는 배열 원형
x는 value에 새로 return해서 넣는 값
*/

/*
정확성  테스트
테스트 1 〉	통과 (0.08ms, 29.7MB)
테스트 2 〉	통과 (0.21ms, 30.1MB)
테스트 3 〉	통과 (0.28ms, 30.1MB)
테스트 4 〉	통과 (0.15ms, 29.9MB)
테스트 5 〉	통과 (0.14ms, 30.1MB)
테스트 6 〉	통과 (0.13ms, 30.1MB)
테스트 7 〉	통과 (0.25ms, 30.1MB)
테스트 8 〉	통과 (0.18ms, 29.8MB)
테스트 9 〉	통과 (0.31ms, 30.1MB)
테스트 10 〉	통과 (0.36ms, 30MB)
테스트 11 〉	통과 (0.12ms, 30.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/