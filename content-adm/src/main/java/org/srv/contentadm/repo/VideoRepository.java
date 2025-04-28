package org.srv.contentadm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.srv.contentadm.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
