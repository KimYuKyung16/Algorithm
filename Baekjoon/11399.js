let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');

let N = input[0];
let time = input[1].split(' ')

solution(N, time);

function solution(N, time) {
  let answer = 0;
  let sum = 0;
  time.sort((a,b) => a-b);

  for (let i=0; i<time.length; i++) {
    answer += +time[i];
    sum += answer;
  }

  console.log(sum)
}