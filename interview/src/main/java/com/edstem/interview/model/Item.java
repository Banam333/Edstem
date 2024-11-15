package com.edstem.interview.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Item {
    @NonNull
    private String productCode;
    @NonNull
    private Integer quantity;
    @NonNull
    private Double unitPrice;
}
