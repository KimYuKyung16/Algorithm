// 1. h, n, t로 분리

function solution(files) {
   
    for(let i=0; i<files.length; i++) {
        files[i] = seperate(i, files[i]);
    }
    
    
    files.sort((a,b) => {
        // head 기준 사전순 정렬
        if (a[0].toLowerCase() === b[0].toLowerCase()) {
            // number 기준 숫자순 정렬
            if (Number(a[1]) === Number(b[1])) {
                return a[3] - b[3]; 
            } else {
                return Number(a[1]) - Number(b[1]);
            }
        } else {
            return a[0].toLowerCase().localeCompare(b[0].toLowerCase());
        }
    });
    
    return files.map((file) => {
        return file[0]+file[1]+file[2];
    })
}

function seperate(index, file) {
    const isAlpa = /[a-zA-Z]/;
    const isNum = /[0-9]/;
    
    let h = ''
    let n = '';
    let t = '';
    
    let state = 'head';
    for (f of file) {
        if (state === 'head' && isNum.test(f)) {
            state = 'number';
        } else if (state === 'number' && !isNum.test(f)) {
            state = 'tail';
        }
        
        if (state === 'head') {
            h += f;
        } else if (state === 'number') {
            n += f;
        } else {
            t += f;
        }
    }
    
    return [h, n, t, index];
}