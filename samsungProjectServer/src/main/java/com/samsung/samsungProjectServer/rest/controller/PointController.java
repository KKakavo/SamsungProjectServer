package com.samsung.samsungProjectServer.rest.controller;

import com.samsung.samsungProjectServer.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;
}
