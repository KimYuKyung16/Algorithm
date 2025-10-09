// 1. 2개씩 끊기 (str1, str2) - 특수문자 있으면 제외!!
// 2. 2개씩 끊은 값을 map에 넣기 (key는 단어, value는 count)
// 3. 양쪽 비교
function solution(str1, str2) {
    const map1 = getWord(str1);
    const map2 = getWord(str2);
    
    const set = new Set([...Object.keys(map1), ...Object.keys(map2)]);
    let count1 = 0; // 교
    let count2 = 0; // 합
    for (v of set) {
        const v1 = map1[v] ?? 0;
        const v2 = map2[v] ?? 0;
        count1 += Math.min(v1, v2);
        count2 += Math.max(v1, v2);
    }
    
    if (count1 === 0 && count2 === 0) return 65536;
    return Math.floor((count1/count2) * 65536);
}

function getWord(str) {
    const map = {};
    
    const reg = /[a-zA-Z]/;
    for (let i=0; i<str.length-1; i++) {
        let v = str[i] + str[i+1];
        v = v.toLowerCase();
        
        if (!reg.test(v[0]) || !reg.test(v[1])) continue;
        map[v] = (map[v] ?? 0) + 1;
    }
    
    return map;
}