const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim('\r'));

const N = input[0];
let testcase = [];
let S = 0;

for (let i=1; i<input.length; i++) {
  testcase.push(input[i].split(' '));
}

testcase[0].sort((a,b) => a-b);
testcase[1].sort((a,b) => b-a);

for (let i=0; i<testcase[0].length; i++) {
  S += testcase[0][i] * testcase[1][i]
}

console.log(S);