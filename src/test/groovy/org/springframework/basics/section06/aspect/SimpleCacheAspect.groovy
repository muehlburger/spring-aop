package org.springframework.basics.section06.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


/**
 * See: <a href="https://blog.espenberntsen.net/2010/03/20/aspectj-cheat-sheet/">aspectj-cheat-sheet</a>
 *
 */
// TODO Annotate
class SimpleCacheAspect {

    // TODO Annotate
    public void myPointcut(){}


    // TODO Annotate (reference Pointcut)
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {

        "${pjp.proceed()}INTERCEPTED".toString()

    }

}



