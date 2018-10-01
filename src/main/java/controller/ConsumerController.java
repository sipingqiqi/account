package controller;

import AOP.Checklogin;
import SayHi.SayHi;
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

    @SayHi
    @RequestMapping("/login")
    @ResponseBody
        public String login(@RequestBody User user, HttpServletRequest request)throws Exception{
         //   httpSession = request.getSession();
            System.out.println("test login");
            String s= userDao.login(user);
            request.getSession().setAttribute("username",user.getUsername());
            return "reditect:/showTable";
    }

    @Checklogin
    @RequestMapping("/showTable")
    @ResponseBody
    public List<Consumer> showTable(HttpServletRequest request)throws Exception{
            Object value = request.getSession().getAttribute("username");
            List<Consumer>consumers= consumerDao.showtable(value.toString());

        return consumers;
    }

    @Checklogin
    @RequestMapping("/addItem")
    @ResponseBody
        public String addItem(@RequestBody Consumer consumer)throws Exception{

            System.out.println("test addItem");
            String s= consumerDao.additem(consumer);
            return "redirect:/success";

    }




}
