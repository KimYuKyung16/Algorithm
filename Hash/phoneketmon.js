function solution(nums) {
  var answer = 0;
  
  choice_num = nums.length/2; // 고를 수 있는 폰켓몬의 수
  
  let kinds = new Set(nums); // 중복된 폰켓몬 제거
  const num = kinds.size; // 폰켓몬의 종류 수
  
  return  num <= choice_num ? num : choice_num;
}