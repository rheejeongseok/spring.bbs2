<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>join</title>
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/join.css">
	<script type="text/javascript" src="/resources/bbs2/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/bbs2/js/common.js"></script>
    <script type="text/javascript" src="/resources/bbs2/js/join.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function Postcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('roadAddress').value = fullRoadAddr;
                document.getElementById('jibunAddress').value = data.jibunAddress;
    
            }
        }).open();
    }
</script>
</head>
<body>
	<div class="wrap">
		<div class="header"><%@ include file="guide/header.jsp" %></div>
		<div class="content">
			<div class="section1">
				<img src="/resources/bbs2/img/mainTypo01.png" alt="" class="main_tp">
				<ul>
					<li><a href="javascript:void(0)"><img src="/resources/bbs2/img/about01_bg.jpg" alt=""></a></li>
				</ul>
				<div class="slider_line1"></div>
			</div>
			<div class="section2">
            
                <div class="login-form">
                        <span>회원정보 수정</span>
                        <form method="post"  action="/bbs2/usermodify" enctype="application/x-www-form-urlencoded">
                            <table>
                            <colgroup>
                                <col style="width:200px">
                                <col style="width:400px">
                            </colgroup>
                                <tr>
                                    <td>이름</td>
                                    <td><input type="text"  name="username" value="${user.username }"></td>
                                </tr>
                                <tr>
                                    <td>주소</td>
                                    <td>
                                        <input type="text" id="postcode" name="postcode" value="${user.postcode }">
                                        <input type="button" onclick="Postcode()" value="우편번호 찾기" id="findaddr">
                                        <input type="text" id="roadAddress" name="roadAddress" class="addrtext"  value="${user.roadAddress }">
                                        <input type="text" id="jibunAddress" name="jibunAddress" class="addrtext" value="${user.jibunAddress }">
                                    </td>
                                </tr>
                                <tr>
                                    <td>이메일</td>
                                    <td><input type="text" name="email" value="${user.email }"></td>
                                </tr>
                                <tr>
                                    <td>전화번호</td>
                                    <td><input type="text" name="phone" value="${user.phone }"></td>
                                </tr>
                                <tr><td colspan="2"><input type="submit" name="" value="완료"><input type="reset" value="다시쓰기"></td></tr>
                            </table>
                        </form>
                    </div>  
              </div>
		</div>
		<div class="footer"><%@ include file="guide/footer.jsp" %></div>
	</div>
</body>
</html>