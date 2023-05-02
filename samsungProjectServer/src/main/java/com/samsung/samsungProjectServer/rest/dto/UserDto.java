package com.samsung.samsungProjectServer.rest.dto;

import com.samsung.samsungProjectServer.domain.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    private String email;

    private String nickname;

    private String password;

    private String role;

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
