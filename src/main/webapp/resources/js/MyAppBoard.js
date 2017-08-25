/**
 * 
 */

var MyApp = {};


var download = function download(tempfilename,filename) {
	var f = document.createElement('form');
	f.setAttribute('method','post');
	f.setAttribute('action','/download');
	f.setAttribute('enctype','application/x-www-form-urlencoded');
	document.body.appendChild(f);

	var i = document.createElement('input'); //input element, hidden
	i.type = 'text';
	i.name = 'tempfilename';
	i.value = tempfilename;
	f.appendChild(i);
	
	var i = document.createElement('input'); //input element, hidden
	i.type = 'text';
	i.name = 'filename';
	i.value = filename;
	f.appendChild(i);
	
	f.submit();
};
 
var sendPost = function sendPost(url,params) {
	
	var f = document.createElement('form');
	f.setAttribute('method','post');
	f.setAttribute('action',url);
	f.setAttribute('enctype','application/x-www-form-urlencoded');
	document.body.appendChild(f);

	for(var element in params){
		if(typeof params[element] != 'function'){
			
			var i = document.createElement('input');
			i.type = 'text';
			i.name = element;
			i.value = params[element];
			f.appendChild(i);
			
		}
	}
	f.submit();
};


var deleteimgfile = function deleteimgfile(articleno,uploadImageNo) {
	
	var chk = confirm("정말로 삭제하시겠습니까?");
	if (chk==true) {

	    $.ajax({
	        url : '/bbs2/deleteimgfile',
	        data: { 'articleno': articleno,'uploadImageNo':uploadImageNo },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
	        type: 'post',       // get, post
	        timeout: 30000,     // 30초
	        dataType: 'html',   // text, html, xml, json, jsonp, script
	    }).done( function(data, textStatus, xhr ){
	        // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
	        if(data == 1 ){
	            $('#attachfilelist a[attachfileno="'+attachfileno+'"]').parents().remove();
	        }
	        else {
	            alert( '댓글 삭제 실패');
	        }
	    });
	    
	    return false;
	}
};

var commentadd = function commentadd(articleno, text) {

    $.ajax({
        url : '/bbs2/commentadd',
        data: { 'articleno': articleno, 'text': text },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
        type: 'post',       // get, post
        timeout: 30000,     // 30초
        dataType: 'json',   // text, html, xml, json, jsonp, script
    }).done( function(data, textStatus, xhr ){
        // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.    	
    	if(data != null ){
        	
    			$('.comment_view').prepend('<div class="comment_list'+data.num+' commentno='+data.num+'"></div>');
                $('.comment_list'+data.num+'').append('<div class="grouping'+data.num+'"></div>');
                $('.grouping'+data.num+'').append('<div class="comment_writer'+data.num+'">'+data.userid+'</div><div class="comment_date'+data.num+'">'+data.time+'</div><div class="modifyBtns'+data.num+'"></div>');
                $('.modifyBtns'+data.num+'').append('<div class="comment_modify'+data.num+'"><input type="button" class="comment_modify"value="수정"/></div><div class="comment_delete'+data.num+'"><input type="button" value="삭제"/></div>');
                $('.comment_list'+data.num+'').append('<div class="comment_content'+data.num+'"></div>');
                $('.comment_content'+data.num+'').append('<div class="content_text'+data.num+'">'+data.content+'</div>');
                $('.comment_content textarea').val("");
                location.reload();
        }
    	
        else {
            alert( '댓글 삭제 실패');
        }

    });
    
    return false;
}

var commentupdate = function commentupdate(commentno,memo) {
    var textarea = $('div[commentno^="' + commentno + '"]').find('div[class^="content_text"] textarea').val();
    
    $.ajax({
        url : '/bbs2/commentupdate',
        data: { 'commentnoo': commentno, 'memo' : memo },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
        type: 'post',       // get, post
        timeout: 30000,     // 30초
        dataType: 'html',   // text, html, xml, json, jsonp, script
    }).done( function(data, textStatus, xhr ){
        // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
        if(data == 1 || data == 0){
        	var repT = $('div[commentno^="' + commentno + '"]').find('div[class^="content_text"] textarea').val().replace(/\n/g, "<br>");
            $('div[commentno^="' + commentno + '"]').find('div[class^="content_text"]').children('textarea').remove();
            $('div[commentno^="' + commentno + '"]').find('div[class^="content_text"]').html(repT);
        }
        else {
            alert( '댓글 수정 실패');
        }
    });
    
    return false;
}

var commentdelete = function commentdelete(commentno) {
    var chk = confirm("정말로 삭제하시겠습니까?");
    if (chk==true) {

        $.ajax({
            url : '/bbs2/commentdelete',
            data: { 'commentno': commentno },   // 사용하는 경우에는 { data1:'test1', data2:'test2' }
            type: 'post',       // get, post
            timeout: 30000,    // 30초
            dataType: 'json',  // text, html, xml, json, jsonp, script
        }).done( function(data, textStatus, xhr ){
            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            if(data > 0){
                $('div[commentno="' + commentno +'"]').remove();
            }
            else {
                alert( '댓글 삭제 실패');
            }
        });
        
        return false;
    }
}