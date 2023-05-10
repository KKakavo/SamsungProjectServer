package com.samsung.samsungProjectServer.rest.controller;

import com.samsung.samsungProjectServer.domain.Shape;
import com.samsung.samsungProjectServer.rest.dto.ShapeDto;
import com.samsung.samsungProjectServer.service.ShapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ShapeController {

    private final ShapeService shapeService;

    @PostMapping("/shape")
    public ShapeDto saveShape(@RequestBody ShapeDto shapeDto){
        Shape shape = shapeService.save(ShapeDto.toDomainObject(shapeDto));
        return ShapeDto.toDto(shape);
    }
    @PostMapping("/shape/all")
    public List<ShapeDto> saveAllShapes(@RequestBody List<ShapeDto> shapeDtoList){
        List<Shape> shapeList = shapeService.saveAllShapes(shapeDtoList.stream().map(ShapeDto::toDomainObject).collect(Collectors.toList()));
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
        List<ShapeDto> shapeDtoList= new ArrayList<>();
        for (Shape shape : shapeService.getAllShapes()) {
            shapeDtoList.add(ShapeDto.toDto(shape));
        }
        return shapeDtoList;
    }

}
