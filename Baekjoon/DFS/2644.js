const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

let n = +input[0]; // 전체 사람의 수
let [a, b] = input[1].split(' ').map(Number); // 촌수 계산할 두명
let m = +input[2]; // 관계 개수

let visited = new Array(n+1).fill(0);
let answer_list = [];
let answer = 0;

let tree = new Array(n+1).fill(0).map(() => []);

for (let i=3; i<input.length; i++) {
  let [parent, child] = input[i].split(' ').map(Number);
  tree[parent].push(child);
}

let start = +input[3].split(' ')[0]
if (a === start || b === start) answer_list.push([start, 0]);

for (let i=0; i<tree[start].length; i++) {
  if (answer_list.length === 2) break;
  dfs(tree[start][i], 1);
  visited[start] = 1;
}

function dfs(num, h) { // h: 트리 높이
  if (visited[num] === 1) return;
  if (num === a || num === b) answer_list.push([num, h]);
  if (answer_list.length === 2) {
    if (visited[answer_list[0][0]] === 1) answer_list.forEach((x) => answer = answer + x[1]);
    else answer = answer_list[0][0] > answer_list[1][0] ? answer_list[0][1] -  answer_list[1][1] : answer_list[1][1] -  answer_list[0][1]
    return;
  }

  for (let i=0; i<tree[num].length; i++) {
    dfs(tree[num][i], h+1);
    visited[tree[num][i]] = 1;
  }
  visited[num] = 1;
}

console.log(answer_list)

if (answer_list.length !== 2) answer = -1 
console.log(answer)