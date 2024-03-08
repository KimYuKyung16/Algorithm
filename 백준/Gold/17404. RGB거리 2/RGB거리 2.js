const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const n = Number(input[0]);

let red_dp = new Array(n+1);
let green_dp = new Array(n+1);
let blue_dp = new Array(n+1);

for (let j=0; j<red_dp.length; j++) {
  red_dp[j] = new Array(3).fill(0);
  green_dp[j] = new Array(3).fill(0);
  blue_dp[j] = new Array(3).fill(0);
}

let [r,g,b] = input[1].split(' ').map(Number);
let [next_r, next_g, next_b] = input[2].split(' ').map(Number);

red_dp[2][1] = r + next_g;
red_dp[2][2] = r + next_b; 

green_dp[2][0] = g + next_r;
green_dp[2][2] = g + next_b;

blue_dp[2][0] = b + next_r;
blue_dp[2][1] = b + next_g;

for (let i=3; i<red_dp.length; i++) {
  const [red, green, blue] = input[i].split(' ').map(Number);

  if (i === 3) {
    red_dp[i][0] = red + Math.min(red_dp[i-1][1], red_dp[i-1][2]); // 빨강
    red_dp[i][1] = green + red_dp[i-1][2]; // 초록
    red_dp[i][2] = blue + red_dp[i-1][1]; // 파랑

    green_dp[i][0] = red + green_dp[i-1][2]; // 빨강
    green_dp[i][1] = green + Math.min(green_dp[i-1][0], green_dp[i-1][2]); // 초록
    green_dp[i][2] = blue + green_dp[i-1][0]; // 파랑

    blue_dp[i][0] = red + blue_dp[i-1][1]; // 빨강
    blue_dp[i][1] = green + blue_dp[i-1][0]; // 초록
    blue_dp[i][2] = blue + Math.min(blue_dp[i-1][0], blue_dp[i-1][1]); // 파랑
  } else {
    red_dp[i][0] = red + Math.min(red_dp[i-1][1], red_dp[i-1][2]); // 빨강
    red_dp[i][1] = green + Math.min(red_dp[i-1][0], red_dp[i-1][2]); // 초록
    red_dp[i][2] = blue + Math.min(red_dp[i-1][0], red_dp[i-1][1]); // 파랑

    green_dp[i][0] = red + Math.min(green_dp[i-1][1], green_dp[i-1][2]); // 빨강
    green_dp[i][1] = green + Math.min(green_dp[i-1][0], green_dp[i-1][2]); // 초록
    green_dp[i][2] = blue + Math.min(green_dp[i-1][0], green_dp[i-1][1]); // 파랑

    blue_dp[i][0] = red + Math.min(blue_dp[i-1][1], blue_dp[i-1][2]); // 빨강
    blue_dp[i][1] = green + Math.min(blue_dp[i-1][0], blue_dp[i-1][2]); // 초록
    blue_dp[i][2] = blue + Math.min(blue_dp[i-1][0], blue_dp[i-1][1]); // 파랑
  }
}

let red_minNum = Math.min(red_dp[n][1], red_dp[n][2]);
let green_minNum = Math.min(green_dp[n][0], green_dp[n][2]);
let blue_minNum = Math.min(blue_dp[n][0], blue_dp[n][1]);

console.log(Math.min(red_minNum, green_minNum, blue_minNum));