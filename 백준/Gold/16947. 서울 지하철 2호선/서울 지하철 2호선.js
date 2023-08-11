const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
input = input.map((x) => x.trim("\r"));

const N = +input.shift();

let tree = new Array(N+1).fill().map(() => []);
let visited = new Array(N+1).fill(0);
let answer = new Array(N).fill(null);

for (let i=0; i<N; i++) {
  const [l, r] = input[i].split(' ').map(Number);
  tree[l].push(r);
  tree[r].push(l);  
}

let flag = 0;
let circle;

for (let i=1; i<tree.length; i++) {
  if (flag) break;
  visited[i] = 1;
  dfs(i, i, [i]);
}

function dfs(current, pre, middleCircle) {
  for (let i=0; i<tree[current].length; i++) {
    if (visited[tree[current][i]]) {
      if (tree[current][i] === pre) {
        continue;
      } else {
        flag = 1;
        circle = [...middleCircle];
        while (circle[0] !== tree[current][i]) {
          circle.shift();
        }
        return 
      }
    }
    visited[tree[current][i]] = 1;
    let nMiddleCircle = [...middleCircle]
    nMiddleCircle.push(tree[current][i]);
    dfs(tree[current][i], current, nMiddleCircle);

    if (flag) return;
  }
}

for (let i=0; i<circle.length; i++) {
  answer[circle[i]-1] = 0;
}

for (let i=0; i<circle.length; i++) {
  getDistance(circle[i], 1);
}

function getDistance(currentNum, count) {
  for (let i=0; i<tree[currentNum].length; i++) {
    if (answer[tree[currentNum][i]-1] !== null) continue;
    answer[tree[currentNum][i]-1] = count;
    getDistance(tree[currentNum][i], count+1);
  }
}

console.log(answer.join(' '))
