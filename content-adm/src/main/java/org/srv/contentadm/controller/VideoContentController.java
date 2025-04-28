package org.srv.contentadm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.srv.contentadm.service.ContentBroadcastService;

@RestController
public class VideoContentController {

    @Autowired
    private ContentBroadcastService contentBroadcastService;

    @GetMapping("/video")
    public String sendVideo() {
        contentBroadcastService.sendVideoToConsumers();
        return "Message sent to Kafka topic!";
    }

    @PostMapping("/video")
    public ResponseEntity<String> uploadVideo(@RequestBody byte[] content) {
        Long id = contentBroadcastService.uploadVideo(content);
        return ResponseEntity.ok()
                .header(HttpHeaders.ACCEPT, "")
                .contentType(MediaType.TEXT_PLAIN)
                .body(id.toString());
    }
}
