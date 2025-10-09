// 1. uid를 key로 해서 하고 value에 nickname이랑 문구 넣기
function solution(record) {
    var answer = [];
    const map = {};
    
    for (let i=0; i<record.length; i++) {
        const [s, id, u] = record[i].split(' ');
        
        if (s === 'Enter') {
            map[id] = map[id] ?? {nickname: u, action: []};
            map[id]['nickname'] = u;
            map[id]['action'].push([i, "님이 들어왔습니다."]);
        } else if (s === 'Leave') {
            map[id]['action'].push([i, "님이 나갔습니다."]);
        } else { // 'Change'
            map[id] = { ...map[id], nickname: u };
        }
    }
    
    let arr = [];
    for (entry of Object.entries(map)) {
        const { nickname, action } = entry[1];
        for (a of action) {
            arr.push([a[0], nickname + a[1]]);
        }
    }
    
    arr.sort((a,b) => a[0]-b[0]);
    return arr.map((x) => x[1]);
}