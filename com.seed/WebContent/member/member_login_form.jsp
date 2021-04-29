<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	
	<!-- 외부 자바스크립트 파일 불러오기 -->
	<script src="<%=request.getContextPath() %>/qna/login.js"></script>
	
	</head>
	<body>
		<form method="post" action="<%=request.getContextPath() %>/LoginAction.seed">
			<div class="">
				<div>
					<h2>Log In</h2>
				</div>
				<div>
					E-mail <br>
					<input type=text size=30 id="id" name="id" autofocus="autofocus">	
				</div>
				<div>
					Password <br>
					<input type="password" size=30 id="pw" name="pw">
				</div>
				<div>
					<input type="button" value="회원가입" onClick="location.href='<%=request.getContextPath()%>/MemberFormAction.seed'">
					<input type="submit" value="Login">
					<input type="reset" value="Cancel" onClick="history.go(-1);">
				</div>
			</div>
		</form>
	</body>
	</html> --%>
	
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
    <meta name="viewport" content="user-scalable=no, initial-scale=1, maxium-scale=1">
    <title>LogIn</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/member.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>    
    <script src="<%=request.getContextPath() %>/qna/login.js"></script>
    <script 
    src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous">
    </script>
</head>
<body>
    <div class="container-main">
       <!--  <header class="header-main">
            <div class="header-icon header-content">
                <div class="icon-content icon-img">
                    <i class="fas fa-seedling"></i>
                </div>
                <div class="icon-content seed">SEED</div>
            </div>
            <div class="header-main-nav header-content">
                <div class="nav-list">
                    <div class="nav-list-content">
                        <a href="">Home</a>
                    </div>
                    <div class="nav-list-content">
                        <a href="">Share</a>
                    </div>
                    <div class="nav-list-content nav-list-community">
                        <a href="" class="community-sub">Community</a>
                        <div class="nav-list-content-detail">
                            <a href="">Tip</a>
                            <a href="">News</a>
                            <a href="">Free</a>
                            <a href="">Q&A</a>
                            <a href="">Live</a>
                        </div>
                    </div>
                    <div class="nav-list-content">
                        <a href="">About</a>
                    </div>
                </div>
            </div>
            <div class="header-main-member header-content">
                <div class="header-main-member-content header_search">
                    <i class="fas fa-search" id="search_btn"></i>
                </div>
                <div class="header-main-member-content search_box">
                    <input type="text" value="search">
                    <input type="button" value="검색">
                </div>
                <div class="header-main-member-content header-member-content">Log In</div>
            </div>
        </header> -->
        <%@ include file="/main/main-header.jsp" %>
        <section class="member-section">
            <form method="POST" action="<%=request.getContextPath() %>/LoginAction.seed">
                <div class="member-container">
                    <div class="member-content">
                        <div class="member_subject">
                            Log In
                        </div>
                        <div class="login-content-container">
                            <div class="login_input">
                                <div class="login_input-content login-content_subject">
                                    <span>E-mail</span>
                                    <input type="text" class="content_input" id="id" name="id" value="이메일을 입력하세요" >
                                </div>
                                <div class="login_input-content login-content_subject">
                                    <span>Password</span>
                                    <input type="password" class="content_input" id="pw" name="pw">
                                </div>
                                <div class="login_input-content login_check">
                                    <input type="submit" class="check_btn"id="login_btn" value="Login">
                                    <input type="reset" class="check_btn" id="login_cancel" value="Cancel" onClick="history.go(-1);">
                                </div>
                            </div>
                            <div class="login_join">
                                <div class="login_join-content login-content_subject">
                                    <a href="<%=request.getContextPath()%>/MemberFormAction.seed" class="signup_a"><span>회원가입</span></a>
                                    <a href="" class="signup_a"><span>아이디 패스워드 찾기</span></a>
                                    
                                </div>
                                <div class="login-content_subject">
                                    <span>다른 사이트 로그인</span>
                                    <div class="otherlogin_icon">
                                        <a href=""><i class="fab fa-google otherlogin_svg"></i></a>
                                        <a href=""><i class="fab fa-facebook otherlogin_svg"></i></a>
                                        <a href=""><i class="fab fa-github otherlogin_svg"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </section>
    </div>
</body>
</html>