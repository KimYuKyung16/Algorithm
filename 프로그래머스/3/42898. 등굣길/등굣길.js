function solution(m, n, puddles) {
    const MOD = 1000000007;
    let dp = Array.from({length: n}, () => new Array(m).fill(0));
    
    for (let [x, y] of puddles) {
        dp[y-1][x-1] = -1;
    }
    
    dp[0][0] = 1;
    
    for (let i=1; i<n; i++) {
        if (dp[i][0] === -1) break;
        dp[i][0] = dp[i-1][0];
    }
    for (let i=1; i<m; i++) {
        if (dp[0][i] === -1) break;
        dp[0][i] = dp[0][i-1];
    }

    for (let y=1; y<n; y++) {
        for (let x=1; x<m; x++) {
            if (dp[y][x] === -1) {
                continue;
            }
            let left = dp[y][x - 1] === -1 ? 0 : dp[y][x - 1];
            let top = dp[y - 1][x] === -1 ? 0 : dp[y - 1][x];
            dp[y][x] = left % MOD + top % MOD;
        }
    }
    
    return dp[n-1][m-1] % MOD;
}