const fs = require('fs');
let input = fs.readFileSync('input.txt').toString();


let result = input.split('').map((x) => {
  for (let i=0; i<input.length; i++) {
    if (/[a-zA-Z]/.test(x)) {
      if (/[a-z]/.test(x)) return String.fromCharCode(97 + (x.charCodeAt()-97+13)%26);
      else return String.fromCharCode(65 + (x.charCodeAt()-65+13)%26);
    } else return x
  }
})

console.log(result.join(''));
