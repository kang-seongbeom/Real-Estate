package com.ssafy.realty.realty.adapter.in.web.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SavePayload {

    @NotNull
    @Size(min = 2)
    String title;

    List<MarkerPayload> markers;
}
