<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp" />
<script>

	if("${param.error}" == "error"){
		alert("포인트가 부족합니다");
	}
</script>
<body>

	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>닉네임</td>
			<td>작성일</td>
			<td>조회수</td>
			<td>추천수</td>
		</tr>
		<c:choose>
			<%-- IF --%>
			<c:when test="${ not empty boardList.boardList }">
				<c:forEach items="${boardList.boardList}" var="board">
					<tr>
						<td>${board.boardId}</td>
						<td> 
							<a href='<c:url value="/boardDetail/${board.boardId}" />' >${board.subject} 
							<c:if test="${ not empty board.displayFileName }">
							[${board.displayFileName}]
							</c:if>
							</a>	
						</td>
						<td>${board.user.userNickName}</td>
						<td>${board.createdDate }</td>
						<td>${board.hit }</td>
						<td>${board.recommend }</td>
					</tr>				
				</c:forEach>
				
			</c:when>
			<%-- ELSE --%>
			<c:otherwise>
				<tr>
					<td colspan="6">조회된 데이터가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<form id="searchForm">
		${page2}
		<select name="searchType" id="searchType">
			<option value="1" ${boardSearchVO.searchType eq 1 ? "selected" : "" }>제목</option>
			<option value="2" ${boardSearchVO.searchType eq 2 ? "selected" : "" }>작성자</option>
		</select>
		<input type="text" name="searchKeyword" id="searchKeyword" value="${boardSearchVO.searchKeyword}"/>
		<input type="button" id="searchBtn" value="검색" onclick="movePage(0)" />
	</form>
	<c:if test="${not empty sessionScope._USER_}">
		<input type="button" value="글쓰기" onclick="location.href='<c:url value="/write"/>' "/>
	</c:if>
</body>
</html>




