<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
  $(function(){
	$('#btn_list').click(function(){
		location.href='${contextPath}/notice/list.do';
	})
  })
</script>
</head>
<body>

  <div>
    <h1>공지 작성하기</h1>
  </div>
  
  <div>
    <form method="post" action="${contextPath}/notice/add.do">
      <div>
        <label for="gubun">구분</label>
        <select name="gubun" id="gubun">
          <option value="1">긴급</option>
          <option value="2" selected="selected">일반</option>
        </select>
      </div>
      <div>
        <label for="title">제목</label>
        <input type="text" name="title" id="title">
      </div>
      <div>
        <label for="content">내용</label>
      </div>
      <div>
        <textarea rows="5" cols="30"  name="content" id="content"></textarea>
      </div>
      
      <hr>
      
      <div>
        <button type="submit">작성완료</button> 
        <button type="button" id="btn_list">목록</button>
      </div>
    </form>
  </div>


</body>
</html>