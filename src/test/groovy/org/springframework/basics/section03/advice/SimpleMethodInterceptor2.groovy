package org.springframework.basics.section03.advice

import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation


class SimpleMethodInterceptor2 implements MethodInterceptor {

    @Override
    Object invoke(MethodInvocation methodInvocation) throws Throwable {
        println("SimpleMethodInterceptor2")

        try {
            methodInvocation.proceed()
        } catch (RuntimeException e) {
        }
       return 4
    }
}
