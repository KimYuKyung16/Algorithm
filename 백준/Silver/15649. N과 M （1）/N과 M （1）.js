const fs = require('fs');
let [N, M] = fs.readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);

let answer = [];
let visited = new Array(N+1).fill(0);
for (let i=1; i<=N; i++) {
  visited[i] = 1;
  dfs([i], 1);
  visited[i] = 0;
}

function dfs(array, count) {
  if (count === M) {
    answer.push(array.join(' '));
    return;
  }
  for (let i=1; i<=N; i++) {
    if (visited[i] === 0) {
      let narray = [...array];
      narray.push(i);

      visited[i] = 1;
      dfs(narray, count+1);
      visited[i] = 0;
    }
  }
}

console.log(answer.join('\n'));