const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

const n = +input[0];
const numbers = input[1].split(' ').map(Number);
numbers.sort((a,b) => a-b);
const x = +input[2];

let left = 0;
let right = n-1;
let answer = 0;

while (left !== right) {
  if (left-1 === right) break;
  if (n === 1) {
    if (numbers[0] === x) answer = 1;
    break;
  }
  if (numbers[left] + numbers[right] === x) {
    left++;
    right--;
    answer++;
  } else if (numbers[left] + numbers[right] > x) {
    right--;
  } else if (numbers[left] + numbers[right] < x) {
    left++;
  }
}

console.log(answer);
