const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

const N = Number(input[0]);
let dp = new Array(N+1);

for (let j=0; j<dp.length; j++) {
  dp[j] = new Array(3);
}

let [red, green, blue] = input[1].split(' ').map(Number);

dp[1][0] = red; // 빨강
dp[1][1] = green; // 초록
dp[1][2] = blue; // 파랑

for (let i=2; i<dp.length; i++) {
  let [red, green, blue] = input[i].split(' ').map(Number);

  dp[i][0] = Math.min(dp[i-1][1] + red, dp[i-1][2] + red);
  dp[i][1] = Math.min(dp[i-1][0] + green, dp[i-1][2] + green);
  dp[i][2] = Math.min(dp[i-1][0] + blue, dp[i-1][1] + blue);
}

console.log(Math.min(dp[N][0], dp[N][1], dp[N][2]));


