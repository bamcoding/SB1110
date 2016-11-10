<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<body>
	<form enctype="multipart/form-data" id="writeForm" method="post" action="<c:url value="/doWrite"/>">
		<label for="subject">제목</label>
		<input type="text" id="subject" name="subject" />
		<label for ="content">내용</label>
		<textarea id="content" name="content" ></textarea> 
		
		<input type="file" name="fileUpload" />
		<input type="submit" value="글쓰기" />
	</form>
</body>
</html>