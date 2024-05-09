package com.sb_webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.util.HtmlUtils;

import com.sb_webapp.formBeans.LoginBean;
import com.sb_webapp.formBeans.Message;
import com.sb_webapp.service.DBService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController {
    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @Autowired
    DBService dbService;

    private final String HOME = "/tabs/home";
    private final String ABOUT = "/tabs/about";
    private final String PROJECTS = "/tabs/projects";
    private final String CONTACT = "/tabs/contact";
    private final String LOGIN = "/tabs/login";

    private final String FLAG = "/sec/flag";
    private final String MSGCONFIRM = "/default/messageConfirmation";
    private final String ERROR = "/error";

    @GetMapping(value={"/", "/home"})
    public String home(ModelMap model){
        //String ip = request.getRemoteAddr();
        //dbService.updateVisits(ip);
        return HOME;
    }

    @GetMapping("/about")
    public String about(){
        return ABOUT;
    }

    @GetMapping("/projects")
    public String projects(){
        return PROJECTS;
    }

    @GetMapping("/contact")
    public ModelAndView contact(){
        return new ModelAndView(CONTACT, "message", new Message());
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String submitMessage(@ModelAttribute("message") Message message,
                                 BindingResult result, ModelMap model,
                                 HttpServletRequest request){

        if(result.hasErrors()){
            log.error(result.toString());
            return ERROR;
        }

        String ip = request.getRemoteAddr();
        int port = request.getRemotePort();
        String name = message.getUserName().trim();
        String email = message.getUserEmail().trim();
        String msg = message.getUserMessage().trim();

        log.info("MSG SUBMITTED : " +ip+":"+port+ ", NAME: " +name+ ", EMAIL: "+email+", MESSAGE: " +msg);
        dbService.saveMessage(ip+":"+port, name, msg);

        name = HtmlUtils.htmlEscape(name);
        model.put("userName", name);
        return MSGCONFIRM;
    }




    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView(LOGIN, "login", new LoginBean());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginRequest(@ModelAttribute("login") LoginBean loginBean,
                               BindingResult result, ModelMap model,
                               HttpServletRequest request){
        String userid = loginBean.getUsername().trim();
        String userpwd = loginBean.getPassword();
        System.out.println("/loginRequest() POST, cred:" + userid + userpwd);
        return HOME;
    }



    @RequestMapping(value="/flag", method=RequestMethod.GET)
    public String ctf(){
        return FLAG;
    }

}