const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('<');

let answer = '';

for (let i=0; i<input.length; i++) {
  if (input[i].split('').includes('>')) {
    let [left, right] = input[i].split('>');
    answer += ('<'+left +'>'); 
    answer += right.split(' ').map((x) => {
      return x.split('').reverse().join('')
    }).join(' ');
  } else {
    answer += input[i].split(' ').map((x) => {
       return x.split('').reverse().join('')
    }).join(' ');
  }
}

console.log(answer);