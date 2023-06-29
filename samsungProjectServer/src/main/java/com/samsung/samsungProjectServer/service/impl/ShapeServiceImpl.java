package com.samsung.samsungProjectServer.service.impl;

import com.samsung.samsungProjectServer.domain.Shape;
import com.samsung.samsungProjectServer.domain.User;
import com.samsung.samsungProjectServer.repository.PointRepository;
import com.samsung.samsungProjectServer.repository.ShapeRepository;
import com.samsung.samsungProjectServer.repository.UserRepository;
import com.samsung.samsungProjectServer.service.ShapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShapeServiceImpl implements ShapeService {

    private static long controlSum = 2;
    private final ShapeRepository shapeRepository;
    private final PointRepository pointRepository;

    @Override
    @Transactional
    public Shape save(Shape shape) {
        shape.getPointList().forEach(shape::savePoint);
        controlSum++;
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
    @Transactional
    public List<Shape> saveAllShapes(List<Shape> shapeList) {
        shapeList.forEach(shape -> {
            shape.getPointList().forEach(shape::savePoint);
            shapeRepository.save(shape);
        });
        controlSum+=shapeList.size();
        return shapeList;
    }

    @Override
    @Transactional
    public List<Shape> getRecentShapes(long id, long controlSum) {
        if(ShapeServiceImpl.controlSum != controlSum)
            return shapeRepository.getRecentShapes(id);
        return new ArrayList<>();
    }

    @Override
    public long getControlSum() {
        return controlSum;
    }


}
