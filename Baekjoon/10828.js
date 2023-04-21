let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim("\r"));

const N = +input[0];
let commands = [];

for (let i=1; i<input.length; i++) {
  commands.push(input[i]);
}

solution(N, commands);

function solution(N, commands) {
  let answer = [];
  let stack = [];

  for (let i=0; i<N; i++) {
    if (commands[i] === 'pop') {
      stack.length? answer.push(stack.pop()) : answer.push(-1) 
    } else if (commands[i] === 'size') answer.push(stack.length);
    else if (commands[i] === 'empty') {
      stack.length ? answer.push(0) : answer.push(1)
    } else if (commands[i] === 'top') {
      stack.length ? answer.push(stack[stack.length-1]) : answer.push(-1) 
    } else {
      let [x, y] = commands[i].split(' ');
      stack.push(y);
    }
  }

  answer = answer.join('\n');
  console.log(answer);
}