const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
input = input.map((x) => x.trim("\r"));

const [N, K] = input[0].split(' ').map(Number);
const numbers = input[1].split(' ').map(Number);

let left = 0;
let right = 0;
let sum = 0;
let answer = Number.MIN_SAFE_INTEGER;

while (right <= N) {
  if (right-left === K) {
    answer = Math.max(answer, sum);
    sum -= numbers[left];
    left++;
  } else if (right-left < K) {
    sum += numbers[right];
    right++;
  } else if (right-left > K) {
    sum -= numbers[left];
    left++;
  }
}

console.log(answer);