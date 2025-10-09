// 1. 시간을 다 분으로 변경
// 2. 계산
function solution(fees, records) {
    let answer = [];
    const map = {};
    const fee = {};
    
    for (r of records) {
        const [t, n, s] = r.split(' ');
        if (s === 'IN') {
            map[n] = {
                time: convertTime(t),
                state: 'IN'
            }
        } else {
            fee[n] = (fee[n] ?? 0) + (convertTime(t) - map[n]['time']);
            map[n].state = 'OUT';
        }
    }
    
    const [dt, df, sm, sf] = fees;
    const entries = Object.entries(map);
    entries.sort((a,b) => Number(a[0]) - Number(b[0]));
    for (let v of entries) {
        const car = v[0];
        if (v[1]['state'] === 'IN') {
            fee[car] = (fee[car] ?? 0) + (convertTime('23:59') - map[car]['time']);
        }
        
        const f = fee[car];
        
        let totalF = 0;
        if (f > dt) {
            totalF += df;
            totalF += (Math.ceil((f - dt) / sm) * sf);
        } else {
            totalF = df;
        }
        
        answer.push(totalF);
    }
    
    return answer;
}

function convertTime(time) {
    const [h, m] = time.split(':');
    return (Number(h) * 60) + Number(m);
}