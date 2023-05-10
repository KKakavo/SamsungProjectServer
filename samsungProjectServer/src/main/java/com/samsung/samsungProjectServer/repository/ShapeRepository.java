package com.samsung.samsungProjectServer.repository;

import com.samsung.samsungProjectServer.domain.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShapeRepository extends JpaRepository<Shape, Long> {
    List<Shape> findByUserId(long id);
}
