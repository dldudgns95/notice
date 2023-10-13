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
    $('#btn_edit').click(function(){
  	  $('#frm_hidden').attr('action', '${contextPath}/notice/edit.do');
  	  $('#frm_hidden').submit();
    })
    $('#btn_delete').click(function(){
      if(confirm('공지를 삭제하시겠습니까?')){
    	  $('#frm_hidden').attr('action', '${contextPath}/notice/delete.do');
    	  $('#frm_hidden').submit();
      }
    })
    $('#btn_list').click(function(){
      location.href='${contextPath}/notice/list.do';
    })
    
    var updateResult = '${updateResult}';
	if(updateResult !== ''){
	  if(updateResult === '1'){
		alert('공지사항이 수정되었습니다.');
	  } else{
		alert('공지사항 수정을 실패했습니다.');
	  }
	}
    
    
  })
</script>
</head>
<body>

  <div>
    <h1>${noticeDto.notice_no}번 공지사항</h1>
  </div>
  <div>
    구분 : 
    <c:if test="${noticeDto.gubun eq '1'}">긴급</c:if>
    <c:if test="${noticeDto.gubun eq '2'}">일반</c:if>
  </div>
  <div>
    제목 : ${noticeDto.title} 
  </div>
  <div>
    ${noticeDto.content}
  </div>
  
  <form method="post" id="frm_hidden">
    <input type="hidden" name="notice_no" value="${noticeDto.notice_no}">
  </form>
  
  <hr>
  
  <div>
    <button type="button" id="btn_edit">편집</button>
    <button type="button" id="btn_delete">삭제</button>
    <button type="button" id="btn_list">목록</button>
  </div>

</body>
</html>