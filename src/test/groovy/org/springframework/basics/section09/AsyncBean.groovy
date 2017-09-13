package org.springframework.basics.section09

import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.stereotype.Component

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future

@EnableAsync
@Component
public class AsyncBean {

    @Async
    public void methodWithoutReturnType() {
        AsyncTest.THREAD_LOCAL.set(true)

        println Thread.currentThread().id
        Thread.sleep(1000)
    }

    @Async
    public CompletableFuture<Object> methodWithReturnType() {
        AsyncTest.THREAD_LOCAL.set(true)
        println Thread.currentThread().id

        Thread.sleep(1000)
        return CompletableFuture.completedFuture(new Object())
    }

}
