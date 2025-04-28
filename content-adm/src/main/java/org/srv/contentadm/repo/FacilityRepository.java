package org.srv.contentadm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.srv.contentadm.model.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility,Long> {
}
