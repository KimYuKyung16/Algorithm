let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim("\r"));

let testcase = [];

for (let i=1; i<input.length; i++) {
  testcase.push(input[i]);
}

solution(testcase);

function solution(testcase) {
  for (let i=0; i<testcase.length; i++) {
    testcase[i] = testcase[i].split(' ').map((x) => {
      return x.split('').reverse().join('');
    }).join(' ')
  }

  console.log(testcase.join('\n'));
}
