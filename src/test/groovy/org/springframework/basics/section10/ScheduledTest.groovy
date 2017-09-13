package org.springframework.basics.section10

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = TestConfiguration)
class ScheduledTest extends Specification {

    @Autowired
    private ScheduledBean scheduledBean

    def "@Scheduled Test"() {
        expect:
            Thread.sleep(6000)
            scheduledBean.timesCalled >= 5
    }

    @Configuration
    @ComponentScan("org.springframework.basics.section10")
    @EnableScheduling
    public static class TestConfiguration {
    }




}
