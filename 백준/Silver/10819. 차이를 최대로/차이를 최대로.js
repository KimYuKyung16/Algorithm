const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
input = input.map((x) => x.trim("\r"));

const N = +input.shift();
const numbers = input.shift().split(" ").map(Number);
let visited = new Array(numbers.length).fill(0);
let result = 0;

for (let i = 0; i < numbers.length; i++) {
  visited[i] = 1;
  dfs(0, [numbers[i]]);
  visited[i] = 0;
}

function dfs(count, array) {
  if (array.length === numbers.length) {
    let sum = 0;
    for (let i = 0; i < array.length - 1; i++) {
      sum += Math.abs(array[i] - array[i + 1]);
    }
    result = Math.max(sum, result);
  }

  for (let i = 0; i < numbers.length; i++) {
    if (visited[i] === 1) continue;
    visited[i] = 1;
    let narray = [...array];
    narray.push(numbers[i]);
    dfs(count + 1, narray);
    visited[i] = 0;
  }
}

console.log(result);
