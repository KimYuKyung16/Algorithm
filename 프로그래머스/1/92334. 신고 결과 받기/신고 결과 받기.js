function solution(id_list, report, k) {
    const answer = []
    const record = {};
    const report_count = {};
    
    for (id of id_list) {
        record[id] = [];
        report_count[id] = 0;
    }
    
    for (re of report) {
        let [l, r] = re.split(' ');
        if (!record[l].includes(r)) {
            record[l].push(r);
            report_count[r]++;
        }
    }
    
    const stop_user = [];
    for (u of Object.entries(report_count)) {
        if (u[1] >= k) {
            stop_user.push(u[0]);
        }
    }
    
    for (u of id_list) {
        const arr = record[u];
        let count = 0;
        for (su of stop_user) {
            if (arr.includes(su)) count++;
        }
        answer.push(count);
        count = 0;
    }
    
    return answer;
}