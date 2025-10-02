function solution(today, terms, privacies) {
    const answer = [];
    const map = {};
    const tt = getTime(today);
    
    for (term of terms) {
        const [t, p] = term.split(" ");
        map[t] = Number(p);
    }
    
    for (let i=0; i<privacies.length; i++) {
        const [d, t] = privacies[i].split(" ");
        const nt = getTime(d) + (28 * map[t]);
        
        if (tt >= nt) {
            answer.push(i+1);
        }
    }
    
    return answer;
}

function getTime(today) {
    const [y, m, d] = today.split(".");
    return (Number(y) * (12 * 28)) + (Number(m) * 28) + Number(d);
}