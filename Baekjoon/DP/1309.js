const fs = require('fs');
let N = Number(fs.readFileSync('input.txt').toString().trim());

let answer = 3;
let dp = new Array(N+1).fill(0);

for (let i=0; i<dp.length; i++) {
  dp[i] = new Array(3).fill(0);
}

dp[1][0] = 1; // 공백
dp[1][1] = 1; // 왼쪽
dp[1][2] = 1; // 오른쪽

for (let i=2; i<dp.length; i++) {
  dp[i][0] = dp[i-1][0] % 9901 + dp[i-1][1] % 9901 + dp[i-1][2] % 9901;
  dp[i][1] = dp[i-1][0] % 9901 + dp[i-1][2] % 9901;
  dp[i][2] = dp[i-1][0] % 9901 + dp[i-1][1] % 9901; 
}

console.log((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);