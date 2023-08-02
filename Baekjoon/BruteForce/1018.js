// 화이트 보드일 경우와 블랙 보드일 경우를 미리 넣어놓는다.

const fs = require("fs");
let input = fs.readFileSync("input.txt").toString().trim().split("\n");
input = input.map((x) => x.trim("\r"));

const [N, M] = input.shift().split(" ").map(Number);
let answer = Number.MAX_SAFE_INTEGER;

const whiteBoard = [
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
];

const blackBoard = [
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
];

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (i + 7 > N - 1 || j + 7 > M - 1) continue;
    let count = confirmBoard(i, j);
    answer = Math.min(answer, count);
  }
}

console.log(answer);

function confirmBoard(y, x) {
  let whiteCount = 0;
  let blackCount = 0;

  for (let i = y; i < y + 8; i++) {
    for (let j = x; j < x + 8; j++) {
      if (input[i][j] !== whiteBoard[i - y][j - x]) whiteCount++;
      if (input[i][j] !== blackBoard[i - y][j - x]) blackCount++;
    }
  }

  return Math.min(whiteCount, blackCount);
}
