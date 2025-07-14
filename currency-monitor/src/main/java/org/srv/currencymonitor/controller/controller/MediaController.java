package org.srv.currencymonitor.controller.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Media operations")
public class MediaController {

    @Autowired
    private CurrencyBroadcastService currencyBroadcastService;

    @GetMapping
    @Operation(method = "Hand over currency data to external services", description = "Pull out Kafka topic data (currency)" +
            " and hand over to services on-demand")
    public ResponseEntity<String> getUpToDateAdvert() {
        var content = currencyBroadcastService.retrieveCurrencyToExternalServices();

        return ResponseEntity.ok()
                .header(HttpHeaders.ACCEPT, "")
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(content);
    }
}

