package com.samsung.samsungProjectServer.service.impl;

import com.samsung.samsungProjectServer.domain.Point;
import com.samsung.samsungProjectServer.domain.Shape;
import com.samsung.samsungProjectServer.repository.PointRepository;
import com.samsung.samsungProjectServer.repository.ShapeRepository;
import com.samsung.samsungProjectServer.service.ShapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ShapeServiceImpl implements ShapeService {

    private final ShapeRepository shapeRepository;
    private final PointRepository pointRepository;

    @Override
    @Transactional
    public Shape save(Shape shape) {
        shape.getPointList().forEach(shape::savePoint);
        return shapeRepository.save(shape);
    }

    @Override
    @Transactional
    public List<Shape> getShapesByUserId(long id) {
        return shapeRepository.findByUserId(id);
    }

    @Override
    @Transactional
    public List<Shape> getAllShapes() {
        return shapeRepository.findAll();
    }

    @Override
    public List<Shape> saveAllShapes(List<Shape> shapeList) {
        List<Shape> savedShapes = new ArrayList<>();
        for (Shape shape : shapeList) {
            savedShapes.add(save(shape));
        }
        return savedShapes;
    }

}
