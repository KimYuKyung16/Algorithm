const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();

let result = [];

for (let i=0; i<input.length; i++) {
  result.push(input.slice(i));
}

console.log(result.sort().join('\n'));