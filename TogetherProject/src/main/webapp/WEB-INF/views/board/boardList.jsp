<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/together/resources/css/common/font.css">
<link rel="stylesheet" href="/together/resources/css/member/loginForm.css">
<link rel="stylesheet" href="/together/resources/css/common/main.css">
<title>boardList</title>
</head>
<body>

<div class="contentWrap">
	<div class="headerMain-div">
		<a href="${pageContext.request.contextPath}"><img src="/together/resources/images/logo.png" class="logoImage"></a>
	</div>
	<section id="content">

		<%-- <c:import url="/home/inc/notificationField.do">
			<c:param name="whatMenu" value="notice" />
		</c:import> --%>

		<div class="searchCondition">
			<select name="searchCondition" id="searchCondition" title="검색방법">
				<option value="title" <c:if test="${ MainBoard.searchCondition eq 'title' }">selected="selected"</c:if>><c:out value="제목"/></option>
			</select>
			<input type="text" name="searchKeyword" id="searchKeyword" title="검색어" value="${MainBoard.searchKeyword}" placeholder="검색어 입력">
			<button id="searchBtn" class="btn pri btnSearch">검색</button>
		</div>

		<table class="table tableC">
			<caption class="hidden locD2">공지사항</caption>
			<thead>
				<tr>
					<th scope="col" class="no">번호</th>
					<th scope="col" class="title">제목</th>
					<th scope="col" class="writeNm">작성자</th>
					<th scope="col" class="fileYn">파일</th>
					<th scope="col" class="regDate">등록일</th>
					<th scope="col" class="readCnt">조회수</th>
				</tr>
			</thead>
			<tbody>				
				<c:choose>
					<c:when test="${ totalCnt > 0 }">
						<c:forEach var="resultList" items="${resultList}" varStatus="status">								
									<c:choose>										
										<c:when test="${resultList.noticeYn eq 'Y' }">
											<tr class="noticeTr">
												<td class="no">
												<strong class="badgeNotice">공지</strong>
										</c:when>
										<c:otherwise>
											<tr>
												<td class="no">
												${MainBoard.seqNo - status.index}
										</c:otherwise>										
									</c:choose>
								</td>
								<td class="title">
									<a href="#link${resultList.idx }" onclick="dataView('${resultList.idx }');">${resultList.title}</a>
								</td>
								<td class="writeNm">
									${resultList.writeNm}
								</td>
								<td class="fileYn">
									<c:if test="${masterView.fileYn eq 'Y'}">
										<c:if test="${resultList.fileCnt > 0}"><span class="iconFile">첨부있음</span></c:if>
									</c:if>
								</td>
								<td class="regDt">
									<fmt:formatDate value="${resultList.regDt }" pattern="yyyy.MM.dd" />
								</td>
								<td class="readCnt">
									<fmt:formatNumber value="${resultList.readCnt }" type="number" />
								</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
				<c:if test="${empty resultList}">
					<tr class="emptyNote"><td colspan="7" class="textC"> 게시물이 없습니다.</td></tr>
				</c:if>
			</tbody>
		</table>

		<div class="pageNav">
			<c:if test="${ totalCnt > 0 }">
				<div class="paging">
					<%-- <ui:pagination paginationInfo="${MainBoard}" /> --%>
				</div>
			</c:if>
		</div>

	</section>
</div>
<script>
	
</script>
</body>
</html>