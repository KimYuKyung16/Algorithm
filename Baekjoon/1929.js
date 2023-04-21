const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim()

let array = input.split(' ').map((x) => Number(x));
  
let answer = [];
let result_array = new Array(array[1]+1).fill(true);

result_array[0] = false;
result_array[1] = false;

for (let i=2; i<array[1]; i++) {
    for (j=i; j<=array[1]; j+=i) {
        if (j === i) continue;
        else result_array[j] = false;
    } 
}

for (let i=array[0]; i<=array[1]; i++) {
  if (result_array[i]) answer.push(i);
}

console.log(answer.join('\n'));

