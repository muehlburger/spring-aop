package org.springframework.basics.section08.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component


@Aspect
@Component
@Order(value = 2)
class InspectCacheAspect {

    @Around("execution(* doSomething(..))")
    public Object inspectCacheable(ProceedingJoinPoint pjp){
        return pjp.proceed()
    }



}
