package org.springframework.basics.section09

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.util.concurrent.Executor
import java.util.concurrent.Future

@ContextConfiguration(classes = TestConfiguration)
class AsyncTest extends Specification {

    public static ThreadLocal<Boolean> THREAD_LOCAL = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false
        }
    }

    @Autowired
    private AsyncBean asyncBean

    def "@Async Test"() {
        expect:
            println Thread.currentThread().id
            asyncBean.methodWithoutReturnType()
            Future<Object> future = asyncBean.methodWithReturnType()

            future.get()

            !THREAD_LOCAL.get()
    }

    @Configuration
    @ComponentScan("org.springframework.basics.section09")
    public static class TestConfiguration implements AsyncConfigurer {

        @Override
        Executor getAsyncExecutor() {
            def executor = new ThreadPoolTaskExecutor()
            executor.initialize()

            return executor
        }

        @Override
        AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
            return new SimpleAsyncUncaughtExceptionHandler()
        }

    }




}
