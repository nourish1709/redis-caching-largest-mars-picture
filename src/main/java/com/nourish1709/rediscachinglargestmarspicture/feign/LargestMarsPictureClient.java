package com.nourish1709.rediscachinglargestmarspicture.feign;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "largest-mars-picture-client", url = "${mars.pictures.path}")
public interface LargestMarsPictureClient {

    @GetMapping("${mars.pictures.largest}")
    @Cacheable("largestPicture")
    byte[] getLargestMarsPicture(
            @RequestParam("sol") int sol, @RequestParam(value = "camera", required = false) String camera);
}
