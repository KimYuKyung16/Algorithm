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
  let array = string.split('');
  let cursor = array.length;

  for (let i=0; i<commands.length; i++) {
    if (commands[i] === 'L') { 
      cursor === 0 ? cursor : cursor -= 1;
    } else if (commands[i] === 'D') { 
      cursor === array.length ? cursor : cursor += 1;
    } else if (commands[i] === 'B') {
      if (cursor !== 0) {
        array.splice(cursor-1, 1);
        cursor --;
      }
    } else { 
      let [x, y] = commands[i].split(' ');
      array.splice(cursor, 0, y);
      cursor ++;
    }
  }

  console.log(array.join(''));
}