function solution(friends, gifts) {
    const record = {};
    const answer = {};
    
    for (gift of gifts) {
        const [sender, receiver] = gift.split(" ");
        if (!record[sender]) record[sender] = {};
        if (!record[receiver]) record[receiver] = {};
        
        record[sender][receiver] = (record[sender][receiver] ?? 0) + 1;
        record[receiver][sender] = (record[receiver][sender] ?? 0);
        record[sender]['score'] = (record[sender]['score'] ?? 0) + 1;
        record[receiver]['score'] = (record[receiver]['score'] ?? 0) - 1;
    }
    
    for (r of friends) {
        for (s of friends) {
            if (r === s) continue;
            const rs = (record[r] ?? {})[s] ?? 0;
            const ss = (record[s] ?? {})[r] ?? 0;
            
            if (rs > ss) {
                answer[r] = (answer[r] ?? 0) + 1;
            } else if (rs < ss) {
                answer[s] = (answer[s] ?? 0) + 1;
            } else {
                const rScore = record[r]?.score ?? 0;
                const sScore = record[s]?.score ?? 0;
                if (rScore > sScore) {
                    answer[r] = (answer[r] ?? 0) + 1;
                } else if (rScore < sScore) {
                    answer[s] = (answer[s] ?? 0) + 1;
                }
            }
        }
    }
    
    if (Object.keys(answer).length === 0) {
        return 0;
    } else {
        return Math.max(...Object.values(answer)) / 2;
    }
   
}