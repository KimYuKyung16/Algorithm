const fs = require('fs');
let n = parseInt(fs.readFileSync('input.txt').toString().trim());

let count = 0;

if (n%5 !== 0) {
  count += parseInt(n/5);
  n = n%5;
  while(1) {
    if (count === -1) {
      console.log(-1);
      break;
    }

    if (n%2 === 0) {
      count += n/2;
      console.log(count);
      break;
    } else {
      count --;
      n += 5;
    }
  }
} else {
  console.log(n/5);
}