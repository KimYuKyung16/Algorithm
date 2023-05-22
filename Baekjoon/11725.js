const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

let N = +input[0];
let array = new Array(N+1).fill(0).map(() => []);
let parent = new Array(N+1).fill(0);
let visited = new Array(N+1).fill(0);

for (let i=1; i<input.length; i++) {
  let [x, y] = input[i].split(' ').map(Number);
  array[x].push(y);
  array[y].push(x);
}

dfs(1);

function dfs(index) {
  if (visited[index] === 1) return;
  visited[index] = 1;

  for (let i=0; i<array[index].length; i++) {
    if (visited[array[index][i]] === 0) {
      parent[array[index][i]] = index;
      dfs(array[index][i]);
    }
  }
}

console.log(parent.splice(2).join('\n'));