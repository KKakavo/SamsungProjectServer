package com.samsung.samsungProjectServer.service;

import com.samsung.samsungProjectServer.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findUserByEmail(String email);

    User findUserById(long id);
    List<User> getLeaderboard();
    void updateUserScoreById(long id, long score);
    void updateUserLocationById(long id, double latitude, double longitude);
}
