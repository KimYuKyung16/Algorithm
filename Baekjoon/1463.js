const fs = require('fs');
let input = Number(fs.readFileSync('input.txt').toString().trim());

let dp = new Array(input+1);
dp[1] = 0;

for(let i=2; i<=input; i++) {
  dp[i] = dp[i-1] + 1;
  if (i%2 === 0) {
    dp[i] = Math.min(dp[i/2]+1, dp[i]);
  }
  if (i%3 === 0) {
    dp[i] = Math.min(dp[i/3]+1, dp[i]);
  } 
}

console.log(dp[input]);