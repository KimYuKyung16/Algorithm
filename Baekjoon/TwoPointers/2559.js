const fs = require("fs");
let input = fs.readFileSync("input.txt").toString().trim().split("\n");
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


// answer를 0으로 했을 때 틀렸음.
// 왜냐 모든 결과값이 음수일 경우에 최대값이 음수로 나와야하는데 
// 0으로 설정했을 경우에는 최대값이 0으로 나와버림.