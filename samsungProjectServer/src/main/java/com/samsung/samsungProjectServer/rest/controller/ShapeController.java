package com.samsung.samsungProjectServer.rest.controller;

import com.samsung.samsungProjectServer.service.ShapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShapeController {

    private final ShapeService shapeService;

}
