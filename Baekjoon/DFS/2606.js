const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

// bfs를 쓰는 게 좋을 것 같음!
const n = Number(input[0]);
let array = new Array(n+1);
for (let i=0; i<array.length; i++) {
  array[i] = [];
}

for (let i=2; i<input.length; i++) {
  let [x, y] = input[i].split(' ').map(Number);

  array[x].push(y);
  array[y].push(x);
}

let visited = new Array(n+1).fill(0);
let result = 0;

function bfs(current) {
  let queue = [current];

  while (queue.length) {
    let val = queue.shift();

    if (visited[val] === 1) { continue };
    visited[val] = 1;
    result++;

    for (let i=0; i<array[val].length; i++) {
      if (visited[array[val][i]] === 0) { // 방문을 안했을 경우
        queue.push(array[val][i]);
      }
    }
  }
}

bfs(1);

console.log(result === -1 ? 0 : result-1);