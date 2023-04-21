const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

let expression = input[1];
expression = expression.split('');

let stack = [];
let nums = {};
let numIndex = 2;

for (let i=0; i<expression.length; i++) {
  if (/[A-Z]/.test(expression[i])) {
    if (nums[expression[i]] === undefined) {
      nums[expression[i]] = input[numIndex];
      stack.push(Number(input[numIndex]));
      numIndex++;
    } else {
      stack.push(Number(nums[expression[i]]));
    }
  } else {
    let second = stack.pop();
    let first = stack.pop();
    if (expression[i] === '+') {
      stack.push(first + second);
    } else if (expression[i] === '-') {
      stack.push(first - second);
    } else if (expression[i] === '*') {
      stack.push(first * second);
    } else {
      stack.push(first / second);
    }
  }
}

console.log((stack.pop() * 100 / 100).toFixed(2));