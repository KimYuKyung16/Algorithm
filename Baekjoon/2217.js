const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

const N = input[0];
let testcase = [];

for (let i=1; i<input.length; i++) {
  testcase.push(input[i]);
}

testcase.sort((a,b) => b-a);
let count = 1;
let last = testcase[0] * count;

for (let i=0; i<testcase.length+1; i++) {
  if (testcase[i] * count >= last) {
    last = testcase[i] * count;
    count++;
  } else {
    count++;
    continue;
  }
}

console.log(last);