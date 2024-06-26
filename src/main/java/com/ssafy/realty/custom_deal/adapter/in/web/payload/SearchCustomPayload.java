package com.ssafy.realty.custom_deal.adapter.in.web.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SearchCustomPayload {
    @NotNull
    String type;
    @NotNull
    String value;
}
