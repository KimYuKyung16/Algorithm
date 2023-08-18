const fs = require("fs");
const [N, K] = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let move = [+1, -1, 2];
let visited = new Array(100001).fill(0);

bfs();

function bfs() {
  let queue = [[N, 0]];

  while (queue.length !== 0) {
    const [value, time] = queue.shift();
    if (value === K) {
      console.log(time);
      return;
    }

    for (let i = 0; i <= 2; i++) {
      let next = i === 2 ? value * move[i] : value + move[i];
      if (next < 0 || next > 100001) continue;
      if (!visited[next]) {
        visited[next] = 1;
        queue.push([next, time + 1]);
      }
    }
  }
}
