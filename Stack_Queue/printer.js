function solution(priorities, location) {
  let answer = 0;
  let index = 0;
  
  priorities = priorities.map((value, index) => [index, value]);
  
  while(1) {
     let first_val = priorities.shift();
      
      if (Math.max(...priorities.map((value) => { return value[1] })) > first_val[1]) {
          priorities.push(first_val);
      } else {
          index ++;
          if (first_val[0] == location) {
              answer = index;
              break;
          }
      } 
  }
  
  return answer;
}

/*
정확성  테스트
테스트 1 〉	통과 (0.25ms, 30.1MB)
테스트 2 〉	통과 (1.39ms, 30.1MB)
테스트 3 〉	통과 (0.23ms, 30MB)
테스트 4 〉	통과 (0.16ms, 29.8MB)
테스트 5 〉	통과 (0.07ms, 30.1MB)
테스트 6 〉	통과 (0.20ms, 30MB)
테스트 7 〉	통과 (0.36ms, 30.1MB)
테스트 8 〉	통과 (1.01ms, 29.8MB)
테스트 9 〉	통과 (0.10ms, 30.1MB)
테스트 10 〉	통과 (0.25ms, 30MB)
테스트 11 〉	통과 (0.77ms, 30.1MB)
테스트 12 〉	통과 (0.18ms, 30MB)
테스트 13 〉	통과 (0.66ms, 30.1MB)
테스트 14 〉	통과 (0.09ms, 29.9MB)
테스트 15 〉	통과 (0.15ms, 30.1MB)
테스트 16 〉	통과 (0.15ms, 30.1MB)
테스트 17 〉	통과 (1.14ms, 30.2MB)
테스트 18 〉	통과 (0.12ms, 30MB)
테스트 19 〉	통과 (1.03ms, 29.8MB)
테스트 20 〉	통과 (0.21ms, 30MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/