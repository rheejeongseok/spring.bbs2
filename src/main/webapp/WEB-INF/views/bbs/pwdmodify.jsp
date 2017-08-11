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
        $(document).ready( function(e){
            
            $('#confirm').click( function(e){
                var newPassword = $('input[name="newPassword"]').val();
                var newPasswordC   = $('input[name="newPasswordC"]').val();
                
                if( newPassword === newPasswordC ) {
                    $('form').submit();
                }
                else {
                    return false;
                }
            });
        });
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
                        <span>${user.username }의 비밀번호</span>
                            <form action="./pwdmodify" method="post">
                            
                            <table>
                            <colgroup>
                                <col style="width:200px">
                                <col style="width:400px">
                            </colgroup>
                                <tr>
                                    <td>기존의 비밀번호</td>
                                    <td><input type="password" name="curPassword"/></td>
                                </tr>
                                <tr>
                                    <td>새로운 비밀번호</td>
                                    <td><input type="password" name="newPassword"/></td>
                                </tr>
                                <tr>
                                    <td>새로운 비밀번호 확인</td>
                                    <td><input type="password" name="newPasswordC"/></td>
                                </tr>
                                <tr><td colspan="2"><input type="button" value="확인" id="confirm"/></td></tr>
                            </table>
                            </form>
                    </div>
                  
			</div>
		</div>
		<div class="footer"><%@ include file="guide/footer.jsp" %></div>
	</div>
</body>
</html>