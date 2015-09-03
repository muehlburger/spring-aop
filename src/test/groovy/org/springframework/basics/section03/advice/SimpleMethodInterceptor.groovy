package org.springframework.basics.section03.advice

import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation


public class SimpleMethodInterceptor implements MethodInterceptor {

    @Override
    Object invoke(MethodInvocation methodInvocation) throws Throwable {
        println "ksdfjksdfklg"
        def method = methodInvocation.proceed();
        println "ksdfjksdfklg"
        method
    }
}
