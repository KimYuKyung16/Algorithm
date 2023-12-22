const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M, R] = input.shift().split(' ').map(Number);
const arr = input.map((v) => v.split(' ').map(Number));
const graph = [...Array(N + 1)].map(() => []);
const visited = Array(N).fill(0);
let cnt = 1;

arr.map(([from, to]) => {
  graph[from].push(to);
  graph[to].push(from);
});

graph.map((v) => v.sort((a, b) => a - b));

const dfs = (node) => {
  if (!visited[node - 1]) {
    visited[node - 1] = cnt;
    cnt++;
    for (const next of graph[node]) dfs(next); // 재귀
  }
};

dfs(R);

console.log(visited.join('\n'));