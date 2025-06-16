function solution(begin, target, words) {
    let visited = new Array(words.length).fill(false);
    if (!words.includes(target)) return 0;
    return bfs(target);
    
    function bfs(start) {
        let answer = Number.MAX_SAFE_INTEGER;
        let queue = [];
        queue.push([start, 1]);

        while(queue.length !== 0) {
            let current = queue.shift();
            let cStr = current[0];
            let cCount = current[1];
            
            if (available(cStr, begin)) {
                answer = Math.min(answer, cCount);
                break;
            }
            
            for (let i=0; i<words.length; i++) {
                if (visited[i]) continue;
                if (available(cStr, words[i])) {
                    visited[i] = true;
                    queue.push([words[i], cCount+1]);
                }
            }   
        }
        
        return answer;
    }

    function available(str1, str2) {
        let count = 0;
        for (let i=0; i<str1.length; i++) {
            if (str1[i] === str2[i]) count++;
        }
        return count === str1.length-1 ? true : false;
    }
}

