function solution(array, commands) {
  var answer = [];
  var result = [];
  
  for(var i=0; i<commands.length; i++) {
      for(var j=(commands[i][0]-1); j<commands[i][1]; j++) {
          result.push(array[j]);
      }
      result.sort((a,b) => a-b); // sort() 그냥 쓰면 여러자리 수일 때 제대로 정렬X
      answer.push(result[commands[i][2]-1]);
      result = [];
  }
  
  return answer;
}