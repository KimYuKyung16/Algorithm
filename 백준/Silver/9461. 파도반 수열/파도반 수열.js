const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
input = input.map((x) => Number(x.trim("\r")));

const T = input.shift();
const maxNum = Math.max(Math.max(...input), 4);

let dp = new Array(maxNum + 1).fill(0);
dp[1] = 1;
dp[2] = 1;
dp[3] = 1;
dp[4] = 2;
dp[5] = 2;

for (let i = 6; i < dp.length; i++) {
  dp[i] = dp[i - 1] + dp[i - 5];
}

for (let i = 0; i < input.length; i++) {
  console.log(dp[input[i]]);
}
