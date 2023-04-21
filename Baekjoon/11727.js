const fs = require('fs');
let n = Number(fs.readFileSync('input.txt').toString().trim());

let dp = new Array(n+1);
dp[1] = 1;
dp[2] = 3;


for (let i=3; i<=n; i++) {
  dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
}

console.log(dp[n]);
