let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim("\r"));

let parenthesis = [];
for (let i=1; i<input.length; i++) {
  parenthesis.push(input[i]);
}

solution(parenthesis);

function solution(parenthesis) {
  let answer = [];
  for (let i=0; i<parenthesis.length; i++) {
    answer.push(parenthesisCheck(parenthesis[i]));
  }

  console.log(answer.join('\n'));
}

function parenthesisCheck(parenthesis) {
  let stack = [];

  for (x of parenthesis) {
    if (x === '(') stack.push('(');
    else {
      if (stack[stack.length-1] === '(') stack.pop();
      else if (stack.length === 0) return 'NO';
      else continue;
    } 
  }

  return stack.length ? 'NO' : 'YES';
}