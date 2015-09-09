package org.springframework.basics.section10

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledBean {

    int timesCalled

    public void scheduledMethod() {
        println "scheduled method"
        timesCalled++
    }

}
