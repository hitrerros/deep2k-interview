package org.srv.contentadm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.srv.contentadm.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency,String> {
}
