const fs = require('fs');
const [A, B] = fs.readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);

function solution() {
  let count = 0;
  let answer = 0;

  for (let i=1; i<=B; i++) {
    for (let j=1; j<=i; j++) {
      count++;
      if (count >= A && count <= B) {
        answer += i;
      }
      if (count === B) return answer;
    }
  }
}

console.log(solution());