const fs = require('fs');
let input = Number(fs.readFileSync('input.txt').toString().trim());

let dp = new Array(input+1);
dp[1] = 1;
dp[2] = 2;

for (let i=3; i<=input; i++) {
  dp[i] = (dp[i-1] + dp[i-2]) % 10007;
}

console.log(dp[input]);