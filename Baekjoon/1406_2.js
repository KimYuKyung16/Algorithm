let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim('\r'));

let string = input[0];
let commands = [];

for (let i=2; i<input.length; i++) {
  commands.push(input[i]);
}

solution(string, commands);


function solution(string, commands) {
  let string1 = [...string];
  let string2 = [];

  for (let i=0; i<commands.length; i++) {
    if (commands[i] === 'L') { 
      if (string1.length) string2.push(string1.pop());
    } else if (commands[i] === 'D') { 
      if (string2.length) string1.push(string2.pop());
    } else if (commands[i] === 'B') {
      if (string1.length) string1.pop();
    } else { 
      let [x, y] = commands[i].split(' ');
      string1.push(y);
    }
  }

  console.log(string1.join('') + string2.reverse().join(''));
}