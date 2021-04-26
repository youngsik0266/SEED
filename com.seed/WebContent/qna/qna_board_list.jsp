<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="qna/style.css">

<a href="./BoardWrite.seed">글쓰기</a>	<br>

<h2>전체글보기</h2> <br>
${listcount}개의 글	<br>

<hr class="line">

<div class="div_subject">
	<ul>
		<li>번호</li>	
		<li>제목</li>	
	</ul>
</div>
<div class="div_summary">
	<ul>
		<li>조회수</li>
		<li>추천수</li>
		<li>반대수</li>
	</ul>
</div>	
<div class="div_writer">
	<ul>
		<li>작성자</li>
		<li>작성일</li>
	</ul>
</div>

<hr class="line">

<c:set var="num" value="${listcount - (page - 1) * 10 }"/>

<ul>
	<li>
		<c:forEach var="b" items="${boardlist}">
			<div class="div_subject">
				<ul>
					<li>${num} <c:set var="num" value="${num-1}"/></li>
					<li>
						<a href="./DetailAction.seed?board_num=${b.board_num}&page=${page}" style="text-decoration:none;">
							${b.board_subject}
						</a>
					</li>
				</ul>
			</div>
			
			<div class="div_summary">
				<ul>
					<li>
						<i class="far fa-eye"> ${b.board_view}</i> 
					</li>
					<li>
						<i class="far fa-thumbs-up"></i> ${b.board_like}
					</li>
					<li>
						<i class="far fa-thumbs-down"></i> ${b.board_hate}
					</li>
				</ul>
			</div>
			
			<div class="div_writer">
				<ul>
					<li>${b.name}</li>
					<li>
						<fmt:formatDate value="${b.board_register}" pattern="yyyy-MM-dd HH:mm:ss"/>	
					</li>				
				</ul>
			</div>
			<div></div>
		</c:forEach>
	</li>
</ul>

<hr class="line">


<div>
	<c:if test="${listcount > 0 }">
	
		<a href="./ListAction.seed?page=1" style="text-decoration:none;"> << </a>	
	
		<c:if test="${startPage > 10}">
			<a href="./ListAction.seed?page=${startPage-10}">[이전]</a>
		</c:if>
	
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i == page}">
				[${i}]
			</c:if>
			<c:if test="${i != page}">
				<a href="./ListAction.seed?page=${i}">[${i}]</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage < pageCount}">
			<a href="./ListAction.seed?page=${startPage+10}">[다음]</a>
		</c:if>
		
		<a href="./ListAction.seed?page=${pageCount}" style="text-decoration:none;"> >> </a>
	</c:if>
</div>

<hr>

WeeklyBest

<hr>

<div class="div_subject">제목</div>
<div class="div_summary">
	<ul>
		<li>조회수</li>
		<li>추천수</li>
		<li>반대수</li>
	</ul>
</div>	
<div class="div_writer">
	<ul>
		<li>작성자</li>
		<li>작성일</li>
	</ul>
</div>

<hr class="line">

<ul>
	<li>
		<c:forEach var="w" items="${weeklybest}">
			<div class="div_subject">
				<a href="./DetailAction.seed?board_num=${w.board_num}&page=${page}" style="text-decoration:none;">
					${w.board_subject}
				</a>
			</div>
			<div class="div_summary">
				<ul>
					<li>
						<i class="far fa-eye"> ${w.board_view}</i> 
					</li>
					<li>
						<i class="far fa-thumbs-up"></i> ${w.board_like}
					</li>
					<li>
						<i class="far fa-thumbs-down"></i> ${w.board_hate}
					</li>
				</ul>
			</div>	
			<div class="div_writer">
				<ul>
					<li>${w.name}</li>
					<li>
						<fmt:formatDate value="${w.board_register}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</li>
				</ul>
			</div>
			<div></div>
		</c:forEach>
	</li>
</ul>