package checkloginImpl;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Component
@Aspect
public class checkloginimpl {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(AOP.Checklogin)")
    public void Pointcut(){

    }
    @Before("Pointcut()")
    public Object checkloginimpling(JoinPoint joinPoint)throws Throwable{
        System.out.println("reday to test");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = (String) request.getSession().getAttribute("username");
        if(username==null){
            System.out.println("false addItem");
            return "/false to login";
        }else{
            System.out.println(username);
            return joinPoint;
        }
    }



}


