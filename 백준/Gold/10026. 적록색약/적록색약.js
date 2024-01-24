const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

let N = +input[0];
let array = [];

let direction = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
]

for (let i=1; i<input.length; i++) {
  array.push(input[i].split(''));
}

let visited = new Array(N).fill(0).map(() => new Array(N).fill(0));
let color_weak_visited = new Array(N).fill(0).map(() => new Array(N).fill(0));

let count = [0, 0];

for (let y=0; y<N; y++) {
  for (let x=0; x<N; x++) {
    if (visited[y][x] === 0) {
      dfs(y, x, array[y][x]); // 적록색약X
      count[0]++;
    }
    if (color_weak_visited[y][x] === 0) {
      color_weak_dfs(y, x, array[y][x]); // 적록색약O
      count[1]++;
    }

    function dfs(y, x, color) {
      if (visited[y][x] === 1) return;
      if (y < 0 || y >= N || x < 0 || x >= N) return;
      if (array[y][x] !== color) return;
      visited[y][x] = 1;

      for (let i=0; i<4; i++) {
        let ny = y+direction[i][0];
        let nx = x+direction[i][1];

        if (ny < 0 || ny >= N || nx <0 || nx >= N) continue;
        dfs(ny, nx, color);
      }
    }

    function color_weak_dfs(y, x, color) {
      if (color_weak_visited[y][x] === 1) return;
      if (y < 0 || y >= N || x <0 || x >= N) return;
      if (array[y][x] !== color) {
        if ((color === 'R' || color === 'G') && array[y][x] === 'B') return;
        if (color === 'B' && (array[y][x] === 'R' || array[y][x] === 'G')) return;
      }
      color_weak_visited[y][x] = 1;

      for (let i=0; i<4; i++) {
        let ny = y+direction[i][0];
        let nx = x+direction[i][1];

        if (ny < 0 || ny >= N || nx <0 || nx >= N) continue;
        color_weak_dfs(ny, nx, color);
      }
    }
  }
}

console.log(count[0], count[1]);
