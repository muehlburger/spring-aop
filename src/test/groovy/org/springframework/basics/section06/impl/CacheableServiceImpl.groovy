package org.springframework.basics.section06.impl


import org.springframework.basics.section06.interfaces.CacheableService
import org.springframework.stereotype.Component

@Component
class CacheableServiceImpl implements CacheableService {


    @Override
    public String getSophisticatedString(String value) {
        "<<${value}>>"
    }
}
