package com.samsung.samsungProjectServer.service;

import com.samsung.samsungProjectServer.domain.Point;

import java.util.List;

public interface PointService {
    Point save(Point point);
    List<Point> getAllPoints();
}
