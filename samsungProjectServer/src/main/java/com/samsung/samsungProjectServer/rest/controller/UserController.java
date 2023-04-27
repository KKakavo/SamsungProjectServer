package com.samsung.samsungProjectServer.rest.controller;

import com.samsung.samsungProjectServer.domain.User;
import com.samsung.samsungProjectServer.exception.UserAlreadyExistsException;
import com.samsung.samsungProjectServer.exception.UserNotFoundException;
import com.samsung.samsungProjectServer.rest.dto.UserDto;
import com.samsung.samsungProjectServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserDto saveUser(@RequestBody UserDto userDto){

        User user = userService.save(UserDto.toDomainObject(userDto));

        return UserDto.toDto(user);

    }

    @GetMapping("/user")
    public UserDto getUserByEmail(@RequestParam String email){

        User user = userService.findUserByEmail(email);

        return UserDto.toDto(user);
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable("id") long id){

        User user = userService.findUserById(id);

        return UserDto.toDto(user);

    }

    @ExceptionHandler({UserAlreadyExistsException.class, UserNotFoundException.class})
    public ResponseEntity<String> handlerUserException(Exception e){

        return ResponseEntity.badRequest().body(e.getMessage());

    }

}
