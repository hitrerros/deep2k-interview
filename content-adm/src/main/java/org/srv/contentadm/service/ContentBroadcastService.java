package org.srv.contentadm.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srv.contentadm.model.Currency;
import org.srv.contentadm.model.Facility;
import org.srv.contentadm.model.Video;
import org.srv.contentadm.repo.CurrencyRepository;
import org.srv.contentadm.repo.FacilityRepository;
import org.srv.contentadm.repo.VideoRepository;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContentBroadcastService {

    private static final String VIDEO_CONTENT_TOPIC = "video-content";
    private static final String CURRENCY_TOPIC = "currency-content";

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private KafkaProducer<String, byte[]> advertProducer;
    @Autowired
    private KafkaProducer<String, Set<Currency>> currencyProducer;
    @Autowired
    private KafkaProducer<String, Set<Facility>> facilityProducer;

    public void sendVideoToConsumers() {
        var availableVideos =
                videoRepository
                        .findAll()
                        .stream()
                        .filter(p -> p.getModerated().equals(true))
                        .toList();

        Video videoToSend = availableVideos.get(new Random().nextInt(availableVideos.size()));
        ProducerRecord<String, byte[]> record = new ProducerRecord<>(VIDEO_CONTENT_TOPIC,
                videoToSend.getId().toString(),
                videoToSend.getContent());
        advertProducer.send(record);
    }

    public Long uploadVideo(byte[] body) {
        return videoRepository.save(Video.builder().content(body).moderated(false).build()).getId();
    }

    public void sendCurrencyToConsumers() {
        Set<Currency> currencies = new HashSet<>(currencyRepository.findAll());
        ProducerRecord<String, Set<Currency>> record = new ProducerRecord<>(CURRENCY_TOPIC,
                "",
                currencies);
        currencyProducer.send(record);
    }

    public void sendFacilitiesToConsumers() {
        Set<Facility> facilities = facilityRepository
                .findAll()
                .stream()
                .filter(p -> p.getModerated().equals(true))
                .collect(Collectors.toSet());

        ProducerRecord<String, Set<Facility>> record = new ProducerRecord<>(CURRENCY_TOPIC,
                "",
                facilities);
        facilityProducer.send(record);
    }

}
