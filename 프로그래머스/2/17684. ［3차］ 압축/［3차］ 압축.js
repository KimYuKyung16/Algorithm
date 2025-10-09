function solution(msg) {
    const answer = [];
    const dic = {};
    
    for (let i=65; i<=65+25; i++) {
        const num = String.fromCharCode(i);
        dic[num] = i-64;
    }
    
    let dicIdx = 27;
    for(let i=0; i<msg.length; i++) {
        let index = i;
        let str = msg[index];
        
        while(true) {
            const isDic = dic[str];
            if (isDic) {
                if (index+1 >= msg.length) {
                    answer.push(dic[str]);
                    return answer
                }
                str += msg[++index];
            } else {
                answer.push(dic[str.slice(0, str.length-1)]);
                if (dic[str]) break;
                dic[str] = dicIdx;
                break;
            }
        }
        i = index-1;
        dicIdx++;
    }
    
    return answer;
}