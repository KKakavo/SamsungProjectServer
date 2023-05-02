package com.samsung.samsungProjectServer.service.impl;

import com.samsung.samsungProjectServer.repository.ShapeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShapeServiceImpl {

    private final ShapeRepository shapeRepository;

}
