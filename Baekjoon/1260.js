const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

let [n, m, v] = input[0].split(' ').map(Number);

let array = new Array(n+1);

for (let i=0; i<array.length; i++) {
  array[i] = [];
}

for (let i=1; i<=m; i++) {
  let [x, y] = input[i].split(' ').map(Number);
  array[x].push(Number(y));
  array[y].push(Number(x));
}

for (let i=1; i<array.length; i++) {
  array[i].sort((a, b) => a-b);
}

let dfs_array = [];
let state = new Array(n+1).fill(1);

function dfs(index) {
  if (!state[index]) return;
  state[index] = 0;
  dfs_array.push(index);
  for (let i=0; i<array[index].length; i++) {
    let next = array[index][i];
    if (state[next] === 1) {
      dfs(next);
    }
  }
}

dfs(v);

let bfs_array = [];
state.fill(1);
function bfs(index) {
  let queue = [index];
  while (queue.length) {
    let x = queue.shift();
    if (state[x] === 0) {
      continue;
    }
    state[x] = 0;
    bfs_array.push(x);
    for (let i = 0; i < array[x].length; i++) {
      let next = array[x][i];
      if (state[next] === 1) {
        queue.push(next);
      }
    }
  }
}

bfs(v);


console.log(dfs_array.join(' '));
console.log(bfs_array.join(' '));

