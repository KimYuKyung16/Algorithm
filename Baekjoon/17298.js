const fs = require('fs');
let input = fs.readFileSync("input.txt").toString().trim().split('\n')[1].split(' ');

let answer = [];
let stack = [];

for (let i=input.length-1; i>=0; i--) {
  if (stack.length === 0) {
    answer.push(-1);
    stack.push(input[i]);
  } else {
    while(1) {
      if (stack[stack.length-1] > Number(input[i])) {
        answer.push(stack[stack.length-1]);
        stack.push(input[i]);
        break;
      } else {
        if (stack.length === 0) {
          answer.push(-1);
          stack.push(input[i]);
          break;
        } else stack.pop();
      }
    }
  }
}

console.log(answer.reverse().join(' '));