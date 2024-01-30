const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

const T = Number(input[0]);
let current_index;
let result = [];

for (let i=0; i<T; i++) {
  let M, N, K;
  let field, visited;
  let count = 0;

  if (i === 0) {
    [M, N, K] = input[1].split(' ').map(Number);
    field = Array.from({length: N}, () => Array(M).fill(0));
    visited = Array.from({length: N}, () => Array(M).fill(0));
    current_index = 1;

    for (let j=2; j<current_index+1+K; j++) {
      let [c, r] = input[j].split(' ').map(Number);
      field[r][c] = 1;
    }
  } else {
    [M, N, K] = input[current_index].split(' ').map(Number);
    field = Array.from({length: N}, () => Array(M).fill(0));
    visited = Array.from({length: N}, () => Array(M).fill(0));

    for (let j=current_index+1; j<current_index+1+K; j++) {
      let [c, r] = input[j].split(' ').map(Number);
      field[r][c] = 1;
    }
  }

  for (let r = 0; r<N; r++) {
    for (let c = 0; c<M; c++) {
      if (field[r][c] === 1 && visited[r][c] === 0) {
        visited[r][c] = 1;
        dfs(r+1, c);
        dfs(r-1, c);
        dfs(r, c+1);
        dfs(r, c-1);

        count++;
      }
    }
  }
  
  result.push(count);
  current_index += (K+1);

  function dfs(r, c) {
    if (r < 0 || r > N-1 || c > M-1 || c < 0) return;
    if (field[r][c] === 0 || visited[r][c] === 1) return;

    visited[r][c] = 1;
    dfs(r+1, c);
    dfs(r-1, c);
    dfs(r, c+1);
    dfs(r, c-1);
  }
}

console.log(result.join('\n'));

