let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

const n = Number(input[0]);
const [p, q] = input[1].split(" ").map(Number);
const m = Number(input[2]);
const grph = [...Array(n + 1)].map((e) => []);

for (let i = 3; i < m + 3; i++) {
  let [parent, child] = input[i].split(" ").map(Number);
  grph[parent].push(child);
  grph[child].push(parent);
}

const bfs = (graph, startNode, targetNode) => {
  const visited = [];
  let needVisit = [[startNode, 0]];

  while (needVisit.length !== 0) {
    const [node, cnt] = needVisit.shift();
    if (node === targetNode) return cnt;
    if (!visited.includes(node)) {
      visited.push(node);
      let nodes = graph[node].map((e) => [e, cnt + 1]);
      needVisit = [...needVisit, ...nodes];
    }
  }

  return -1;
};

console.log(bfs(grph, p, q));