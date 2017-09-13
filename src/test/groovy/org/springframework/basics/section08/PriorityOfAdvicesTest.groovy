package org.springframework.basics.section08

import org.springframework.aop.framework.Advised
import org.springframework.basics.section08.interfaces.SomeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.core.Ordered
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

@ContextConfiguration(classes=TestConfiguration)
class PriorityOfAdvicesTest extends Specification  {

    @Autowired
    SomeService service

    @Unroll
    def "Cache Advice is the first one in the advice chain"() {

        expect:

            println service.doSomething("value")
            isCacheAdviceFirst(service)
    }

    private boolean isCacheAdviceFirst(def advisedObject) {
        if (advisedObject instanceof Advised) {
            def advisors = ((Advised)advisedObject).getAdvisors()
            return advisors.collect { it.advice.toString() }.get(0).contains("CacheInterceptor")
        }
        return false
    }


    @Configuration
    @EnableAspectJAutoProxy
    @ComponentScan(basePackages="org.springframework.basics.section08")
    public static class TestConfiguration {

        @Bean
        public CacheManager cacheManager() {
            // configure and return an implementation of Spring's CacheManager SPI
            SimpleCacheManager cacheManager = new SimpleCacheManager();
            cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("default")))

            return cacheManager;
        }

    }

}
