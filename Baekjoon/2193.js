let fs = require('fs');
let N = Number(fs.readFileSync('input.txt').toString().trim());

let dp = new Array(N+1);

for (let i=0; i<dp.length; i++) {
  dp[i] = new Array(2).fill(0);
}

dp[1][1] = 1;

for (let i=2; i<=N; i++) {
  dp[i][0] = BigInt(dp[i-1][0]) + BigInt(dp[i-1][1]);
  dp[i][1] = BigInt(dp[i-1][0]);
}

console.log(String(BigInt(dp[N][0] + dp[N][1])));