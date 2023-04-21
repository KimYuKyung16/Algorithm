let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();

solution(input);

function solution(N) {
  let answer = 0;
  let sum = 0;

  while(sum <= N) {
    sum += 5;
    answer ++;
  }

  if (sum === N) console.log(answer);
  else {
    while(1) {
      sum -= 5;
      answer --;

      if ((N - sum)%3 === 0) {
        answer += (N-sum)/3;
        console.log(answer);
        break;
      } 

      if (sum <= 0) {
        if (N-sum) console.log(-1);
        break;
      }
    }
  }
}