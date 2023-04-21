const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();
let answer = [];

for (let i='a'.charCodeAt(); i<='z'.charCodeAt(); i++) {
  if (input.includes(String.fromCharCode(i))) {
    answer.push(input.indexOf(String.fromCharCode(i)));
  } else answer.push(-1);
}

console.log(answer.join(' '));