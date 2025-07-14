package org.srv.contentadm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.srv.contentadm.service.ModerationService;

@RestController("moderation/")
@Tag(name = "Advert & facilities operations")
public class ModerationController {

    @Autowired
    private ModerationService moderationService;

    @Operation(summary = "Update advert status", description = "Updates advert status (moderated = true | false)")
    @PatchMapping("/adverts/{id}/{status}")
    public ResponseEntity<Void> updateStatusForAdvert(@PathVariable("id") Long id,
                                                      @PathVariable("status") Boolean moderationStatus) {
        moderationService.updateStatusForAdvert(id, moderationStatus);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update facilities status", description = "Updates facilities status (moderated = true | false)")
    @PatchMapping("/facilities/{id}/{status}")
    public ResponseEntity<Void> updateStatusForFacilities(@PathVariable("id") Long id,
                                                          @PathVariable("status") Boolean moderationStatus) {
        moderationService.updateStatusForFacilities(id, moderationStatus);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}