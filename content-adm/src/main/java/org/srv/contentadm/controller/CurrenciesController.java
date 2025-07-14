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
@Tag(name = "Currency operations")
public class CurrenciesController {
    @Autowired
    private ContentBroadcastService contentBroadcastService;

    @Operation(summary = "Fan-out currency", description = "Multiple sending currency data to constumers via Kafka")
    @GetMapping("/currencies")
    public ResponseEntity<String> sendCurrency(){
        contentBroadcastService.sendCurrencyToConsumers();
        return ResponseEntity.ok("");
    }
}
