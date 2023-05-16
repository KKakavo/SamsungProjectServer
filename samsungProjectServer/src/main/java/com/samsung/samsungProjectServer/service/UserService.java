package com.samsung.samsungProjectServer.service;

import com.samsung.samsungProjectServer.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findUserByEmail(String email);

    User updateUserScoreById(long id, int score);
    User findUserById(long id);
    List<User> getLeaderBoard();
}
