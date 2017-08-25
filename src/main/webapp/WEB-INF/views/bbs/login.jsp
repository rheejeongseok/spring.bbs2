<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/login.css">
	<script type="text/javascript" src="/resources/bbs2/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/bbs2/js/common.js"></script>
    <script type="text/javascript" src="/resources/bbs2/js/ajaxsetup.js"></script>
    <script type="text/javascript" src="/resources/bbs2/js/MyAppBoard.js"></script>
    <script>
        $(function(){
        	 $('.submitBtn').click(function(){
        		 
        		 var userid = $('input[name="userid"]').val();
        		 var password  = $('input[name="password"]').val();
        		 
        		 $.ajax({
        		        url : '/bbs2/login',
        		        data: { 'userid': userid,'password':password },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
        		        type: 'post',       // get, post
        		        timeout: 30000,    // 30초
        		        dataType: 'html',  // text, html, xml, json, jsonp, script
        		    }).done( function(data, textStatus, xhr ){
        		        // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
        		        if(data == 1){
        		            $('form').submit();
        		            window.location.href = "/bbs2/";
        		        }
        		        else {
        		        	$('.login_alert').show();
        		        	setTimeout(function(){
        		        		$('.login_alert').hide();
        		        	}, 2000);
        		            
        		        }
        		    })
        	 })
        })
    
    </script>
</head>
<body>
	<div class="wrap">
		<div class="header"><%@ include file="guide/header.jsp" %></div>
		<div class="content">
			<div class="section1">
				<img src="/resources/bbs2/img/mainTypo01.png" alt="" class="main_tp">
				<ul>
					<li><a href="javascript:void(0)"><img src="/resources/bbs2/img/c-img03.jpg" alt=""></a></li>
				</ul>
				<div class="slider_line1"></div>
			</div>
			<div class="section2">
                <input type="hidden" name="url" value="${url }"/>
                <div class="loginwrap">
                    <div class="login-form">
                        <span>로그인</span>
                        <form method="post"  action="/bbs2/login" >
                            <input type="text" name="userid" placeholder="회원아이디">
                            <input type="password" name="password" placeholder="비밀번호">
                            <input type="button" name="" value="로그인" class="submitBtn">
                        </form>
                        <ul>
                            <li><a href="/bbs2/join">회원가입</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            
		</div>
		<div class="footer"><%@ include file="guide/footer.jsp" %></div>
	</div>
    <div class="login_alert">
        <div class="alert_title">로그인실패</div>
        <div class="alert_text">아이디, 패스워드 확인 부탁드립니다.</div>
    </div>
</body>
</html>