package com.ssafy.realty.custom_deal.application.service.mapper;

import com.ssafy.realty.custom_deal.application.port.in.dto.*;
import com.ssafy.realty.custom_deal.application.port.out.dto.CustomSummaryDto;
import com.ssafy.realty.custom_deal.application.port.out.dto.wrap.CustomSummaryDtos;
import com.ssafy.realty.custom_deal.domain.*;
import com.ssafy.realty.custom_deal.domain.wrap.Summaries;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomServiceMapper {

    public CustomCatalog mapToCustomCatalog(CustomCatalogDto customCatalogDto){
        return CustomCatalog.init(customCatalogDto.getPageable());
    }

    public OwnCustomCatalog mapToOwnCustomCatalog(OwnCustomCatalogDto ownCustomCatalogDto){
        return OwnCustomCatalog.init(ownCustomCatalogDto.getUserId(), ownCustomCatalogDto.getPageable());
    }

    public CustomSummaryDtos mapToCustomSummaryDtos(Summaries summaries) {
        List<CustomSummaryDto> data = summaries.getData()
                .stream()
                .map(this::mapToCustomSummaryDto)
                .collect(Collectors.toList());

        return new CustomSummaryDtos(data);
    }

    public IsOwner mapToIsOwner(IsOwnerDto isOwnerDto){
        return IsOwner.init(isOwnerDto.getUserId(), isOwnerDto.getCustomId());
    }

    public Search mapToSearch(SearchCustomDto searchCustomDto) {
        return Search.init(searchCustomDto.getSearchType(), searchCustomDto.getValue(), searchCustomDto.getPageable());
    }

    public ViewIncrease mapToViewIncrease(ViewIncreaseDto viewIncreaseDto) {
        return ViewIncrease.init(viewIncreaseDto.getCustomId());
    }

    public StarCustom mapToStarIncrease(StarCustomDto starCustomDto) {
        return StarCustom.init(starCustomDto.getUserId(), starCustomDto.getCustomId());
    }

    public OwnStarCustom mapToOwnStarCustom(OwnStarCustomDto ownStarCustomDto) {
        return OwnStarCustom.init(ownStarCustomDto.getUserId(), ownStarCustomDto.getPageable());
    }

    private CustomSummaryDto mapToCustomSummaryDto(Summary summary) {
        return CustomSummaryDto
                .builder()
                .id(summary.getCustomSummaryId().getValue())
                .author(summary.getCustomSummaryData().getAuthor())
                .title(summary.getCustomSummaryData().getTitle())
                .look(summary.getCustomSummaryData().getLook())
                .start(summary.getCustomSummaryData().getStart())
                .createDate(summary.getCustomSummaryData().getCreateDate())
                .build();
    }
}
