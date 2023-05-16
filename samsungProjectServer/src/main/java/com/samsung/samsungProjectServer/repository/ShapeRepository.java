package com.samsung.samsungProjectServer.repository;

import com.samsung.samsungProjectServer.domain.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShapeRepository extends JpaRepository<Shape, Long> {
    List<Shape> findByUserId(long id);

    @Query("SELECT s FROM Shape s WHERE s.id > :id")
    List<Shape> getRecentShapes(@Param("id") long id);

}
