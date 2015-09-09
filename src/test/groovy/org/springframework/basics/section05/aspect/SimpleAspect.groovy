package org.springframework.basics.section05.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

@Aspect
class SimpleAspect {

    @Around("execution(* *.doSomeStuff(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {

        println "skldfklsdklf"
        pjp.proceed()
    }
}
