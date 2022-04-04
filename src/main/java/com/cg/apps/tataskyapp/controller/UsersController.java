package com.cg.apps.tataskyapp.controller;


import com.cg.apps.tataskyapp.dao.UsersDao;
import com.cg.apps.tataskyapp.dto.UsersDisplayDto;
import com.cg.apps.tataskyapp.dto.UsersDto;
import com.cg.apps.tataskyapp.dto.UsersDtoForAcc;
import com.cg.apps.tataskyapp.entities.Users;
import com.cg.apps.tataskyapp.service.UsersService;
import com.cg.apps.tataskyapp.utils.UserAlreadyExistException;
import com.cg.apps.tataskyapp.utils.UserNotFoundException;
import com.cg.apps.tataskyapp.utils.UsernameAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    UsersDao usersDao;

    @PostMapping
    public ResponseEntity<String> registerUsers(@RequestBody UsersDto users) {
        Users newUser = usersService.findUsersById(users.getId());
        if (newUser != null)
            throw new UserAlreadyExistException();
        List<Users> userslist = usersDao.findAll();
        for (Users user : userslist) {
            if (users.getUsername().equals(user.getUsername())) {
                throw new UsernameAlreadyExistException();
            }
        }
        //if(users.getUsername()== newUser.getUsername())
        //throw new UsernameAlreadyExistException();
        usersService.registerUsers(users);
        return new ResponseEntity<String>("User registered.....", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateUsers(@RequestBody UsersDto users) {
        Users newUsers = usersService.findUsersById(users.getId());
        if (newUsers == null)
            throw new UserNotFoundException();
        List<Users> userslist = usersDao.findAll();
        for (Users user : userslist) {
            if (users.getUsername().equals(user.getUsername())) {
                throw new UsernameAlreadyExistException();
            }
        }
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
        Optional<Users> newUsers = usersService.findUsersByUsername(username);
        Users urs = newUsers.orElse(null);
        if (urs == null)
            throw new UserNotFoundException();
        UsersDisplayDto usersDisplayDto = new UsersDisplayDto(urs);
        return new ResponseEntity<UsersDisplayDto>(usersDisplayDto, HttpStatus.OK);
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