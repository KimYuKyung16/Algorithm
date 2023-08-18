const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
input = input.map((x) => x.trim("\r"));

const T = +input.shift();

for (let i = 0; i < T; i++) {
  const [N, M] = input.shift().split(" ").map(Number);
  let list = input.shift().split(" ").map(Number);
  let impotantList = [...list].sort((a, b) => b - a);
  let result = 0;

  for (let j = 0; j < list.length; j++) {
    list[j] = [j, list[j]];
  }

  while (list.length !== 0) {
    const current = list.shift();
    if (impotantList[0] === current[1]) {
      impotantList.shift();
      result++;

      if (current[0] === M) {
        console.log(result);
        break;
      }
    } else {
      list.push(current);
    }
  }
}
