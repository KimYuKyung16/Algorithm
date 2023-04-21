let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim("\r"));

let deque = [];
let answer = [];

for (let i=1; i<input.length; i++) {
  let [cmd, x] = input[i].split(' ');
  if (cmd === 'push_front') deque.unshift(x);
  else if (cmd === 'push_back') deque.push(x);
  else if (cmd === 'pop_front') deque.length ? answer.push(deque.shift()) : answer.push(-1);
  else if (cmd === 'pop_back') deque.length ? answer.push(deque.pop()) : answer.push(-1);
  else if (cmd === 'size') answer.push(deque.length);
  else if (cmd === 'empty') deque.length ? answer.push(0) : answer.push(1);
  else if (cmd === 'front') deque.length ? answer.push(deque[0]) : answer.push(-1);
  else deque.length ? answer.push(deque[deque.length-1]) : answer.push(-1);
}

console.log(answer.join('\n'));