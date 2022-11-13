function solution(sizes) {
  var answer = 0;
  let first_array = [];
  let second_array = [];
  
  sizes.forEach((x) => (x.sort((a,b) => a-b)))
  
  sizes.forEach((array)=> {
      [x, y] = array;
      first_array.push(x);
      second_array.push(y);
      })
      
  return Math.max(...first_array) * Math.max(...second_array);
}