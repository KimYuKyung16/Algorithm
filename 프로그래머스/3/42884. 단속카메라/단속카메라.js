function solution(routes) {
    let answer = 1;
    routes.sort((a,b) => a[1]-b[1]);
    
    let current = routes[0][1];
    let index = 1;
    while(index < routes.length) {
        if (routes[index][0] > current) {
            current = routes[index][1];
            answer++;
        }
        index++;
    
    }
    return answer;
}