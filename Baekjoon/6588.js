const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim("\r"));

let answer = [];
let result_array = new Array(1000000 + 1).fill(true);

result_array[0] = false;
result_array[1] = false;

for (let i=2; i<1000000; i++) {
    for (j=i; j<=1000000; j+=i) {
        if (j === i) continue;
        else result_array[j] = false;
    } 
}

for (let i=0; i<input.length-1; i++) {
  let j = 2;
  let flag = true;
  while(j !== 1000000) {
    let x = j;
    let y = Number(input[i]) - x;
    if (result_array[x] && result_array[y]) {
      answer.push(input[i] + ' = ' + x + ' + ' + y);
      flag = false;
      break;
    } else j++;
  }
  if (flag) answer.push("Goldbach's conjecture is wrong.");
}

console.log(answer.join('\n'));

