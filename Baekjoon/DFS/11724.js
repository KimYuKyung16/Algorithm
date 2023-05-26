const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

let [N, M] = input[0].split(' ').map(Number);
let array = new Array(N+1);
let visited = new Array(N+1).fill(0);
let answer = 0;

for (let i=0; i<array.length; i++) {
  array[i] = new Array();
}

for (let i=1; i<input.length; i++) {
  let [u, v] = input[i].split(' ').map(Number);
  array[u].push(v);
  array[v].push(u);
}

for (let i=1; i<visited.length; i++) {
  if (visited[i] === 0) {
    dfs(i);
    answer++;
  }
}

function dfs(num) {
  visited[num] = 1;

  for (let i=0; i<array[num].length; i++) {
    if (visited[array[num][i]] === 0) {
      visited[array[num][i]] = 1;
      dfs(array[num][i]);
    }
  }
}

console.log(answer);




