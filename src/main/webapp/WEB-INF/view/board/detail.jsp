<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<script type="text/javascript">
	function onClick() {
		if(${sessionScope._USER_.point}>=3){		
			<c:choose>
				<c:when test="${sessionScope._USER_.userId eq board.userId}">
					location.href="<c:url value="/viewFile/${board.boardId}" />";
				</c:when>
				<c:otherwise>
					if(confirm("다운로드를 하면 3포인트가 차감 됩니다. 다운로드 하시겠습니까?")){
						location.href="<c:url value="/viewFile/${board.boardId}" />";
					}
				</c:otherwise>
			</c:choose>
		}
	}
	
	$(document).ready(function(){
		$("#replyBtn").click(function(){
			$.post( "<c:url value="/addReply/${board.boardId }"/>", $("#replyForm").serialize(), function(data){
				console.log(data);
			});
		});
	});
		
	
</script>
<body>
	<table>
		<tr>
			<td colspan="4">제목 : ${board.subject}</td>
		</tr>
		<tr>
			<td>글쓴이: ${board.user.userNickName}</td>
			<td>작성 날짜: ${board.createdDate }</td>
			<td>조회수: ${board.hit }</td>
			<td>추천수: ${board.recommend }</td>
			<c:if test="${not empty board.displayFileName}">
			<td>파일:<a href="javascript:void(0);" onclick="onClick()">${board.displayFileName}</a></td>
			</c:if>
		</tr>
		<tr>
			<td colspan="4">내용: ${board.content }</td>
		</tr>
	</table>
	<c:if test="${sessionScope._USER_.userId eq board.userId}">
		<input type="button" value="삭제하기" onclick="location.href='<c:url value="/delete/${board.boardId}" />'"/>
	</c:if>
	
	<form id="replyForm" name="replyForm" method="post">
		<input type="hidden" id="parentReplyId" name="parentReplyId" value="0" />
		<input type="hidden" id="userId" name="userId" value="${sessionScope._USER_.userId }" readonly="readonly"/>
		<label for="reply">내용</label> 
		<textarea rows="3" cols="10" id="reply" name="reply"></textarea>
	
		<input type="button" id="replyBtn" na  value="등록">
	</form>
</body>
</html>