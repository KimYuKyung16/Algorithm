function solution(cacheSize, cities) {
    var answer = 0;
    let cache_list = new Set();
    
    if (cacheSize === 0) return cities.length * 5
    
    for (let i=0; i<cities.length; i++) {
        const c = cities[i].toLowerCase();
        if (cache_list.has(c)) {
            cache_list.delete(c);
            answer += 1;
        } else {
            if (cache_list.size >= cacheSize) {
                let tmp = [...cache_list];
                tmp.shift();
                cache_list = new Set(tmp)
            }
            answer += 5;
        }
        cache_list.add(c)
    }
    
    return answer;
}