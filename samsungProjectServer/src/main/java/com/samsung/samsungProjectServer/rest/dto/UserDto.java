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


    private final String email;

    private final String nickname;

    private final String password;

    private final String role;

    public static UserDto toDto(User user){

        return UserDto.builder()
                .nickname(user.getNickname())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();

    }

    public static User toDomainObject(UserDto userDto){

        return User.builder()
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();

    }

}
