const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim("\r"));

let K = Number(input[0].split(' ')[1]);
let answer = 0;
let i = input.length-1;

while (K > 0) {
  if (input[i] <= K) {
    answer += parseInt(K/input[i]);
    K = K % input[i];
  }
  i--;
}

console.log(answer);
