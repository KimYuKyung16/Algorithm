function solution(dartResult) {
    let answer = 0;
    let record = [];
    const bonus = {
        'S': 1,
        'D': 2,
        'T': 3
    }
    
    let dr = dartResult.split(/([SDT*#])/g);
    for (d of dr) {
        if (d === '') continue;
        let len = record.length;
        
        if (d === 'S' || d === 'D' || d === 'T') { // 보너스
            record[len-1] = Math.pow(record[len-1], bonus[d]);
        } else if (d === '*' || d === '#') { // 옵션
            if (d === '*') {
                if (len === 0) continue;
                record[len-1] *= 2;
                if (len < 2) continue;
                record[len-2] *= 2;
            } else if (d === '#') {
                if (len === 0) continue;
                record[len-1] = -record[len-1];
            }
        } else { // 점수
            record.push(Number(d));
        }
    }
    
    for (r of record) {
        answer += r;
    }
    
    return answer;
}