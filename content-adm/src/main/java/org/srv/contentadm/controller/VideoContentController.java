package org.srv.contentadm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Video operations")
public class VideoContentController {

    @Autowired
    private ContentBroadcastService contentBroadcastService;

    @Operation(summary = "Send video", description = "sends all moderated video to consumers")
    @GetMapping("/video")
    public String sendVideo() {
        contentBroadcastService.sendVideoToConsumers();
        return "Message sent to Kafka topic!";
    }

    @Operation(summary = "Upload video", description = "Upload video to db")
    @PostMapping("/video")
    public ResponseEntity<String> uploadVideo(@RequestBody byte[] content) {
        Long id = contentBroadcastService.uploadVideo(content);
        return ResponseEntity.ok()
                .header(HttpHeaders.ACCEPT, "")
                .contentType(MediaType.TEXT_PLAIN)
                .body(id.toString());
    }
}
