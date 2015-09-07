package org.springframework.basics.section07.impl

import org.springframework.basics.section07.annotation.MyCacheable
import org.springframework.basics.section07.interfaces.CacheableService
import org.springframework.stereotype.Component

@Component
class CacheableServiceImpl implements CacheableService {


    @Override
    @MyCacheable
    public String getSophisticatedString(String value) {
        "<<${value}>>"
    }
}
