<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<body>

	<form method="post" action="<c:url value="/doSignUp" />">
		<label for="userId">아이디</label>
		<input type="text" name="userId" id="userId" /> <br/>
		
		<label for="userHashedPassword">비밀번호</label>
		<input type="password" name="userHashedPassword" id="userHashedPassword" /> <br/>
		
		<label for="userNickName">닉네임</label>
		<input type="text" name="userNickName" id="userNickName" /> <br/>
		
		<input type="submit" value="가입" />
		<input type="reset" value="다시 작성" />
	</form>

</body>
</html>