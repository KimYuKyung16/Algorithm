const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();

let answer = 1;
for (let i=2; i<=input; i++) {
  answer *= i;
}

console.log(answer);