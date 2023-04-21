let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
let n = Number(input[0]);
let array = input[1].split(' ').map((x) => Number(x));

let dp = new Array(n).fill(0);

dp[0] = array[0];

for (let i=1; i<dp.length; i++) {
  dp[i] = array[i];
  dp[i] = Math.max(dp[i-1] + dp[i], dp[i]);

}

console.log(Math.max(...dp));
