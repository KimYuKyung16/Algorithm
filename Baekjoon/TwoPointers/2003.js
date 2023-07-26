const fs = require("fs");
let input = fs.readFileSync("input.txt").toString().trim().split("\n");
input = input.map((x) => x.trim("\r"));

const [N, M] = input[0].split(" ").map(Number);
const numbers = input[1].split(" ").map(Number);

let left = 0;
let right = 0;
let sum = 0;
let answer = 0;
while (right <= N) {
  if (sum < M) {
    sum += numbers[right];
    right++;
  } else if (sum > M) {
    sum -= numbers[left];
    left++;
  } else if (sum === M) {
    answer++;
    sum -= numbers[left];
    left++;
  }
}

console.log(answer);
