function solution(triangle) {
    let dp = new Array(triangle.length).fill().map((_, index) => new Array(index+1).fill(0));
    dp[0][0] = triangle[0][0];
    for (let i=0; i<triangle.length-1; i++) {
        for (let j=0; j<triangle[i].length; j++) {
            let sum = dp[i][j] + triangle[i+1][j];
            dp[i+1][j] = Math.max(dp[i+1][j], sum);
            
            let sum2 = dp[i][j] + triangle[i+1][j+1];
            dp[i+1][j+1] = Math.max(dp[i+1][j+1], sum2);
        }
    }
    return Math.max(...dp[dp.length-1]);
}