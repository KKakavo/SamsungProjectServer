package com.samsung.samsungProjectServer.repository;

import com.samsung.samsungProjectServer.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
}
