<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<body>

	<form method="post" action="<c:url value="/doLogin" />">
		<label for="userId">ID</label>
		<input type="text" name="userId" id="userId" value="${_USER_ID_}" /> <br/>
		
		<label for="userHashedPassword">Password</label>
		<input type="password" 
				name="userHashedPassword" 
				id="userHashedPassword" /> <br/>
		
		<label for="rememberUserId">아이디 기억하기</label>
		<input type="checkbox" 
				name="rememberUserId" 
				id="rememberUserId" 
				${_REMEMBER_YN_ eq "Y" ? " checked='checked'" : "" }
				value="true" /> <br/>
				
		<input type="submit" value="Login" />
	</form>

</body>
</html>