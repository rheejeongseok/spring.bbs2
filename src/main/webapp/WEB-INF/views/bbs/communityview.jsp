<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    		 window.location.href = "/bbs2/communitymodify/${boardcd}/${articleno}?curPage=${curPage}&searchWord=${searchWord}";
    		 
    	 })
    	 
    	 $('.list_btn').click(function(){
    		 window.location.href= "/bbs2/community/${boardcd}?curPage=${curPage}";
    	 })
    	 
    	 $('.dele_btn').click(function(){
    		 
    		 var chk = confirm("삭제?");
             if(chk == true){
                 
                 var boardcd = $(this).attr("boardcd");
                 var articleno = $(this).attr("articleno");
                 var curPage = $(this).attr("curpage");
                 
                 sendPost("/bbs2/communitydelete/${boardcd}/${articleno}",{"boardcd":boardcd, "articleno":articleno,"curPage":curPage});
             }
             })
             
             
         $("body").on('click','.submit_Btn',function(){
             console.log("AAAAA");
             $('.form-control').attr("name","memo")
             var text = $(this).prev('textarea').val().replace(/\n/g, "<br>");
             var articleno = $(this).attr('articleno');
             console.log("text"+text);
             console.log("articleno"+articleno);
             
             return commentadd(articleno,text);
         })
         
         
        $("body").on('click','.comment_modify',function(){
        	
        	 if($(this).is('.modifyon')){
        		
        		$(this).removeClass('modifyon');
        		var commentno = $(this).parents('div[class^="comment_list"]').attr('commentno');
                var memo = $(this).parents('div[class^="comment_list"]').find('div[class^="content_text"] textarea').val().replace(/\n/g, "<br>");
                console.log(commentno);
                console.log(memo);
                
                return commentupdate(commentno,memo);
                
        		
        	}
        	 else if(!$(this).is('.modifyon')){
        		   
        		$(this).addClass('modifyon');	
        		var content_val = $(this).parents('div[class^="comment_list"]').find('div[class^="content_text"]').html();
        		var repContent = content_val.replace(/<br>/g,"\n");
                console.log(content_val);
                $('.form-control').attr("name","memo2")
                $(this).parents('div[class^="comment_list"]').find('div[class^="content_text"]').text("");
                $(this).parents('div[class^="comment_list"]').find('div[class^="content_text"]').append('<textarea name="memo">'+repContent+'</textarea>')
                
                return false;
        	}
       	
        }) 
        
        $("body").on('click','.comment_delete',function(){
       
             var commentno = $(this).parents('div[class^="comment_list"]').attr('commentno');
             return commentdelete(commentno);
         })
         
         $('body').on('click','.back_login',function(){
        	 
        	 alert('로그인이 필요합니다.');
        	 window.location.href="/bbs2/login";
        	 
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
                    <form action="/bbswrite/{boardcd}" method="post">
                        <p style="margin: 0; padding: 0;">
                            <input type="hidden" name="boardcd" value="${boardcd }" />
                        </p>
                        <table>
                        <colgroup>
                            <col style="width:300px">
                            <col style="width:700px">
                        </colgroup>
                        <tr>
                            <td class="view_cs">작성자</td>
                            <td><span name="userid">${community.userid }</span></td>
                        </tr>
                        <tr>
                            <td class="view_cs">제목</td>
                            <td>${community.title }</td>
                        </tr>
                        <tr>
                            <td class="view_cs">내용</td>
                            <c:choose>
                            <c:when test="${imagelist != '' or imagelist != null }">
                            <td class="view_content" style="word-break:break-all; text-align:left; padding:40px 10px">
                            <c:forEach var="list" items="${imagelist }" varStatus="status">
                            <div class="imgbox"><img src="data:${list.contentType };base64,${list.imageBase64}" alt="" /></div><br />
                            </c:forEach>
                            ${community.content }</td>
                            </c:when>
                            <c:otherwise>
                            <td class="view_content" style="word-break:break-all; text-align:left; padding:40px 10px">${community.content }</td>
                            </c:otherwise>
                            </c:choose>
                        </tr>
                        <tr>
                            <c:choose>
                                <c:when test="${user.userid == community.userid and boardcd != 'notice'}">
                                    <td colspan="2">
                                        <input type="button" class="list_btn" value="목록">
                                        <input type="button" class="modify_btn" value="수정">
                                        <input type="button" class="dele_btn" value="삭제" articleno="${community.articleno }" boardcd="${community.boardcd }" curpage="${curPage }">
                                    </td>
                                </c:when>
                                <c:when test="${user.userid == 'rhee' and boardcd == 'notice'}">
                                    <td colspan="2">
                                        <input type="button" class="list_btn" value="목록">
                                        <input type="button" class="modify_btn" value="수정">
                                        <input type="button" class="dele_btn" value="삭제" articleno="${community.articleno }" boardcd="${community.boardcd }" curpage="${curPage }">
                                    </td>
                                </c:when>
                                <c:when test="${boardcd == 'free' and user.userid != community.userid}">
                                    <td colspan="2">
                                       <input type="button" class="list_btn" value="목록">
                                    </td>
                                </c:when>
                            </c:choose>
                        </tr>
                        </table>
                    </form>
                    <c:if test="${boardcd != 'notice' }">
                        <div class="commentwrap">
                            <c:choose>
                                <c:when test="${user != null }">
                                    <div class="comment_write">
                                        <div class="grouping">
                                            <div class="comment_writer" style="text-decoration:underline">${user.userid }</div>
                                            <div class="comment_date">${time }</div>
                                        </div>
                                        <div class="comment_content">
                                            <textarea  name="memo" placeholder="내용을 입력해주세요." class="form-control" maxlength="5000" style="width:80%; vertical-align:top; padding-top:10px; background-color:#f5f5f5; margin:9px auto; height:100px; border:none; margin:5px auto; padding-left:20px;"></textarea>
                                            <input type="button" class="submit_Btn" value="댓글쓰기" articleno="${community.articleno }"/>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="comment_write">
                                        <div class="grouping">
                                            <div class="write_writer">${user.userid }</div>
                                        </div>
                                        <div class="write_content back_login">
                                            <textarea  name="memo" placeholder="로그인 해주세요." class="form-control" maxlength="5000" style="width:90%; vertical-align:top; padding-top:10px; background-color:#f5f5f5; margin:9px auto; height:100px; border:none; margin:5px auto; padding-left:20px;"></textarea>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <div class="comment_view">
                                <c:forEach var="item" items="${comment }" >
                                    <div class="comment_list" commentno="${item.commentno }">
                                        <div class="grouping">
                                            <div class="comment_writer">${item.userid }</div>
                                            <div class="comment_date"><fmt:formatDate pattern="yyyy-MM-dd" value="${item.regdate }" /></div>
                                            <c:choose>
                                                <c:when test="${user.userid == item.userid }">
                                                <div class="modifyBtns">
                                                    <div class="comment_modify"><input type="button" value="수정"/></div>
                                                    <div class="comment_delete"><input type="button" value="삭제" /></div>
                                                 </div>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                        <div class="comment_content">
                                            <div class="content_text">${item.memo }</div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:if>
                    </div>
                </div>
            </div>
		</div>
		<div class="footer"><%@ include file="guide/footer.jsp" %></div>
	</div>
</body>
</html>
