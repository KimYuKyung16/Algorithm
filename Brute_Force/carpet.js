function solution(brown, yellow) {
  var answer = [];
  let height, width;
  
 for (height=1; height<=yellow; height++) {
     width = yellow / height;
     if ((width * 2 + height * 2) + 4 == brown) return [width+2, height+2];
 }
}