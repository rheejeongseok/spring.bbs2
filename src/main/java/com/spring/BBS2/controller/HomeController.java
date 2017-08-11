package com.spring.BBS2.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.spring.BBS2.model.ModelUser;
import com.spring.BBS2.service.IServiceUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IServiceUser svruser;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Locale locale, Model model) {
        logger.info("INDEX", locale);
      
        return "bbs/index";
    }
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Locale locale, Model model) {
        logger.info("about", locale);
      
        return "bbs/about";
    }
	
	@RequestMapping(value = "/room", method = RequestMethod.GET)
    public String room(Locale locale, Model model) {
        logger.info("room", locale);
      
        return "bbs/room";
    }

	@RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(Locale locale, Model model) {
        logger.info("info", locale);
      
        return "bbs/info";
    }
	@RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join(Locale locale, Model model) {
        logger.info("join", locale);
      
        return "bbs/join";
    }
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinaction(Locale locale, Model model
            ,@ModelAttribute ModelUser user
            ,HttpSession session) {
        logger.info("join result", locale);
        
        model.addAttribute("user",user);
        
        int result = svruser.insertUser(user);
        
        if(result == 1 ){
            return "redirect:/joinresult";
        }else{
            return "/join";
        }

    }
	@RequestMapping(value = "/joinresult", method = RequestMethod.GET)
    public String joinresult(Locale locale, Model model) {
        logger.info("join", locale);
      
        return "bbs/joinresult";
    }
	
	@RequestMapping(value = "/checkuserid", method = RequestMethod.POST)
	@ResponseBody
    public int checkid(Model model
            ,@RequestParam(value="userid",defaultValue="")String userid) {
        logger.info("checkuserid");
        
        int result = svruser.checkuserid(userid);
        
        return result;
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model
            ,@RequestParam(value="url",defaultValue="") String url
            ,HttpServletRequest request
            ,HttpSession session) {
        logger.info("login get");
      
        if(session.getAttribute(WebConstants.SESSION_NAME) != null){
            return "redirect:/";
        }
        
        if(url.isEmpty())
            url = request.getHeader("Referer");
            model.addAttribute("url",url);
        
        return "bbs/login";
    }
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginaction(Model model
            ,@RequestParam(value="url",defaultValue="") String url
            ,@RequestParam(value="userid",defaultValue="") String userid
            ,@RequestParam(value="password",defaultValue="") String password
            ,HttpSession session) {
        logger.info("login post");

        ModelUser result = svruser.login(userid,password);
        
        if(result != null){
            session.setAttribute(WebConstants.SESSION_NAME, result);
            if(url.isEmpty()){
                return "redirect:/";
            }else{
                return "redirect:"+url;
            }
        }else{
            return "redirect:/login?url="+url;
        }
        
    }*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
    public int loginaction(Model model
            ,@RequestParam(value="url",defaultValue="") String url
            ,@RequestParam(value="userid",defaultValue="") String userid
            ,@RequestParam(value="password",defaultValue="") String password
            ,HttpSession session) {
        logger.info("login post");

        ModelUser user = svruser.login(userid, password);
        
        if(user != null){
            session.setAttribute(WebConstants.SESSION_NAME, user);
            return 1;
        }
        else{
            return 0;
        }
        
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model,HttpSession session) {
        logger.info("login get");
      
        session.removeAttribute(WebConstants.SESSION_NAME);
        
        return "redirect:/";
    }
	
	@RequestMapping(value = "/cuser", method = RequestMethod.GET)
    public String cuser(Model model,HttpSession session
            ,@RequestParam(value="password",defaultValue="") String password) {
        logger.info("cuser get");
      
            return "bbs/cuser";
        
        
        
    }
	
	@RequestMapping(value = "/cuser", method = RequestMethod.POST)
    public String cuserpost(Model model,HttpSession session
            ,@RequestParam(value="password",defaultValue="") String password) {
        logger.info("cuser post");
      
        ModelUser useraa = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        
        ModelUser user = svruser.selectUser(useraa.getUserno());
        
        String userpwd = user.getPassword();
        
        if(userpwd.equals(password)){
            return "redirect:/myinfo";
        }
        else{
            return "bbs/cuser";
        }
        
        
    }
	
	@RequestMapping(value = "/myinfo", method = RequestMethod.GET)
    public String myinfo(Locale locale, Model model
            ,HttpSession session) {
        logger.info("myinfo", locale);
        
        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        
        model.addAttribute("user",user);
        
        return "bbs/myinfo";
    }
	
	@RequestMapping(value = "/usermodify", method = RequestMethod.GET)
    public String usermodify(Locale locale, Model model
            ,HttpSession session) {
        logger.info("usermodify get", locale);
        
        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        
        model.addAttribute("user",user);
        
        return "bbs/usermodify";
    }
	
	@RequestMapping(value = "/usermodify", method = RequestMethod.POST)
    public String usermodify(Locale locale, Model model
            ,@ModelAttribute ModelUser updateValue
            ,HttpSession session) {
        logger.info("usermodify post");
        ModelUser searchValue = (ModelUser)session.getAttribute(WebConstants.SESSION_NAME);
        
        if(searchValue == null){
            return "redirect:/login";
        }
        
        
        int result = svruser.updateUserInfo(updateValue, searchValue);
        
        if(result == 1){
            session.setAttribute(WebConstants.SESSION_NAME, svruser.selectUser(searchValue.getUserno()));
            return "redirect:/myinfo";
        }else{
            return "bbs/usermodify";
        }
        
    }
	
	@RequestMapping(value = "/userdelete", method = RequestMethod.POST)
	@ResponseBody
    public int userdelete(Model model
            ,@RequestParam(value="userid",defaultValue="") String userid
            ,@RequestParam(value="password",defaultValue="") String password
            ,HttpSession session) {
        logger.info("pwdmodify get");
        
        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        String uid = user.getUserid();
        String upwd = user.getPassword();
        
        if(userid.equals(uid) && password.equals(upwd)){
            
            session.removeAttribute(WebConstants.SESSION_NAME);
            svruser.deleteUser(user);
            
            return 1;
        }else{
            
            return 0;
        }
        
        
       
    }
	
	@RequestMapping(value = "/pwdmodify", method = RequestMethod.GET)
    public String pwdmodify(Locale locale, Model model
            ,HttpSession session) {
        logger.info("pwdmodify get");
        
        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        
        if(user == null){
            return "redirect:/user/login";
        }
        
        model.addAttribute("user",user);
        
        return "bbs/pwdmodify";
    }
	
	@RequestMapping(value = "/pwdmodify", method = RequestMethod.POST)
    public String pwdmodifypost(Locale locale, Model model
            ,@RequestParam(value="curPassword",defaultValue="") String curPassword
            ,@RequestParam(value="newPassword",defaultValue="") String newPassword
            ,HttpSession session) {
        logger.info("pwdmodify post");
        ModelUser user = (ModelUser)session.getAttribute(WebConstants.SESSION_NAME);
       
        int result = svruser.updatePasswd(newPassword, curPassword, user.getUserid());
        
        if(result == 1){
            session.setAttribute(WebConstants.SESSION_NAME, svruser.selectUser(user.getUserno()));
            return "bbs/pwdmodify_ok";
        }else{
            return "redirect:/bbs/pwdmodify";
        }
        
    }
	
	@RequestMapping(value = "/tour", method = RequestMethod.GET)
    public String tour(Locale locale, Model model) {
        logger.info("tour", locale);
      
        return "bbs/tour";
    }
	
	@RequestMapping(value = "/reservation-info", method = RequestMethod.GET)
    public String reservationinfo(Locale locale, Model model) {
        logger.info("reservation-info", locale);
      
        return "bbs/reservation-info";
    }
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation(Locale locale, Model model) {
        logger.info("reservation", locale);
      
        return "bbs/reservation";
    }
	@RequestMapping(value = "/service", method = RequestMethod.GET)
    public String service(Locale locale, Model model) {
        logger.info("service", locale);
      
        return "bbs/service";
    }
	@RequestMapping(value = "/byebye", method = RequestMethod.GET)
    public String byebye(Locale locale, Model model) {
        logger.info("byebye", locale);
      
        return "bbs/byebye";
    }
	
	
	
}
