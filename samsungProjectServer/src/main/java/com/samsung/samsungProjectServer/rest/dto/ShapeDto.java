package com.samsung.samsungProjectServer.rest.dto;

import com.samsung.samsungProjectServer.domain.Point;
import com.samsung.samsungProjectServer.domain.Shape;
import com.samsung.samsungProjectServer.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShapeDto {


    private long id;
    private User user;
    private int color;
    private List<PointDto> pointList;

    public static ShapeDto toDto(Shape shape){
        return ShapeDto.builder()
                .id(shape.getId())
                .user(shape.getUser())
                .pointList(shape.getPointList()
                        .stream()
                        .map(PointDto::toDto)
                        .collect(Collectors.toList()))
                .color(shape.getColor())
                .build();
    }

    public static Shape toDomainObject(ShapeDto shapeDto){
        return Shape.builder()
                .id(shapeDto.getId())
                .user(shapeDto.getUser())
                .pointList(shapeDto.getPointList()
                        .stream()
                        .map(PointDto::toDomainObject)
                        .collect(Collectors.toList()))
                .color(shapeDto.getColor())
                .build();
    }
}
