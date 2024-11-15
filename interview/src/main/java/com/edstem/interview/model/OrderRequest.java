package com.edstem.interview.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderRequest {
    @NonNull
    private List<Item> items;
}
