function solution(survey, choices) {
    const record = {};
    
    for (let i=0; i<survey.length; i++) {
        const [l, r] = survey[i].split("");
        const c = choices[i];
        
        if (c === 1) {
            record[l] = (record[l] ?? 0) + 3;
        } else if (c === 2) {
            record[l] = (record[l] ?? 0) + 2;
        } else if (c === 3) {
            record[l] = (record[l] ?? 0) + 1;
        } else if (c === 4) {
            continue;
        } else if (c === 5) {
            record[r] = (record[r] ?? 0) + 1;
        } else if (c === 6) {
            record[r] = (record[r] ?? 0) + 2;
        } else if (c === 7) {
            record[r] = (record[r] ?? 0) + 3;
        }
    }
    
    return getMBTI(record);
}

function getMBTI(record) {
    let mbti = "";
    const types = ["RT", "CF", "JM", "AN"];
    
    for (let t of types) {
        const [l, r] = t.split("");
        const lc = record[l] ?? 0;
        const rc = record[r] ?? 0;
        
        if (lc > rc) {
            mbti += l;
        } else if (lc < rc) {
            mbti += r;
        } else {
            mbti += [l, r].sort()[0];
        }
    }
    
    return mbti;
}