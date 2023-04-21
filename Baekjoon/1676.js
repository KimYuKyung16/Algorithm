const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();

let answer = 0;

for (let i=1; i<=input; i++) {
  if (i%125 === 0) answer += 3;
  else if (i%25 === 0) answer += 2;
  else if (i%5 === 0) answer += 1;
  else continue;
}

console.log(answer)

