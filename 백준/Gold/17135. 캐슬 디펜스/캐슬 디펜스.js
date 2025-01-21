const fs = require("fs");
const input = fs
  .readFileSync("./dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((v) => v.split(" ").map(Number));
const [N, M, D] = input.shift();

const board = input;
let max = 0;

const archers = [];

for (let i = 0; i < 1 << M; i++) {
  let j = i;
  let archer = [];
  let cnt = 0;
  while (j > 0) {
    if (j & 1) {
      archer.push(cnt);
    }
    cnt++;
    j = j >> 1;
  }
  if (archer.length == 3) {
    archers.push(archer);
  }
}

const enemySort = (a, b) => {
  if (a[2] > b[2]) return 1;
  else if (a[2] < b[2]) return -1;
  else {
    return a[1] - b[1];
  }
};

archers.forEach((group) => {
  let field = board.map((v) => [...v]).reverse();
  let cnt = 0;

  for (let i = 0; i < N; i++) {
    const temp = [];
    group.forEach((a) => {
      const enemy = [];
      for (let x = 1; x <= D; x++) {
        for (let y = a - D + x; y < a + D - x + 1; y++) {
          if (x - 1 < 0 || y < 0 || x - 1 >= N || y >= M) continue;
          if (field[x - 1][y] == 1) {
            const dist = x + Math.abs(a - y);
            enemy.push([x - 1, y, dist]);
          }
        }
      }
      if (enemy.length > 0) {
        const [ex, ey] = enemy.sort(enemySort)[0];
        temp.push(JSON.stringify([ex, ey]));
      }
    });
    const target = [...new Set(temp)].map((v) => JSON.parse(v));
    target.forEach((v) => {
      const [tx, ty] = v;
      field[tx][ty] = 0;
      cnt++;
    });

    field.shift();
    field.push(new Array(M).fill(0));
  }
  max = Math.max(max, cnt);
});

console.log(max);