const fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map((x) => x.trim('\r'));

const arrayA = input[1].split(' ');
const arrayB = input[2].split(' ');

console.log([...arrayA, ...arrayB].sort((a,b) => a-b).join(' '));


/*
투 포인터를 이용한 풀이방법

function solution(arr1, arr2) {
  let p1 = 0;
  let p2 = 0;
  let value = 0;
  let answer = [];

  // 길이가 더 짧은 배열 탐색이 끝나면 아래 while문은 더이상 실행되지 않음
  while (p1 < arr1.length && p2 < arr2.length) {
    if (arr1[p1] < arr2[p2]) {
      answer.push(arr1[p1]);
      p1++;
    } else {
      answer.push(arr2[p2]);
      p2++;
    }
  }

  // 길이가 더 긴 배열의 남은 요소를 answer 배열에 담아주기
  while (p1 < arr1.length) {
    answer.push(arr1[p1]);
    p1++;
  }

  while (p2 < arr2.length) {
    answer.push(arr2[p2]);
    p2++;
  }

  return answer;
}

let a = [1, 3, 5];
let b = [2, 3, 6, 7, 9];
console.log(solution(a, b));
*/