let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => Number(x.trim('\r')));

let answer = '';
T = input[0];

let dp = new Array(100000+1);

for (let i=0; i<dp.length; i++) {
  dp[i] = new Array(4).fill(0);
}

dp[1][1] = 1;
dp[2][2] = 1;
dp[3][1] = 1;
dp[3][2] = 1;
dp[3][3] = 1;

for (let i=4; i<=100000; i++) {
  dp[i][1] = dp[i-1][2] % 1000000009 + dp[i-1][3] % 1000000009;
  dp[i][2] = dp[i-2][1] % 1000000009 + dp[i-2][3] % 1000000009;
  dp[i][3] = dp[i-3][1] % 1000000009 + dp[i-3][2] % 1000000009;
}

for (let i=1; i<=T; i++) {
  let N = input[i];

  answer += (((dp[N][1] + dp[N][2] + dp[N][3]) % 1000000009) + '\n'); 
}

console.log(answer);