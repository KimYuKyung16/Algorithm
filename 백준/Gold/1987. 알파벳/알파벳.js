const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

let [R, C] = input[0].split(' ').map(Number);
let board = [];
let answer = 0;

const direction = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
]

let visited = new Array(R).fill(0).map(() => new Array(C).fill(0));
let alpha_visited = new Array(26).fill(0);

for (let i=1; i<input.length; i++) {
  board.push(input[i].split(''));
}

dfs(0, 0, 0);

function dfs(y, x, count) {
  if (y < 0 || y >= R || x < 0 || x >= C) {
    answer = Math.max(answer, count);
    return;
  }
  // 알파벳이 지금까지 지나온 곳 중에 있다면
  if (alpha_visited[board[y][x].charCodeAt(0)-65]) { 
    answer = Math.max(answer, count);
    return;
  }
  if (visited[y][x] === 1) {
    answer = Math.max(answer, count);
    return;
  }

  count++;
  visited[y][x] = 1;
  alpha_visited[board[y][x].charCodeAt(0)-65] = 1;

  for (let i=0; i<4; i++) {
    let ny = y + direction[i][0];
    let nx = x + direction[i][1];

    if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
      answer = Math.max(answer, count);
      continue;
    }
    dfs(ny, nx, count);
  }
  visited[y][x] = 0;
  alpha_visited[board[y][x].charCodeAt(0)-65] = 0;
}

console.log(answer);

