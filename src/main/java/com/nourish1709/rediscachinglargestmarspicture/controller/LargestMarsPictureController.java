package com.nourish1709.rediscachinglargestmarspicture.controller;

import com.nourish1709.rediscachinglargestmarspicture.feign.LargestMarsPictureClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/mars/pictures/")
@Log4j2
@RequiredArgsConstructor
public class LargestMarsPictureController {

    private final LargestMarsPictureClient largestMarsPictureClient;

    @GetMapping(value = "largest", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getLargestMarsPicture(
            @RequestParam("sol") int sol, @RequestParam(value = "camera", required = false) String camera) {
        log.info("Received a GET request to {}. Sol: {}, Camera: {}",
                ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUriString(), sol, camera);
        return ResponseEntity.ok(largestMarsPictureClient.getLargestMarsPicture(sol, camera));
    }
}
