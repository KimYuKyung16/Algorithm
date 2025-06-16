function solution(n, computers) {
    let answer = 0;
    const visited = new Array(n);
    const graph = new Map();
    
    for (let i=0; i< n; i++) {
        graph.set(i, []);
        for (let j = 0; j < n; j++) {
          if (i !== j && computers[i][j] === 1) {
            graph.get(i).push(j);
          }
        }
    }
    
    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            bfs(i);
            answer++;
        }
    }
    
    function bfs(num) {
        let queue = [];
        visited[num] = true;
        queue.push(num);
        
        while(queue.length !== 0) {
            const current = queue.shift();
            for (const v of graph.get(current)) {
                if (visited[v]) continue;
                visited[v] = true;
                queue.push(v);
            }
        }
    }
    
    return answer;
}