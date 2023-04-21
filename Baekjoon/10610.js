/*
  배수판정법 공부하기
*/

const fs = require('fs');
let N = fs.readFileSync('input.txt').toString().trim();

console.log(N)
N = N.split('');

if (!N.includes('0')) console.log(-1);
else {
  let sum = 0;
  for (let i=0; i<N.length; i++) {
    sum += +N[i];
  }

  if (sum%3 === 0) {
    console.log(N.sort((a,b) => b-a).join(''));
  }else {
    console.log(-1);
  }
}

