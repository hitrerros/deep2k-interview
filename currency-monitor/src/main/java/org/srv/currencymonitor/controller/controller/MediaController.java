package org.srv.currencymonitor.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.srv.currencymonitor.service.CurrencyBroadcastService;

@RestController
@RequestMapping("/")
public class MediaController {

    @Autowired
    private CurrencyBroadcastService currencyBroadcastService;

    @GetMapping
    public ResponseEntity<String> getUpToDateAdvert() {
        var content = currencyBroadcastService.retrieveCurrencyToExternalServices();

        return ResponseEntity.ok()
                .header(HttpHeaders.ACCEPT, "")
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(content);
    }
}

