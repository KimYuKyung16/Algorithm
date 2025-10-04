function solution(new_id) {
    // 1
    new_id = new_id.toLowerCase();
    // 2
    new_id = new_id.replace(/[^a-z0-9._-]/g, '');
    // 3
    let isPrev = false;
    let new_id_array = [...new_id];
    for (let i=0; i<new_id_array.length; i++) {
        if (new_id_array[i] === '.') {
            if (isPrev) {
                new_id_array[i] = '';
            } else {
                isPrev = true;
            }
        } else {
            isPrev = false;
        }
    }
    new_id = new_id_array.join('')
    // 4
    if (new_id[0] === '.') {
        new_id = new_id.slice(1, new_id.length);
    }
    if (new_id[new_id.length-1] === '.') {
        new_id = new_id.slice(0, new_id.length-1);
    }
    // 5
    if (new_id.length === 0) new_id = 'a';
    // 6
    if (new_id.length >= 16) {
        new_id = new_id.slice(0, 15);
    }
    if (new_id[new_id.length-1] === '.') {
        new_id = new_id.slice(0, new_id.length-1);
    }
    // 7
    if (new_id.length <= 2) {
        let last = new_id[new_id.length-1];
        new_id = new_id.padEnd(3, last);
    }
    
    return new_id;
}