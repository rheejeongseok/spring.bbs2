package com.spring.BBS2.controller;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.BBS2.common.PagingHelper;
import com.spring.BBS2.common.WebConstants;
import com.spring.BBS2.model.ModelArticle;
import com.spring.BBS2.model.ModelComments;
import com.spring.BBS2.model.ModelUploadImage;
import com.spring.BBS2.model.ModelUser;
import com.spring.BBS2.service.IServiceBoard;
import com.spring.BBS2.service.IServiceUpload;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/bbs2")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IServiceBoard svrboard;
	
	@Autowired
	private IServiceUpload svrupload;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/community/{boardcd}", method = RequestMethod.GET)
    public String community(Locale locale, Model model
            , @PathVariable(value="boardcd") String boardcd
            , @RequestParam(value="curPage"   , defaultValue="1") int    curPage
            , @RequestParam(value="searchWord", defaultValue="" ) String searchWord) {
        logger.info("community", locale);
      
        model.addAttribute("curPage"   , curPage   );
        model.addAttribute("searchWord", searchWord);
        
        String boardnm          = svrboard.getBoardName(boardcd);        
        model.addAttribute("boardnm"   , boardnm   );
        model.addAttribute("boardcd"   , boardcd   );
        model.addAttribute("curPage"   , curPage   );
        model.addAttribute("searchWord", searchWord);
        
     // 전체 게시글 갯수 가져오기
        int totalRecord = svrboard.getArticleTotalRecord(boardcd, searchWord);
        
        // 페이지 처리
        PagingHelper paging = new PagingHelper(totalRecord, curPage);        
        int start = paging.getStartRecord();
        int end   = paging.getEndRecord();
        
        List<ModelArticle> list = svrboard.getArticleList(boardcd, searchWord, start, end);
        model.addAttribute("list"      , list      );
        model.addAttribute("no"        , paging.getListNo   () );
        model.addAttribute("prevLink"  , paging.getPrevLink () );
        model.addAttribute("firstPage" , paging.getFirstPage() );
        model.addAttribute("pageLinks" , paging.getPageLinks() );
        model.addAttribute("lastPage"  , paging.getLastPage () );
        model.addAttribute("nextLink"  , paging.getNextLink () );
        
        
        return "bbs/community";
        
        
    }
	
	@RequestMapping(value = "/bbswrite/{boardcd}", method = RequestMethod.GET)
    public String bbswrite(Locale locale, Model model
            ,@PathVariable(value="boardcd") String boardcd
            ,@RequestParam(value="curPage"   , defaultValue="1") Integer    curPage
            ,@RequestParam(value="searchWord", defaultValue="" ) String searchWord) {
        logger.info("bbswrite", locale);
      
        String boardnm = svrboard.getBoardName(boardcd);
        
        model.addAttribute("boardnm",boardnm);
        model.addAttribute("boardcd",boardcd);
        model.addAttribute("curPage",curPage);
        model.addAttribute("searchWord",searchWord);

        
        return "bbs/bbswrite";
    }
	
	@RequestMapping(value = "/bbswrite/{boardcd}", method = RequestMethod.POST)
    public String bbswriteget(Locale locale, Model model
            ,@PathVariable(value="boardcd") String boardcd
            ,@RequestParam(value="curPage"   , defaultValue="1") Integer    curPage
            ,@RequestParam(value="searchWord", defaultValue="" ) String searchWord
            ,@ModelAttribute ModelArticle article
            ,@ModelAttribute ModelUploadImage vo
            ,@RequestParam(value="userid",defaultValue="")String userid
            ,HttpSession session) {
        logger.info("bbswrite", locale);
      
        model.addAttribute("curPage",curPage);
        model.addAttribute("searchWord",searchWord);
        
        ModelUser user  = (ModelUser)session.getAttribute(WebConstants.SESSION_NAME);

        article.setUserid(user.getUserid());

        int result = -1;
        
        article.getContent().replaceAll("<br>", "\r\n");
       
        result = svrboard.insertArticle(article);
        
        
        Integer uploadno = null;
        
            try {
                vo.setFileName( vo.getImage().getOriginalFilename() );
                vo.setFileSize( (Long)vo.getImage().getSize() );
                vo.setArticleno(article.getArticleno());
                vo.setContentType( vo.getImage().getContentType() ); // 확장자
                vo.setImageBytes( vo.getImage().getBytes() );
                vo.setImageBase64( Base64.getEncoder().encodeToString( vo.getImage().getBytes() ) );
                
                uploadno = svrupload.insertPhoto(vo);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
                logger.error("bbswriteget" + e.getMessage() );
                throw e;
            } 


        if(result == 1){
            return "redirect:/bbs2/communityview/{boardcd}/"+article.getArticleno()+"?curPage="+curPage+"&earchWord="+searchWord;
        }
        else{
            return "redirect:/bbs2/community/free";
        }        
    }
	
	@RequestMapping(value = "/communityview/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String communityview(Model model
            ,@PathVariable(value="boardcd") String boardcd
            ,@PathVariable(value="articleno") Integer articleno
            ,@RequestParam(value="curPage",defaultValue="")int curPage
            ,@RequestParam(value="searchWord",defaultValue="") String searchWord) {
        logger.info("communityview");
        model.addAttribute("curPage",curPage);
        model.addAttribute("searchWord",searchWord);
        
        String boardnm = svrboard.getBoardName(boardcd);
        
        model.addAttribute("boardnm",boardnm);
        
        ModelArticle article = svrboard.transUpdateHitAndGetArticle(articleno);
        model.addAttribute("community",article);
        
        Date time = new Date();
        SimpleDateFormat changeFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("time",changeFormat.format(time));
        
        List<ModelComments> comment = svrboard.getCommentList(articleno);
        model.addAttribute("comment",comment);
        
        List<ModelUploadImage> ulimage = svrupload.getImageByteList(articleno);
        model.addAttribute("imagelist",ulimage);
        
        return "bbs/communityview";
    }
	
	@RequestMapping(value = "/communitymodify/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String communitymodify(Model model
            ,@PathVariable(value="boardcd") String boardcd
            ,@PathVariable(value="articleno") Integer articleno
            ,@RequestParam(value="curPage",defaultValue="")int curPage
            ,@RequestParam(value="searchWord",defaultValue="") String searchWord
            ) {
	    logger.info("communitymodifyw get");
	    
	    String boardnm = svrboard.getBoardName(boardcd);
        
        model.addAttribute("boardnm",boardnm);
	    
        model.addAttribute("curPage",curPage);
	    model.addAttribute("searchWord",searchWord);
	    
	    ModelArticle article = svrboard.transUpdateHitAndGetArticle(articleno);
	    String text = article.getContent();
	    String replaceText = "";
	    replaceText = text.replaceAll("<br>", "\r\n");
	    article.setContent(replaceText);
	    model.addAttribute("community",article);
	    
	    List<ModelUploadImage> upimg = svrupload.getImageByteList(articleno);
	    model.addAttribute("upimg",upimg);
        
        return "bbs/communitymodify";
    }
	
	@RequestMapping(value = "/communitymodify/{boardcd}/{articleno}", method = RequestMethod.POST)
    public String communitymodifypost(Model model
            ,@PathVariable(value="boardcd") String boardcd
            ,@PathVariable(value="articleno") Integer articleno
            ,HttpServletRequest request
            ,@ModelAttribute ModelArticle article
            ) {
	    logger.info("communitymodifyw post");
	    String curPage = request.getParameter("curPage");
	    String searchWord = request.getParameter("searchWord");
	    
	    model.addAttribute("curPage",curPage);
	    model.addAttribute("searchWord",searchWord);

	    model.addAttribute("boardcd",boardcd);
	    model.addAttribute("articleno",articleno);
	    
        ModelArticle updateValue = new ModelArticle();
        updateValue.setTitle(article.getTitle());
        String text = article.getContent();
        String replaceText = "";
        replaceText = text.replaceAll("\r\n","<br>");
        updateValue.setContent(replaceText);
        
        ModelArticle searchValue = new ModelArticle();
        searchValue.setArticleno(articleno);
        
        
        int result = svrboard.updateArticle(updateValue, searchValue);
        
        if(result == 1){
            return "redirect:/bbs2/communityview/{boardcd}/{articleno}?curPage="+curPage+"&searchWord="+searchWord;
        }else{
            return "bbs/communitymodify";
        }
     }
	
	@RequestMapping(value = "/communitydelete/{boardcd}/{articleno}", method = RequestMethod.POST)
    public String communitydelete(Model model
            ,@PathVariable(value="boardcd") String boardcd
            ,@PathVariable(value="articleno") Integer articleno
            ,@RequestParam(value="curPage",defaultValue="")int curPage
            ) {
        logger.info("communitydelete");
        
        model.addAttribute("curPage",curPage);
        
        ModelArticle  article = svrboard.getArticle(articleno);
        svrboard.deleteArticle(article);
        
        
        return "redirect:/bbs2/community/{boardcd}?curPage="+curPage;
    }
	
	@RequestMapping(value = "/commentadd", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> commentadd(Model model
            ,@RequestParam(value="articleno",defaultValue="-1") Integer articleno
            ,@RequestParam(value="text",defaultValue="")String text
            ,HttpSession session) {
        
	    ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
	    
	    Map<String, Object> map = new HashMap<String,Object>();
	    
	    logger.info("commentadd");
        ModelComments comments = new ModelComments(articleno,text);
        comments.setUserid(user.getUserid());
        
        int commentNo = svrboard.insertComment(comments);
        
        ModelComments aa = svrboard.getComment(svrboard.getCommentNo(comments));
        
        ModelComments comm = svrboard.getComment(aa.getCommentno());
      
        SimpleDateFormat changeFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        map.put("userid", comments.getUserid());
        map.put("content", comments.getMemo());
        map.put("time", changeFormat.format(comm.getRegdate()));
        map.put("num", comm.getCommentno());
        
        comments = svrboard.getComment(commentNo);
        model.addAttribute("comment",comments);
        
        return map;
           

    }
	
	@RequestMapping(value = "/commentupdate", method = RequestMethod.POST)
    @ResponseBody
    public int commentupdate(Model model
            ,@RequestParam(value="commentnoo",defaultValue="-1") Integer commentno
            ,@RequestParam(value="memo",defaultValue="")String memo
            ,HttpSession session
            ) {
       
	    logger.info("commentupdate");
	    
	    ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        
	    /*ModelComments commget = new ModelComments(commentno,text);*/
	    
	    ModelComments searchValue = svrboard.getComment(commentno);
	    ModelComments updateValue = new ModelComments();
	    updateValue.setMemo(memo);
	    int result = svrboard.updateComment(updateValue, searchValue);
	    
        return result;
           

    }
	@RequestMapping(value = "/commentdelete", method = RequestMethod.POST)
    @ResponseBody
    public int commentdelete(Model model
            ,@RequestParam(value="commentnoo",defaultValue="-1") Integer commentno
            ,HttpSession session
            ) {
       
	    logger.info("commentupdate");
	   
	    ModelComments comments  = svrboard.getComment(commentno);

	    int result = svrboard.deleteComment(comments);
	    
        return result;
           

	}
	
	@RequestMapping(value = "/deleteimgfile", method = RequestMethod.POST)
    @ResponseBody
    public int deleteimgfile(Model model
            ,@RequestParam(value="uploadImageNo",defaultValue="-1") Integer uploadImageNo
            ,@RequestParam(value="articleno",defaultValue="") Integer articleno
            ,HttpSession session
            ) {
       
        logger.info("deleteimgfile");
       
        ModelUploadImage img = svrupload.getImageByteOne(articleno, uploadImageNo);
        
        int result = svrupload.deletePhoto(img.getArticleno(), img.getUploadImageNo());
        
        return result;
           

    }
	
	
}
