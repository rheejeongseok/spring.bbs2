<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Community</title>
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/bbswrite.css">
	<script type="text/javascript" src="/resources/bbs2/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/bbs2/js/common.js"></script>
        <script type="text/javascript" src="/resources/bbs2/js/ajaxsetup.js"></script>
    <script type="text/javascript" src="/resources/bbs2/js/MyAppBoard.js"></script>
    <script>
     $(function(){
    	 $('.modify_btn').click(function(){
    		 $('form').submit();
    		 /* window.location.href = "/communitymodify/${boardcd}/${articleno}"; */
    		 
    	 })
    	 
    	 $('.delete_file').click(function(){
    		 
    		 var articleno = $(this).parent().attr("articleno");
    		 var uploadImageNo = $(this).parent().attr("uploadImageNo");
    		 
    		 return deleteimgfile(articleno,uploadImageNo);
    		 
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
					<li><a href="javascript:void(0)"><img src="/resources/bbs2/img/01_01.jpg" alt=""></a></li>
				</ul>
				<div class="slider_line1"></div>
			</div>
			<div class="section2">
                <div class="subtitle">
                    <span class="text1">전주한옥숙박체험관</span><br>
                    <h2>COMMUNITY</h2>
                </div>
                <div class="line"></div>
                <div class="bbs_title">${boardnm }</div>
                <div class="section2_bbs">
                    <div class="bbs_wrap">
                    <form action="/bbs2/communitymodify/${boardcd}/${articleno}?curPage=${curPage}&searchWord=${searchWord}" method="post" enctype="multipart/form-data">
                        <p style="margin: 0; padding: 0;">
                            <input type="hidden" name="boardcd" value="${boardcd }" />
                        </p>
                        <table>
                        <colgroup>
                            <col style="width:20%">
                            <col>
                        </colgroup>
                        <tr>
                            <td>작성자</td>
                            <td><span name="userid">${community.userid }</span></td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td><input type="text" name="title" value="${community.title }" class="form-control" maxlength="50" style="width:90%; background-color:#f5f5f5; margin:9px auto; height:40px; border:none; margin:5px auto; padding-left:20px;"></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea  name="content" class="form-control" maxlength="5000" style="width:90%; background-color:#f5f5f5; margin:9px auto; height:100px; border:none; margin:5px auto; padding-left:20px;">${community.content }</textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                            <c:if test="${upimg != null or upimg != ''}">
                            <div class="imgfiles">
                                <c:forEach var="list" items="${upimg }" varStatus="status">
                                    <div class="filename" articleno="${list.articleno }" uploadImageNo="${list.uploadImageNo }">${list.fileName } <input type="button" class="delete_file" value="삭제"/></div>
                                </c:forEach>
                            </div>
                            </c:if>
                            <input type="button" class="modify_btn ok_modify" value="수정하기"></td>
                        </tr>
                        </table>
                    </form>
                    </div>
                </div>
            </div>
		</div>
		<div class="footer"><%@ include file="guide/footer.jsp" %></div>
	</div>
</body>
</html>