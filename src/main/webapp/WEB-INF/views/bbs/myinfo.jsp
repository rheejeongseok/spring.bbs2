<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>join</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/join.css">
	<script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/js/common.js"></script>
    <script type="text/javascript" src="/resources/js/join.js"></script>
   <script>
   $(function(){
	   $('.popuserdelete').click(function(){
		   $('body').append('<div class="blind"></div>')
           $('.userdel').show();
	   })
	   
	   $('.userdelete').click(function(){
		   
		   var userid = $('.getuid').attr('userid');
		   var password = $('.del_box input').val();
		   
		   $.ajax({
               url : '/userdelete',
               data: { 'userid': userid,'password':password },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
               type: 'post',       // get, post
               timeout: 30000,    // 30초
               dataType: 'html',  // text, html, xml, json, jsonp, script
           }).done( function(data, textStatus, xhr ){
               // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
               if(data == 1){
            	   
                   window.location.href = "/byebye";
                   
               }
               else if(data == 0){
                  
                  $('.del_text').text("비밀번호를 다시 확인해주세요.");
                  $('.del_box input').val("");
            	   
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
				<img src="/resources/img/mainTypo01.png" alt="" class="main_tp">
				<ul>
					<li><a href="javascript:void(0)"><img src="/resources/img/about01_bg.jpg" alt=""></a></li>
				</ul>
				<div class="slider_line1"></div>
			</div>
			<div class="section2">
                <div class="login-form">
                        <span>${user.username }님의 입력사항</span>
                            <table>
                            <colgroup>
                                <col style="width:200px">
                                <col>
                            </colgroup>
                                <tr>
                                    <td class="info_title">이름</td>
                                    <td>${user.username }</td>
                                </tr>
                                <tr>
                                    <td class="info_title getuid" userid="${user.userid }">아이디</td>
                                    <td>${user.userid }</td>
                                </tr>
                                <tr>
                                    <td class="info_title">주소</td>
                                    <td><div style="color:#9a9898">우편번호 : ${user.postcode }</div>
                                    <ul>
                                    	<li>도로명 주소 : ${user.roadAddress }</li>
                                    	<li>지번주소 : ${user.jibunAddress }</li>
                                    </ul>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="info_title">이메일</td>
                                    <td>${user.email }</td>
                                </tr>
                                <tr>
                                    <td class="info_title">전화번호</td>
                                    <td>${user.phone }</td>
                                </tr>
                                <tr><td colspan="2" class="modifyBtns" ><a href="/usermodify" class="usermodify">정보수정</a><a href="/pwdmodify" class="userpwdchange">비밀번호 변경</a><a href="javascript:void(0)" class="popuserdelete">회원탈퇴</a></td></tr>
                            </table>
                    </div>
                  
			</div>
		</div>
		<div class="footer"><%@ include file="guide/footer.jsp" %></div>
    </div>
    
    <div class="userdel">
        <form action="" method="post">
            <div class="del_title">정말로 탈퇴하시는 겁니까...</div>
            <div class="del_text">탈퇴를 위해 한번더 입력 해주세요.</div>
            <div class="del_box">
                <input type="password" placeholder="비밀번호를 입력해주세요."/>
            </div>
            <div class="userdelete">회원탈퇴</div>
        </form>
    </div>
</body>
</html>