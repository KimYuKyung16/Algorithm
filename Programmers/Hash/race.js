function solution(participant, completion) {
  participant = participant.sort();
  completion = completion.sort();
  
  for (var i=0; i<completion.length; i++) {
      if (participant[i] == completion[i]) continue;
      if (participant[i] != completion[i]) return participant[i]
  }
  
  return participant[participant.length-1]  
}

/*
정확성  테스트
테스트 1 〉	통과 (0.05ms, 30MB)
테스트 2 〉	통과 (0.05ms, 30MB)
테스트 3 〉	통과 (0.29ms, 30MB)
테스트 4 〉	통과 (0.59ms, 30.1MB)
테스트 5 〉	통과 (0.57ms, 29.8MB)
효율성  테스트
테스트 1 〉	통과 (47.38ms, 40.8MB)
테스트 2 〉	통과 (102.18ms, 48MB)
테스트 3 〉	통과 (113.02ms, 51.8MB)
테스트 4 〉	통과 (120.81ms, 55.3MB)
테스트 5 〉	통과 (97.93ms, 53MB)
채점 결과
정확성: 50.0
효율성: 50.0
합계: 100.0 / 100.0
*/