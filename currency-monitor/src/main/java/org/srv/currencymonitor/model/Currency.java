package org.srv.currencymonitor.model;

import lombok.Data;

@Data
public class Currency {
    private String code;
    private String name;
    private Double buy;
    private Double sell;
}
