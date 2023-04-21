let fs = require('fs');
let input= fs.readFileSync('input.txt').toString().trim().split('\n');

N = Number(input[0]);
let A = input[1].split(' ').map((x) => Number(x));
A.unshift(0);

let dp = new Array(N+1);
let answer=1;

dp[1] = 1;

for (let i=2; i<=N; i++) {
  let currentMax = 0;
  for (let j=1; j<=i; j++) {
    if (A[j] < A[i]) {
      currentMax = Math.max(currentMax, dp[j]);
    }
  }
  dp[i] = currentMax + 1;
  answer = Math.max(answer, dp[i]);
}

console.log(answer);