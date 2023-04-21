const fs = require('fs');
let [A, B] = fs.readFileSync('input.txt').toString().trim().split(' ');

let max = Math.max(A, B);
let divisor;
for (let i = max; i>=1; i--) {
  if (A%i === 0 && B%i === 0) {
      divisor = i;
      break;
  }
}

console.log(divisor);

let multiple = max;
while(1) {
  if (multiple%A === 0 && multiple%B === 0) break;
  else multiple += max;
}

console.log(multiple);
