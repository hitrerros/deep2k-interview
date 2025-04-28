package org.srv.advertiser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.srv.advertiser.service.AdvertiserBroadcastService;

@RestController
@RequestMapping("/")
public class MediaController {

    @Autowired
    private AdvertiserBroadcastService advertiserBroadcastService;

    @GetMapping
    public ResponseEntity<byte[]> getUpToDateAdvert() {
        var content = advertiserBroadcastService.retrieveVideoToExternalServices();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "")
                .contentType(MediaType.valueOf(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .body(content);
    }
}

