function solution(id_list, report, k) {
  var answer = [];
  var reported_user = []; // 신고당한 유저 목록
  var stopped_user = []; // 정지된 유저 목록 
  
  var id_list_dict = {}; // 유저별 신고접수 횟수
  
  for (i=0; i<id_list.length; i++) { // 객체 초기화
      id_list_dict[id_list[i]] = 0;
  }
  
  var report2 = [...new Set(report)]; // set 형태로 바꾸기: 중복 제거 / 중복 제거 후 다시 배열로 만들기
  
  for (var i=0; i<(report2.length); i++) {
      report2[i] = report2[i].split(" ");
      reported_user.push(report2[i][1]) // 신고당한 사람
  }
  
  for (var id of id_list) {
      var result = reported_user.filter(user => user == id ).length; // 신고당한 유저 횟수
      if (result >= k) {
          stopped_user.push(id); // 정지된 아이디
      }
  }
  
  for (i=0; i<report2.length; i++) {
      if (stopped_user.includes(report2[i][1])) {
          id_list_dict[report2[i][0]] += 1;
      }    
  }
  
  for (i=0; i<id_list.length; i++) {
      answer.push(id_list_dict[id_list[i]]);
  }
  
  return answer;
}