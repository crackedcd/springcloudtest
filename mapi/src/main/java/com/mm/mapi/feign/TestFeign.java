package com.mm.mapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "mdc")
public interface TestFeign {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromMdc(@RequestParam(value = "name") String name);

}
