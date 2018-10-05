package controller;

import AOP.Checklogin;
import RestResponse.RESTResponse;
import consumerDao.ConsumerDao;
import org.springframework.web.bind.annotation.*;
import springTest.Consumer;

import userDao.UserDao;
import users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ConsumerController {
    private User user;

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    private ConsumerDao consumerDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    public void setConsumerDao(ConsumerDao consumerDao) {
       this.consumerDao = consumerDao;
    }

    @RequestMapping("/register")
    @ResponseBody
    public RESTResponse<String>register(@RequestBody User user)throws Exception{
        System.out.println("register a user");
        RESTResponse<String> restResponse =new RESTResponse<String>();
        user.setValid("Y");
        String s = userDao.addUser(user);
        if(s!=null){
            restResponse.setData("succeed to register a user!");
        }else {
            restResponse.setData("please change a username!");
        }
        return restResponse;
    }


    @RequestMapping("/login")
    @ResponseBody
    public RESTResponse<User>login(@RequestBody User user, HttpServletRequest request)throws Exception {
        System.out.println("test login");
        RESTResponse<User> restResponse = new RESTResponse<User>();
        User s = userDao.login(user);
        request.getSession().setAttribute("username", s.getUsername());
        request.getSession().setAttribute("id",s.getId());
        restResponse.setData(s);
        return restResponse;
    }


    @Checklogin
    @RequestMapping(value = "/showTable",method = RequestMethod.GET)
    @ResponseBody
    public RESTResponse<List<Consumer>> showTable(HttpServletRequest request)throws Exception{
            Object value = request.getSession().getAttribute("username");
            List<Consumer>consumers= consumerDao.showtable(value.toString());
            RESTResponse<List<Consumer>> restResponse= new RESTResponse<List<Consumer>>();
            restResponse.setData(consumers);
        return restResponse;
    }

    @Checklogin
    @RequestMapping("/addItem")
    @ResponseBody
        public String addItem(@RequestBody Consumer consumer,HttpServletRequest request)throws Exception{
            Object value = request.getSession().getAttribute("id");
            consumer.setUserId((Integer)value);
            consumer.setValid("Y");
            System.out.println("addItem");
            String s = consumerDao.additem(consumer);
            return "redirect:/success";


    }


    @Checklogin
    @RequestMapping("/logout")
    @ResponseBody
    public RESTResponse<String> logout(HttpServletRequest request)throws Exception{
        request.getSession().setAttribute("username","null");
        RESTResponse<String> restResponse =new RESTResponse<String>();
        restResponse.setData("succeed to logout!");
        return restResponse;
    }

    
    @Checklogin
    @RequestMapping("/showtablebyUser")
    @ResponseBody
    public RESTResponse<List<User>>showtablebyUser(HttpServletRequest request)throws Exception{
        System.out.println("Ready to test");
        Object value = request.getSession().getAttribute("id");
        List<User>users=userDao.showTable((Integer)value);
        System.out.println((Integer)value);
        RESTResponse<List<User>> restResponse = new RESTResponse<List<User>>();
        restResponse.setData(users);
        return restResponse;
    }


}
