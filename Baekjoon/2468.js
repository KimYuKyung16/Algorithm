const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim("\r"))

let N = +input[0];
let array = [];
let maxNum = 0;
let result = 0;

for (let i=1; i<input.length; i++) {
  let current_array = input[i].split(' ').map(Number);
  maxNum = Math.max(maxNum, Math.max(...current_array));
  array.push(current_array);
}

for (let i=1; i<=maxNum; i++) { // 빗물
  let visited = new Array(N).fill(0).map(() => new Array(N).fill(0));
  let answer = 0;

  for (let y=0; y<N; y++) {
    for (let x=0; x<N; x++) {
      if (array[y][x] <= i) visited[y][x] = 1;
      if (visited[y][x] === 0) {
        dfs(y, x);
        answer++;
      }
    }
  }

  result = Math.max(result, answer);

  function dfs(y, x) {
    if (y < 0 || y > N-1 || x < 0 || x > N-1) return;
    if (array[y][x] <= i) visited[y][x] = 1;
    if (visited[y][x] === 1) return;

    visited[y][x] = 1;

    dfs(y+1, x) // 아래
    dfs(y-1, x) // 위
    dfs(y, x-1) // 왼
    dfs(y, x+1) // 오른
  }
}

if (result === 0) result = 1;
console.log(result);

