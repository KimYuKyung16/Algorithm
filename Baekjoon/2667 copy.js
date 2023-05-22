const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

const N = Number(input[0]);
let visited = new Array(N+1).fill(0);
let result = [];
let count = 0;

for (let i=0; i<visited.length; i++) {
  visited[i] = new Array(N).fill(0);
}

for (let i=1; i<input.length; i++) {
  for (let j=0; j<input[i].length; j++) {

    if (input[i][j] === '1' && visited[i][j] === 0) {
      visited[i][j] = 1;
      count = 1;
      dfs(i, j+1); // 오른쪽 
      dfs(i, j-1); //왼쪽
      dfs(i+1, j); // 아래쪽
      dfs(i-1, j); // 위쪽

      result.push(count);
    }
  }
}

function dfs(r, c) { // 행, 열
  if (r < 1 || r > N || c < 0 || c > N-1) { return; }
  if (visited[r][c] === 1) { return; }
  if (input[r][c] === '0') { return; }

  visited[r][c] = 1;
  count++;

  dfs(r, c+1); // 오른쪽 
  dfs(r, c-1); //왼쪽
  dfs(r+1, c); // 아래쪽
  dfs(r-1, c); // 위쪽
}

console.log(String(result.length));
console.log(result.sort((a,b) => a-b).join('\n'));