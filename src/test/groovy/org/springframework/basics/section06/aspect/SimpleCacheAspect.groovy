package org.springframework.basics.section06.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
@Aspect
class SimpleCacheAspect {

    @Pointcut("execution(* getSophisticatedString(..))")
    public void myPointcut(){}

    @Around("org.springframework.basics.section06.aspect.SimpleCacheAspect.myPointcut()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {

        "${pjp.proceed()}INTERCEPTED".toString()

    }

}



