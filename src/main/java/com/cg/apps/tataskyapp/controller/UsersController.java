package com.cg.apps.tataskyapp.controllers;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.tataskyapp.dto.UsersDto;
import com.cg.apps.tataskyapp.entities.Users;
import com.cg.apps.tataskyapp.service.UsersService;
import com.cg.apps.tataskyapp.utils.UserAlreadyExistException;
import com.cg.apps.tataskyapp.utils.UserNotFoundException;



@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping
    public ResponseEntity<String> registerUsers(@RequestBody UsersDto users) {
        Users newUser = usersService.findUsersById(users.getId());
        if(newUser != null)
            throw new UserAlreadyExistException();
        usersService.registerUsers(users);
        return new ResponseEntity<String> ("User registered.....",HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateUsers(@RequestBody UsersDto users){
        Users newUsers = usersService.findUsersById(users.getId());
        if(newUsers == null)
            throw new UserNotFoundException();
        usersService.updateUsers(users);
        return new ResponseEntity<String> ("User updated.....",HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findUsersById(@PathVariable int id){
        Users newUsers = usersService.findUsersById(id);
        if(newUsers == null)
            throw new UserNotFoundException();
        else
            return new ResponseEntity<Users>(HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<String> findUsersByUsername(@PathVariable String username){
        Users newUsers = usersService.findUsersByUsername(username);
        if(newUsers == null)
            throw new UserNotFoundException();
        else
            return new ResponseEntity<String>("User details....",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsersByUserId(@PathVariable int id){
        Users newUsers = usersService.findUsersById(id);
        if(newUsers == null)
            throw new UserNotFoundException();
        usersService.deleteUsersByUserId(id);
        return new ResponseEntity<String>("User deleted.....",HttpStatus.OK);

    }
}