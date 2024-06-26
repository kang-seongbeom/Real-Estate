package com.ssafy.realty.realty.application.port.common_dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarkerDto {
    private Double lat;
    private Double lng;
    private String address;
    private DtoMarkerFilter filter;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DtoMarkerFilter {
        private PayloadDateRange date;
        private PayloadDealAmountRange dealAmount;
        private PayloadAreaRange area;
        private List<PayloadTransportation> transportations;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class PayloadDateRange {
            private String lower;
            private String upper;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class PayloadDealAmountRange {
            private Long lower;
            private Long upper;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class PayloadAreaRange {
            private Double lower;
            private Double upper;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class PayloadTransportation {
            private String type;
            private Integer time;
        }
    }
}
