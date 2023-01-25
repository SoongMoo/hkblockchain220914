<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/web3@0.19.0/dist/web3.js"></script>
<script type="text/javascript" src="/static/js/script.js"></script>
</head>
<body>
지갑 : <input type="text" name = "account" id="voteAccount" /><br />
	<table width="640">
		<tr>
			<td align="center">투표</td>
		</tr>
	</table>
	<table width="640">
		<tr>
			<td width="50%" align="left"><a
				href="javascript:setVote_cancel();">내투표 취소</a></td>
			<td width="50%" align="right"><a href="javascript:candidate();">후보자
					추가</a></td>
		</tr>
	</table>
	<table width="640">
	<c:choose>
		<c:when test="${candidates_list.size() eq 0 }">
		<tr>
			<td colspan=5 style="text-align: center">후보자가 없습니다.</td>
		</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${candidates_list }" var="list" varStatus="status">
				<tr>
					<td> ${status.count }</td>
					<td> <span onclick="setRemoveCandidate('${list.idx }')">${list.name }</span></td>
					<td>
					<c:if test="${list.vote <= 0  }" >
						<div class="progress-bar" role="progressbar" 
							style="width:0%; max-width:0%;" 
							aria-valuenow:"0" 
							aria-valuemin="0" 
							aria-valuemax="0">
								<span class="progress-title" style="color:black;">0%</span>
						</div>	
					</c:if>	
					<c:if test="${list.vote > 0  }" >
						<div class="progress-bar" role="progressbar" 
							style="width:${list.vote / candidates_sum_vote * 100}%; 
								   max-width:${list.vote / candidates_sum_vote * 100}%; "
							aria-valuenow:"${list.vote / candidates_sum_vote * 100}" 
							aria-valuemin="0" 
							aria-valuemax="${list.vote / candidates_sum_vote * 100}" >
								<span class="progress-title" style="color:black;">
									<fmt:formatNumber value="${list.vote / candidates_sum_vote * 100}" pattern="0.00" />%
								</span>
						</div>
					</td>
					</c:if>
					<td>${list.vote }</td>
					<td><img src="/static/images/right_arrow.png" onclick="setVote('${list.idx }', '${list.name }');"/></td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>
</body>
</html>