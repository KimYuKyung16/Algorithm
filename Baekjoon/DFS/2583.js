const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

let [M, N, K] = input[0].split(' ').map(Number);
let visited = new Array(M).fill(0).map(() => new Array(N).fill(0));
let answer = 0;
let location_size_list = [];
let location_size; 

for (let i=1; i<input.length; i++) {
  let [ld_x, ld_y, ru_x, ru_y] = input[i].split(' ').map(Number);
  // let column_count = ru_y - ld_y;

  for (let y=ld_y; y<ru_y; y++) {
    for (let x=ld_x; x<ru_x; x++) {
      visited[y][x] = 1;
    }
  }
}

for (let y=0; y<M; y++) {
  for (let x=0; x<N; x++) {
    if (visited[y][x] === 0) {
      location_size = 0; 
      dfs(y, x);
      answer++;
      location_size_list.push(location_size);
    }
  }
} 

function dfs(y, x) {
  if (y < 0 || y > M-1 || x < 0 || x > N-1) return;
  if (visited[y][x] === 1) return;
  visited[y][x] = 1;
  location_size++;

  dfs(y+1, x);
  dfs(y-1, x);
  dfs(y, x+1);
  dfs(y, x-1);
}

console.log(answer);
console.log(location_size_list.sort((a,b) => a-b).join(' '));