package com.mm.mdc.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "config-client")
public interface ConfigFeign {

    @RequestMapping(value = "/env", method = RequestMethod.GET)
    String getConfigEnv();

}
