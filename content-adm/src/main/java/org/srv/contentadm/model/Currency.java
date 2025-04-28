package org.srv.contentadm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="currencies")
public class Currency {
    @Id
    private String code;
    private String name;
    private Double buy;
    private Double sell;
}
