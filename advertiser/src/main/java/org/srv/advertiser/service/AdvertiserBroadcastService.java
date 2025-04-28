package org.srv.advertiser.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class AdvertiserBroadcastService {

    private final ConcurrentLinkedDeque<byte[]> buffer = new ConcurrentLinkedDeque<>();

    @KafkaListener(topics = "video-content", groupId = "advert1")
    public void consume(byte[] body) {
        buffer.push(body);
    }

    public byte[] retrieveVideoToExternalServices() {
        byte[] latestVideo;
        try {
            latestVideo = buffer.pop();
        } catch (NoSuchElementException e) {
            return null;
        }
        return latestVideo;
    }
}
