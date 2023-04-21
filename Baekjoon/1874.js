let fs = require('fs');
let input = fs.readFileSync("input.txt").toString().trim().split('\n');
input = input.map((item) => item.trim('\r'));

let nums = [];
for (let i=1; i<input.length; i++) {
  nums.push(+input[i]);
}
solution(nums);


function solution(nums) {
  let answer = [];
  let stack = [];
  let lastnum = 1;

  for(let i=0; i<nums.length; i++) {
    if (nums[i] >= lastnum) {
      while (lastnum !== nums[i]+1) {
        stack.push(lastnum);
        answer.push('+');
        lastnum++;
      }
      stack.pop();
      answer.push('-');
    } else {
      if (nums[i] === stack[stack.length-1]) {
        stack.pop();
        answer.push('-'); 
      } else {
        answer = ['NO'];
        break;
      }
    }
  }

  console.log(answer.join('\n'));
}