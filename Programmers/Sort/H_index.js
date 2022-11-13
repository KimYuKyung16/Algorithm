function solution(citations) {
  let answer;
  
  for (var i=citations.length+1; i>=0; i--) {      
      if ((citations.filter((x) => {return x>=i})).length >= i) return answer = i
  }
}