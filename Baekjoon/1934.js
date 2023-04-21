const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));


for (let i=1; i<=input[0]; i++) {
  let [A, B] = input[i].split(' ');
  let max = Math.max(A, B);
  let multiple = max;

  while(1) {
    if (multiple%A === 0 && multiple%B === 0) break;
    else multiple += max;
  }
  console.log(multiple);
}


