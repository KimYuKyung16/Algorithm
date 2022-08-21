function solution(clothes) {
  var answer = 0;
  
  let clothes_list = []
  
  for (var i=0; i<clothes.length; i++) {
      clothes_list.push(clothes[i][1]);
  }
  let clothes_kind_list = new Set(clothes_list);
  
  for (i=0; i<clothes_kind_list.length; i++) {
      answer *= (clothes_list.filter(e => clothes_kind_list[i]))
  }
  
  return answer;
}
