package org.srv.currencymonitor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {
    private String code;
    private String name;
    private Double buy;
    private Double sell;
}
