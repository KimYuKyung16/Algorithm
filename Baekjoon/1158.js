const fs = require('fs');
let [N, K] = fs.readFileSync('input.txt').toString().trim('').split(' ');

N = Number(N);
K = Number(K);

let array = new Array(N).fill(0);
let answer = [];

for (let i=0; i<N; i++) {
  array[i] = i+1;
}

let i = 0;
let count = 1;

while (answer.length !== N) {
  if (i === N) i = 0;
  if (array[i] === 0) i++;
  else { 
    if (count === K) {
      answer.push(array[i]);
      array[i] = 0;
      count = 1;
      i++;
    } else {
      count ++;
      i++;
    }
  }
}

console.log('<' + answer.join(', ') + '>');