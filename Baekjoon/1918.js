const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();

let array = [];


for (let i=0; i<input.length; i++) {
  if (i === 0) {
    array.push('(');
  }

  if (/[A-Z]/.test(input[i])) {

    if (input[i+1] === '*' || input[i+1] === '/') {
      if (i !== 0) array.push('(')
      array.push(input[i]);
    } else if (array[array.length-1] === '*' || array[array.length-1] === '/' || array[array.length-1] === '+' || array[array.length-1] === '-') {
      array.push(input[i]);
      array.push(')');
      if (i === input.length-1) array.push(')')
    } else {
      array.push(input[i]);
    }

  } else if (input[i] === '(' || input[i] === ')') {
    if (input[i] === '(') array.push('(');
    else {
      array.push(')');
      if (i === input.length-1) break;
    }
  } else { // * / + - 일 경우
    array.push(input[i]);
  }
  
}

console.log(array)

let stack = [];
let i = 0;
while(1) {
  if (i === array.length-1) {
    while (stack.length !== 1) {
      if (stack[0] === '(') stack.shift();
      first = stack.shift();
      operator = stack.shift();
      second = stack.shift(); 
      stack.unshift(first + second + operator);
    }
    break;
  }

  if (array[i] === ')') { 
    second = stack.pop();
    operator = stack.pop();
    first = stack.pop();
    stack.pop();
    stack.push(first + second + operator);
  } else {
    stack.push(array[i]);
  }
  i++;
}


console.log(stack[0]);
