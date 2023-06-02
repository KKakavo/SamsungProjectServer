package com.samsung.samsungProjectServer.repository;

import com.samsung.samsungProjectServer.domain.Shape;
import com.samsung.samsungProjectServer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u ORDER BY u.score DESC LIMIT 50")
    List<User> getLeaderboard();
    @Modifying
    @Query("UPDATE User u SET u.score = :score WHERE u.id = :id")
    void updateScoreById(@Param("id")long id, @Param("score")long score);
}
