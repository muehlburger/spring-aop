package org.springframework.basics.section09

import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Component

import java.util.concurrent.Future

@Component
public class AsyncBean {

    public void methodWithoutReturnType() {
        AsyncTest.THREAD_LOCAL.set(true)

        println Thread.currentThread().id
        Thread.sleep(1000)
    }

    public Object methodWithReturnType() {
        AsyncTest.THREAD_LOCAL.set(true)
        println Thread.currentThread().id

        Thread.sleep(1000)
        return new Object()
    }

}
