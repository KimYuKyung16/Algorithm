const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();

let answer = 0;
let array0 = input.split('1').sort().filter((x) => x !== '');
let array1 = input.split('0').sort().filter((x) => x !== '');

while(array0.length !== 0 && array1.length !== 0) {
  if (array0.length < array1.length) {
    array0.pop();
  } else if (array0.length > array1.length){
    array1.pop();
  } else {
    if (array0[array0.length-1].length >= array1[array1.length-1].length) {
      array0.pop();
    } else {
      array1.pop();
    }
  }
  answer++;
}

console.log(answer);