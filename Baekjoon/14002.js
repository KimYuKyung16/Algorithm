let fs = require('fs');
let input= fs.readFileSync('input.txt').toString().trim().split('\n');

N = Number(input[0]);
let A = input[1].split(' ').map((x) => Number(x));
A.unshift(0);

let dp = new Array(N+1);
let answer=[A[1]];

dp[1] = [A[1]];

for (let i=2; i<=N; i++) {
  let currentMax = [];
  for (let j=1; j<i; j++) {
    if (A[j] < A[i]) {
      if (Math.max(currentMax.length, dp[j].length) === dp[j].length) {
        currentMax = [...dp[j]];
      };
    }
  }
  dp[i] = [...currentMax, A[i]];
  if (Math.max(answer.length, dp[i].length) === dp[i].length) {
    answer = dp[i];
  }
}

console.log(answer.length);
console.log(answer.join(' '));