package org.springframework.basics.section03.advice

import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation


class SimpleMethodInterceptor implements MethodInterceptor {

    @Override
    Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            methodInvocation.proceed()
        } catch (RuntimeException e) {
            println(e.stackTrace)
        }
       return 4
    }
}
