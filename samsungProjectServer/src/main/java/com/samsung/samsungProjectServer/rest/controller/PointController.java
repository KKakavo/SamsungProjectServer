package com.samsung.samsungProjectServer.rest.controller;

import com.samsung.samsungProjectServer.domain.Point;
import com.samsung.samsungProjectServer.rest.dto.PointDto;
import com.samsung.samsungProjectServer.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;
    @PostMapping("/point")
    public PointDto savePoint(@RequestBody PointDto pointDto){
        Point point = pointService.save(PointDto.toDomainObject(pointDto));
        return PointDto.toDto(pointService.save(point));
    }
    @GetMapping("/point/all")
    public List<PointDto> getAllPoints(){
        return pointService.getAllPoints().stream().map(PointDto::toDto).collect(Collectors.toList());
    }
}
