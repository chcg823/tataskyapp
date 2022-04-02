package com.cg.apps.tataskyapp.controller;


import com.cg.apps.tataskyapp.dto.UsersDisplayDto;
import com.cg.apps.tataskyapp.dto.UsersDto;
import com.cg.apps.tataskyapp.dto.UsersDtoForAcc;
import com.cg.apps.tataskyapp.entities.Users;
import com.cg.apps.tataskyapp.service.UsersService;
import com.cg.apps.tataskyapp.utils.UserAlreadyExistException;
import com.cg.apps.tataskyapp.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping
    public ResponseEntity<String> registerUsers(@RequestBody UsersDto users) {
        Users newUser = usersService.findUsersById(users.getId());
        if (newUser != null)
            throw new UserAlreadyExistException();
        usersService.registerUsers(users);
        return new ResponseEntity<String>("User registered.....", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateUsers(@RequestBody UsersDto users) {
        Users newUsers = usersService.findUsersById(users.getId());
        if (newUsers == null)
            throw new UserNotFoundException();
        usersService.updateUsers(users);
        return new ResponseEntity<String>("User updated.....", HttpStatus.OK);

    }

    @GetMapping("/find-id/{id}")
    public ResponseEntity<UsersDtoForAcc> findUsersById(@PathVariable Long id) {
        Users newUsers = usersService.findUsersById(id);
        if (newUsers == null)
            throw new UserNotFoundException();
        UsersDtoForAcc usersDtoForAcc = new UsersDtoForAcc(newUsers);
        return new ResponseEntity<UsersDtoForAcc>(usersDtoForAcc, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UsersDisplayDto> findUsersByUsername(@PathVariable String username) {
        Users newUsers = usersService.findUsersByUsername(username);
        if (newUsers == null)
            throw new UserNotFoundException();
        UsersDisplayDto usersDisplayDto = new UsersDisplayDto(newUsers);
        return new ResponseEntity<>(usersDisplayDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<String> deleteUsersByUserId(@PathVariable Long id) {
        Users newUsers = usersService.findUsersById(id);
        if (newUsers == null)
            throw new UserNotFoundException();
        usersService.deleteUsersByUserId(id);
        return new ResponseEntity<String>("User deleted.....", HttpStatus.OK);

    }
}