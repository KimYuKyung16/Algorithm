let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => Number(x.trim('\r')));

for (let i=1; i<=input[0]; i++) {
  let dp = new Array(input[i]+1);

  dp[1] = 1;
  dp[2] = 2;
  dp[3] = 4;
  for (let j=4; j<=input[i]; j++) {
    dp[j] = dp[j-1] + dp[j-2] +dp[j-3];
  }

  console.log(dp[input[i]]);
}