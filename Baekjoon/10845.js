let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim("\r"));

let commands = [];

for (let i=1; i<input.length; i++) {
  commands.push(input[i]);
}

solution(commands);

function solution(commands) {
  let answer = [];
  let queue = [];

  for (let i=0; i<commands.length; i++) {
    if (commands[i] === 'pop') answer.push(queue.length ? queue.splice(0, 1) : -1);
    else if (commands[i] === 'size') answer.push(queue.length);
    else if (commands[i] === 'empty') answer.push(queue.length ? 0 : 1);
    else if (commands[i] === 'front') answer.push(queue.length ? queue[0] : -1);
    else if (commands[i] === 'back') answer.push(queue.length ? queue[queue.length-1] : -1);
    else {
      let [x, y] = commands[i].split(' ');
      queue.push(y);
    }
  }

  console.log(answer.join('\n'));
}