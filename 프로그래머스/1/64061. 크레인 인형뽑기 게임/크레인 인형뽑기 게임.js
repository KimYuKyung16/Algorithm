function solution(board, moves) {
    let answer = 0;
    let indexes = getIndex(board);
    let record = [];
    
    for (let i=0; i<moves.length; i++) {
        let c = moves[i] - 1;
        let r = indexes[c];
        if (r >= board.length) continue;
        record.push(board[r][c]);
        board[r][c] = 0;
        indexes[c] = indexes[c] + 1;
        
        if (record.length >= 2) {
            if (record[record.length-1] === record[record.length-2]) {
                answer++;  
                record.pop();
                record.pop();
            }
        }
    }
    
    return answer * 2;
}

function getIndex(board) {
    let N = board.length;
    let indexes = [];
    
    for (let i=0; i<N; i++) {
        for (let j=0; j<N; j++) {
            if (board[j][i] !== 0) {
                indexes[i] = j;
                break;
            }
        }
    }
    return indexes;
}