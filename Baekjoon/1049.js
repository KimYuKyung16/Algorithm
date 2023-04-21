const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

const [N, M] = input[0].split(' ');
let answer = 0;
let testcase = [];

for (let i=1; i<input.length; i++) {
  testcase.push(input[i].split(' '));
}

let package_list = [];
let one_list = [];

for (let i=0; i<testcase.length; i++) {
  package_list.push(testcase[i][0]);
  one_list.push(testcase[i][1]);
}

let package = Math.min(...package_list);
let one = Math.min(...one_list);

if (package > one * 6) {
  answer += (one * N);
} else {
  answer += (package * parseInt(N/6));
  if (package < (one * (N%6))) {
    answer += package;
  } else {
    answer += (one * (N % 6));
  }  
}

console.log(answer);

// 반례: 패키지로 샀을 때가 낱개로 살 때보다 더 비쌀 경우도 고려해야함.

