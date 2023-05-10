package com.samsung.samsungProjectServer.rest.dto;

import com.samsung.samsungProjectServer.domain.Shape;
import com.samsung.samsungProjectServer.domain.User;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private long id;
    private String email;
    private String nickname;
    private String password;
    private String role;

    public static UserDto toDto(User user){

        return UserDto.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();

    }

    public static User toDomainObject(UserDto userDto){

        return User.builder()
                .id(userDto.getId())
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();

    }

}
