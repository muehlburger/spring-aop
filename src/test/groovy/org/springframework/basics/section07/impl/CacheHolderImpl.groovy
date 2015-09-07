package org.springframework.basics.section07.impl

import org.springframework.basics.section07.interfaces.MyCacheHolder
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
class CacheHolderImpl implements MyCacheHolder {

    Map cache

    @PostConstruct
    void prefetchCache() {
        cache = ["a":"<<a>>CACHED", "b":"<<b>>CACHED"]
    }

}
