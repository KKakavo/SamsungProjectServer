package com.samsung.samsungProjectServer.rest.dto;

import com.samsung.samsungProjectServer.domain.Point;
import com.samsung.samsungProjectServer.domain.Shape;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PointDto {


    private long id;
    private double latitude;
    private double longitude;
    public static PointDto toDto(Point point) {
        return PointDto.builder()
                .id(point.getId())
                .latitude(point.getLatitude())
                .longitude(point.getLongitude())
                .build();
    }

    public static Point toDomainObject(PointDto pointDto){
        return Point.builder()
                .id(pointDto.getId())
                .latitude(pointDto.getLatitude())
                .longitude(pointDto.getLongitude())
                .build();
    }

}
