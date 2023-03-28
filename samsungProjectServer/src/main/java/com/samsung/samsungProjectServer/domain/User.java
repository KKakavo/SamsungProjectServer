package com.samsung.samsungProjectServer.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email", unique = true)
    private String email;


    @Column(name = "password")
    private String password;

    @Column(name = "points")
    private int points;

}
