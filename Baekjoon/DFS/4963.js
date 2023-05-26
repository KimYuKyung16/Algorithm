const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

// 1은 땅, 0은 바다

let testCase_index = 0;
while(testCase_index !== input.length-1) {
  let [w, h] = input[testCase_index].split(' ').map(Number);
  let visited = new Array(h).fill(0).map(() => new Array(w).fill(0));
  let array = [];
  let result = 0;

  for (let i=testCase_index+1; i<testCase_index+1+h; i++) {
    array.push(input[i].split(' ').map(Number));
  }

  for (let y=0; y<h; y++) { // 세로
    for (let x=0; x<w; x++) { // 가로
      if (visited[y][x] === 0 && array[y][x] === 1) {
        dfs(y, x);
        result++;
      }
    }
  }
  
  console.log(result);
  testCase_index += h+1;

  function dfs(y, x) {
    if (y < 0 || y > h-1 || x < 0 || x > w-1) return;
    if (array[y][x] === 0 || visited[y][x] === 1) return;
  
    visited[y][x] = 1;

    dfs(y+1, x); // 아래
    dfs(y-1, x); // 위
    dfs(y, x+1); // 오른쪽
    dfs(y, x-1); // 왼쪽
  
    dfs(y+1, x-1); // 왼위 대각선
    dfs(y+1, x+1); // 오위 대각선
    dfs(y-1, x-1); // 왼아래 대각선
    dfs(y-1, x+1); // 오아래 대각선
  }
}


