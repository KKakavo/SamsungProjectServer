package com.samsung.samsungProjectServer.service;

import com.samsung.samsungProjectServer.domain.User;

public interface UserService {

    User save(User user);

    User findUserByEmail(String email);

}
