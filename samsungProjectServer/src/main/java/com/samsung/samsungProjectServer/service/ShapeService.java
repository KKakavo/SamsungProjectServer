package com.samsung.samsungProjectServer.service;

import com.samsung.samsungProjectServer.domain.Shape;

import java.util.List;

public interface ShapeService {
    Shape save(Shape shape);
    List<Shape> getShapesByUserId(long id);
    List<Shape> getAllShapes();
    List<Shape> saveAllShapes(List<Shape> shapeList);
}
