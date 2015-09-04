package org.springframework.basics.section05.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect


@Aspect
class SimpleAspect {

//    @Around("execution(* org.springframework.basics.section05.impl.SimpleService.doSomeStuff(..))")
    @Around("execution(* *(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        def returned
        try {
            println "klsdjfl"
            returned = pjp.proceed()
            println "klsdjfl"
            throw new RuntimeException()
        } catch (ignored) {
        } finally {
            return returned
        }
    }
}
