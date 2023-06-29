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
    private long score;
    private String role;
    private double latitude;
    private double longitude;

    public static UserDto toDto(User user){

        return UserDto.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .password(user.getPassword())
                .score(user.getScore())
                .role(user.getRole())
                .latitude(user.getLatitude())
                .longitude(user.getLongitude())
                .build();

    }

    public static User toDomainObject(UserDto userDto){

        return User.builder()
                .id(userDto.getId())
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .score(userDto.getScore())
                .role(userDto.getRole())
                .latitude(userDto.getLatitude())
                .longitude(userDto.getLongitude())
                .build();

    }

}
