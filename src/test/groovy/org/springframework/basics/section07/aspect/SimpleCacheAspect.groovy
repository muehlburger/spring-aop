package org.springframework.basics.section07.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.basics.section07.interfaces.MyCacheHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Aspect
class SimpleCacheAspect {

    @Autowired
    MyCacheHolder cacheHolder

    // TODO capture argument (args(capturedArgument)) and set joinpoint
    public Object profile(ProceedingJoinPoint pjp, String capturedArgument) throws Throwable {

        def cachedValue = cacheHolder.getCache().get(capturedArgument)

        // TODO Implement Cache


        return null

    }


}
