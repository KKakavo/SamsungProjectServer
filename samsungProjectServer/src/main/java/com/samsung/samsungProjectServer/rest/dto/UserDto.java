package com.samsung.samsungProjectServer.rest.dto;

import com.samsung.samsungProjectServer.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public class UserDto {

    private final long id;

    private final String email;

    private final String nickname;

    private final String password;

    private final int points;

    public static UserDto toDto(User user){

        return UserDto.builder().id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .password(user.getPassword())
                .points(user.getPoints())
                .build();

    }

    public static User toDomainObject(UserDto userDto){

        return User.builder().id(userDto.getId())
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .points(userDto.getPoints())
                .build();

    }

}
