package com.samsung.samsungProjectServer.rest.controller;

import com.samsung.samsungProjectServer.domain.Point;
import com.samsung.samsungProjectServer.domain.Shape;
import com.samsung.samsungProjectServer.domain.User;
import com.samsung.samsungProjectServer.rest.dto.ShapeDto;
import com.samsung.samsungProjectServer.service.ShapeService;
import com.samsung.samsungProjectServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ShapeController {

    private final ShapeService shapeService;
    private final UserService userService;

    @PostMapping("/shape")
    public ShapeDto saveShape(@RequestBody ShapeDto shapeDto, @RequestParam("score") long score){
        Shape shape = shapeService.save(ShapeDto.toDomainObject(shapeDto));
        userService.updateUserScoreById(shape.getUser().getId(), score);
        return ShapeDto.toDto(shape);
    }
    @PostMapping("/shape/all")
    public List<ShapeDto> saveAllShapes(@RequestBody List<ShapeDto> shapeDtoList, @RequestParam("score") long score){
        List<Shape> shapeList = shapeService.saveAllShapes(shapeDtoList.stream().map(ShapeDto::toDomainObject).collect(Collectors.toList()));
        User user = shapeList.get(0).getUser();
        Point point = shapeList.get(shapeList.size() - 1).getPointList().get(0);
        userService.updateUserScoreById(user.getId(), score);
        userService.updateUserLocationById(user.getId(), point.getLatitude(), point.getLongitude());
        return shapeList.stream().map(ShapeDto::toDto).collect(Collectors.toList());
    }
    @GetMapping("/shape/user/{id}")
    public List<ShapeDto> getShapesByUserId(@PathVariable("id") long id){
        return shapeService
                .getShapesByUserId(id)
                .stream()
                .map(ShapeDto::toDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/shape/all")
    public List<ShapeDto> getAllShapes(){
        return shapeService.getAllShapes().stream().map(ShapeDto::toDto).collect(Collectors.toList());
    }
    @GetMapping("/shape/recent")
    public List<ShapeDto> getRecentShapes(@RequestParam("id") long id, @RequestParam("control_sum") long controlSum){
        return shapeService.getRecentShapes(id, controlSum).stream().map(ShapeDto::toDto).collect(Collectors.toList());
    }
    @GetMapping("/shape/sum")
    public long getControlSum(){
        return shapeService.getControlSum();
    }

}
