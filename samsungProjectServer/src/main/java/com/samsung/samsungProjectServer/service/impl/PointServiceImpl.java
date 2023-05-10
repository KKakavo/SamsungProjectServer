package com.samsung.samsungProjectServer.service.impl;

import com.samsung.samsungProjectServer.domain.Point;
import com.samsung.samsungProjectServer.repository.PointRepository;
import com.samsung.samsungProjectServer.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;

    @Override
    public Point save(Point point) {

        return pointRepository.save(point);
    }

    @Override
    public List<Point> getAllPoints() {
        return pointRepository.findAll();
    }
}
