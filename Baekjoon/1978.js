const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim("\r"));

let array = input[1].split(' ');
  
let answer = 0;
let result_array = new Array(Math.max(...array)+1).fill(true);

result_array[0] = false;
result_array[1] = false;

for (let i=2; i<Math.max(...array); i++) {
    for (j=i; j<=Math.max(...array); j+=i) {
        if (j === i) continue;
        else result_array[j] = false;
    } 
}

for (let i=0; i<array.length; i++) {
  if (result_array[array[i]]) answer++;
}

console.log(answer);

