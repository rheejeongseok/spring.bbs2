<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Community</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/community.css">
	<script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/js/common.js"></script>
    <script>
    function goView(articleno) {
        window.location.href = "/communityview/${boardcd}/"+articleno+"?curPage=${curPage}&searchWord=${searchWord}"
    }
    $(function(){
    	
    	$('#paging>span[class!="bbs-strong"]').click(function(){
            var page = $(this).attr('articleno');
            console.log(page);
            window.location.href = "/community/${boardcd}?curPage="+page+"&searchWord=${searchWord}"
        })
        
        $('.write_not').click(function(){
        	alert("로그인을 해야합니다.");
        	window.location.href = "/login";
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
					<li><a href="javascript:void(0)"><img src="/resources/img/c-img03.jpg" alt=""></a></li>
				</ul>
				<div class="slider_line1"></div>
			</div>
			<div class="section2">
                <div class="subtitle">
                    <span class="text1">전주한옥숙박체험관 </span><br>
                    <h2>COMMUNITY</h2>
                </div>
                <div class="line"></div>
                <div class="bbs_title">${boardnm }</div>
                <div class="section2_bbs">
                    <div class="bbs_wrap">
                        <table>
                        <colgroup>
                            <col style="width:10%">
                            <col style="width:35%">
                            <col style="width:20%">
                            <col style="width:20%">
                            <col style="width:10%">
                        </colgroup>
                            
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>조회</th>
                            </tr>
                            <c:forEach var="bbs" items="${list }" varStatus="status">
                                <tr>
                                    <td>${bbs.articleno}</td>
                                    <td>
                                        <a href="javascript:goView('${bbs.articleno }')">${bbs.title }</a>
                                    </td>
                                    <td>${bbs.userid }</td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${bbs.regdate }" /></td>
                                    <td>${bbs.hit }</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <c:choose>
                                    <c:when test="${not empty user and boardcd == 'free' }">
                                        <td colspan="5"><a href="/bbswrite/free" class="write_btn">글쓰기</a></td>
                                    </c:when>
                                    <c:when test="${user.userid == 'rhee' and boardcd == 'notice' }">
                                        <td colspan="5"><a href="/bbswrite/free" class="write_btn">글쓰기</a></td>
                                    </c:when>
                                   <%--  <c:when test="${empty user}">
                                        <td colspan="5"><a href="javascript:void(0)" class="write_btn write_not">글쓰기</a></td>
                                    </c:when> --%>
                                </c:choose>
                            </tr>
                        </table>
                        <div id="paging" style="text-align: center;">
    
                            <c:if test="${prevLink > 0 }">
                                <span articleno="${prevLink }" class="list_prev list_btn"></span>
                            </c:if>
                        
                            <c:forEach var="i" items="${pageLinks }" varStatus="stat">
                                <c:choose>
                                <c:when test="${curPage == i}">
                                    <span class="bbs-strong">${i }</span>
                                </c:when>
                                <c:otherwise>
                                    <span articleno="${i }">${i }</span>
                                </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            
                            <c:if test="${nextLink > 0 }">
                                <span articleno="${nextLink }" class="list_next list_btn"></span>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
		</div>
		<div class="footer"><%@ include file="guide/footer.jsp" %></div>
	</div>
</body>
</html>