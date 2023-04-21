let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((item) => item.trim("\r"));


let testcase = [];

for (let i=1; i<input.length; i++) {
  testcase.push(input[i].split(' '));
}

solution(testcase);

function solution(testcase) {
  let count = 0;
  let moneylist = [];

  while (count !== testcase.length) {
    let day = 0;
    let money = 0;

    for (let i=count; i<testcase.length; i+=day) {
      if (i <= testcase.length && i + Number(testcase[i][0]) <= testcase.length) {
        if (solution(testcase.slice(i+1)))
        
        money += Number(testcase[i][1]);
        day = Number(testcase[i][0]);
      } else {
        break;
      }
    }

    console.log(money)
    moneylist.push(money);
    count ++;
  }

  console.log(Math.max(...moneylist));
  return Math.max(...moneylist);
}