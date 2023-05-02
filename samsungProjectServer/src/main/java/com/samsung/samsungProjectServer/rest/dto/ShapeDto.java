package com.samsung.samsungProjectServer.rest.dto;

import com.samsung.samsungProjectServer.domain.Point;
import com.samsung.samsungProjectServer.domain.Shape;
import com.samsung.samsungProjectServer.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShapeDto {


    private User user;

    private List<Point> pointList;

    public static ShapeDto toDto(Shape shape){
        return ShapeDto.builder()
                .pointList(shape.getPointList())
                .build();
    }

    public static Shape toDomainObject(ShapeDto shapeDto){
        return Shape.builder()
                .pointList(shapeDto.getPointList())
                .build();
    }
}
