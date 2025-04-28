package org.srv.contentadm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srv.contentadm.repo.FacilityRepository;
import org.srv.contentadm.repo.VideoRepository;

@Service
public class ModerationService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private FacilityRepository facilityRepository;

    public void updateStatusForAdvert(Long id, Boolean moderationStatus) {
        var curr = videoRepository.findById(id);
        curr.ifPresent(v -> {
            v.setModerated(moderationStatus);
            videoRepository.save(v);
        });
    }

    public void updateStatusForFacilities(Long id, Boolean moderationStatus) {
        var curr = facilityRepository.findById(id);
        curr.ifPresent(v -> {
            v.setModerated(moderationStatus);
            facilityRepository.save(v);
        });
    }
}
