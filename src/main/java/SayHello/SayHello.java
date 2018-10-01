package SayHello;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SayHello {

    //定义一个Pointcut
    @Pointcut("@annotation(SayHi.SayHi)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public void Sayhello(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("Your are ready to login.");
        joinPoint.proceed();
        System.out.println("Success to login." );
    }






}




