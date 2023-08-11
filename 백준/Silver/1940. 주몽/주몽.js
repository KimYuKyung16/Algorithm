const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

const N = +input.shift();
const M = +input.shift();
const numbers = input.shift().split(' ').map(Number);
numbers.sort((a,b) => a-b);

let left = 0;
let right = N-1;
let answer = 0;

while (left !== right) {
  if (left-1 === right) break;
  if (numbers[left] + numbers[right] === M) {
    left++;
    right--;
    answer++;
  } else if (numbers[left] + numbers[right] > M) {
    right--;
  } else if (numbers[left] + numbers[right] < M) {
    left++;
  }
}

console.log(answer);