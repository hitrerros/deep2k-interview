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
public class CurrenciesController {
    @Autowired
    private ContentBroadcastService contentBroadcastService;

    @GetMapping("/currencies")
    public ResponseEntity<String> sendCurrency(){
        contentBroadcastService.sendCurrencyToConsumers();
        return ResponseEntity.ok("");
    }
}
