let fs = require('fs');
let N = Number(fs.readFileSync('input.txt').toString().trim());

let dp = new Array(N+1).fill(0);
dp[1] = 9;

for (let i=2; i<=N; i++) {
  dp[i] = ((dp[i-1]) * 2 % 1000000000) - (i-1) % 1000000000;
}

console.log(String(dp[N] % 1000000000));