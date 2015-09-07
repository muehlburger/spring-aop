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

    @Around("@annotation(org.springframework.basics.section07.annotation.MyCacheable) && args(capturedArgument)")
    public Object profile(ProceedingJoinPoint pjp, String capturedArgument) throws Throwable {

        def cachedValue = cacheHolder.getCache().get(capturedArgument)

        if (cachedValue != null) {

            return cachedValue
        } else {
            def returnValue = pjp.proceed()
            String value = "${returnValue}CACHED"
            cacheHolder.getCache().put(capturedArgument,value)
            return returnValue
        }

    }


}
