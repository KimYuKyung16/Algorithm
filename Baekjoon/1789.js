const fs = require('fs');
let S = fs.readFileSync('input.txt').toString().trim();

let sum = 0;
let N= 0;;
for (let i=1; i<S+1; i++) {
  if (sum + i > S || (S-sum) < i) {
    console.log(N);
    break;
  } else {
    sum += i;
    N++;
  }
}
