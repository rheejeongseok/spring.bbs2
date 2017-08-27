<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Community</title>
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/bbs2/css/bbswrite.css">
	<script type="text/javascript" src="/resources/bbs2/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/resources/bbs2/js/common.js"></script>
    <script>
     $(function(){
    	 $('.write_btn').click(function(){
    		 console.log("변경전"+$('.text_area').val())
    		 var text = $('.text_area').val().replace(/\n/g, "<br>")
    		 $('.text_area').val(text);
    		 console.log(text);
             $('form').submit();
    		 /* window.location.href = "/community/free?curPage=${curPage}&searchWord=${searchWord}"; */
    		 
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
                    <span class="text1">전주한옥숙박체험관 </span><br>
                    <h2>COMMUNITY</h2>
                </div>
                <div class="line"></div>
                <div class="bbs_title">${boardnm }</div>
                <div class="section2_bbs">
                    <div class="bbs_wrap">
                    <form action="/bbs2/bbswrite/${boardcd}" method="post" enctype="multipart/form-data">
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
                            <td><span name="userid">${user.userid }</span></td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td><input type="text" name="title" class="form-control" maxlength="50" style="width:90%; background-color:#f5f5f5; margin:9px auto; height:40px; border:none; margin:5px auto; padding-left:20px;"></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea  name="content" class="form-control text_area" maxlength="5000" style="width:90%; background-color:#f5f5f5; margin:9px auto; height:100px; border:none; margin:5px auto; padding-left:20px;"></textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="text" name="upDir" value="c:/upload/" /><input type="file" name="image"/><input type="button" class="write_btn" value="글쓰기"></td>
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