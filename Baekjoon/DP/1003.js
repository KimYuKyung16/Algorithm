const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

for (let i=1; i<input.length; i++) {
  const N = +input[i];
  let dp = new Array(N+1).fill(0).map(() => new Array(2).fill(0));

  dp[0] = [1, 0];
  dp[1] = [0, 1];

  for (let i=2; i<dp.length; i++) {
    dp[i][0] = dp[i-1][0] + dp[i-2][0];
    dp[i][1] = dp[i-1][1] + dp[i-2][1];
  }

  console.log(dp[N].join(' '));
}