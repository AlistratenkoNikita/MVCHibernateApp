package ua.com.alistratenko.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@Aspect
public class DaoSessionLifeCycle {

    @Before(value = "execution(* ua.com.alistratenko.dao.UserDaoImp.listUsers(..))")
    public void logBefore(JoinPoint joinPoint){

        System.out.println("izi");
    }
}
