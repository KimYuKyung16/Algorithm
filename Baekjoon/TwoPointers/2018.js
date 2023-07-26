const fs = require('fs');
const N = +fs.readFileSync('input.txt').toString().trim();

let left = 1;
let right = 1;
let sum = 0;
let answer = 0;

while (1) {
  if (left === N+1) break;
  if (sum === N) {
    sum -= left;
    answer++;
    left++;
  } else if (sum > N) {
    sum -= left;
    left++;
  } else if (sum < N) {
    sum += right;
    right++;
  }
}

console.log(answer);