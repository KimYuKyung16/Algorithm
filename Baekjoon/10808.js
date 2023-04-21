const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();

let count = new Array(26).fill(0);

for (let i=0;i<input.length; i++) {
  count[input[i].charCodeAt() -'a'.charCodeAt()]++;
}

console.log(count.join(' '));
